package net.minecraft.src;

import org.lwjgl.opengl.GL11;

/**
 * 特殊描画の置き換えクラス（RenderPlayerAPIが無い時用）
 */
public class EPS_RenderPlayer extends RenderPlayer {

	protected MMM_ModelBaseSolo modelMain;
	protected MMM_ModelBaseDuo modelFATT;
	

	public EPS_RenderPlayer() {
		super();
		
		// モデルの置き換え
//		EPS_EntityCaps lcaps = new EPS_EntityCaps(null);
		modelFATT = new MMM_ModelBaseDuo(this);
		modelFATT.isModelAlphablend = true;
		modelFATT.isRendering = true;
		modelFATT.textureInner = new ResourceLocation[4];
		modelFATT.textureOuter = new ResourceLocation[4];
//		modelFATT.setEntityCaps(lcaps);
		modelMain = new MMM_ModelBaseSolo(this);
		modelMain.isModelAlphablend = true;
		modelMain.capsLink = modelFATT;
		modelMain.textures = new ResourceLocation[4];
//		modelMain.setEntityCaps(lcaps);
		setRenderPassModel(modelFATT);
		
		mainModel = modelMain;
	}

	@Override
	protected int setArmorModel(AbstractClientPlayer par1EntityPlayer, int par2, float par3) {
		// アーマーの表示設定
		modelFATT.renderParts = par2;
		modelFATT.renderCount = 0;
		ItemStack is = par1EntityPlayer.getCurrentArmor(par2);
		if (is != null && is.stackSize > 0) {
			modelFATT.showArmorParts(par2);
			return is.isItemEnchanted() ? 15 : 1;
		}
		
		return -1;
	}

	@Override
	protected void preRenderCallback(EntityLivingBase par1EntityLiving, float par2) {
		Float lscale = (Float)modelMain.getCapsValue(MMM_IModelCaps.caps_ScaleFactor);
		if (lscale != null) {
			GL11.glScalef(lscale, lscale, lscale);
		}
	}

	public void setModelValues(EntityLivingBase par1EntityLiving,
			double par2, double par4, double par6, float par8, float par9,
			MMM_IModelCaps pEntityCaps, MMM_ITextureEntity pTextureData) {
		if (pTextureData != null) {
			modelMain.model = ((MMM_TextureBox)pTextureData.getTextureBox()[0]).models[0];
			modelMain.textures = pTextureData.getTextures(0);
			modelFATT.modelInner = ((MMM_TextureBox)pTextureData.getTextureBox()[1]).models[1];
			modelFATT.modelOuter = ((MMM_TextureBox)pTextureData.getTextureBox()[1]).models[2];
			modelFATT.textureInner = pTextureData.getTextures(1);
			modelFATT.textureOuter = pTextureData.getTextures(2);
			modelFATT.textureInnerLight = pTextureData.getTextures(3);
			modelFATT.textureOuterLight = pTextureData.getTextures(4);
		}
		modelMain.setEntityCaps(pEntityCaps);
		modelFATT.setEntityCaps(pEntityCaps);
		modelMain.setRender(this);
		modelFATT.setRender(this);
		modelMain.showAllParts();
		modelFATT.showAllParts();
		modelMain.isAlphablend = true;
		modelFATT.isAlphablend = true;
		modelMain.renderCount = 0;
		modelFATT.renderCount = 0;
		modelMain.lighting = modelFATT.lighting = par1EntityLiving.getBrightnessForRender(par8);
		
		modelMain.setCapsValue(MMM_IModelCaps.caps_heldItemLeft, (Integer)0);
		modelMain.setCapsValue(MMM_IModelCaps.caps_heldItemRight, (Integer)0);
		modelMain.setCapsValue(MMM_IModelCaps.caps_onGround, renderSwingProgress(par1EntityLiving, par9));
		modelMain.setCapsValue(MMM_IModelCaps.caps_isRiding, par1EntityLiving.isRiding());
		modelMain.setCapsValue(MMM_IModelCaps.caps_isSneak, par1EntityLiving.isSneaking());
		modelMain.setCapsValue(MMM_IModelCaps.caps_aimedBow, false);
		modelMain.setCapsValue(MMM_IModelCaps.caps_isWait, false);
		modelMain.setCapsValue(MMM_IModelCaps.caps_isChild, par1EntityLiving.isChild());
		modelMain.setCapsValue(MMM_IModelCaps.caps_entityIdFactor, 0F);
		modelMain.setCapsValue(MMM_IModelCaps.caps_ticksExisted, par1EntityLiving.ticksExisted);
	}

	@Override
	public void func_130009_a(AbstractClientPlayer entityplayer,
			double d, double d1, double d2, float f, float f1) {
		
		EPS_EntityCaps lcaps = mod_EPS_PlayerFormSkinLoad2.getEntityCaps(entityplayer);
		if (lcaps == null) {
			return;
		}
		setModelValues(entityplayer, d, d1, d2, f, f1, lcaps, lcaps);
//		modelMain.setEntityCaps(lcaps);
//		modelFATT.setEntityCaps(lcaps);
		
//		MMM_TextureBox lbox;
//		lbox = MMM_TextureManager.instance.getTextureBox(lcaps.textureBox[0]);
//		modelMain.model = lbox.models[0];
//		modelMain.textures = lcaps.textures[0];
//		lbox = MMM_TextureManager.instance.getTextureBox(lcaps.textureBox[1]);
//		modelFATT.modelInner = lbox.models[1];
//		modelFATT.modelOuter = lbox.models[2];
//		modelFATT.textureInner = lcaps.textures[1];
//		modelFATT.textureOuter = lcaps.textures[2];
		// TODO:毎時処理だと重い
		lcaps.setTextureNames();
		
		((EPS_EntityCaps)modelMain.entityCaps).setOwner(entityplayer);
//		modelMain.setRender(this);
//		modelMain.isAlphablend = true;
//		modelFATT.isAlphablend = true;
//		modelMain.lighting = modelFATT.lighting = entityplayer.getBrightnessForRender(f);
		
		ItemStack lis = entityplayer.getCurrentEquippedItem();
		int lheldR = lis != null ? 1 : 0;
		boolean laimbow = false;
		if (lis != null && entityplayer.getItemInUseCount() > 0) {
			EnumAction lea = lis.getItemUseAction();
			
			if (lea == EnumAction.block) {
				lheldR = 3;
			} else if (lea == EnumAction.bow) {
				laimbow = true;
			}
		}
		
		modelMain.setCapsValue(MMM_IModelCaps.caps_heldItemLeft, (Integer)0);
		modelMain.setCapsValue(MMM_IModelCaps.caps_heldItemRight, lheldR);
		modelMain.setCapsValue(MMM_IModelCaps.caps_onGround, renderSwingProgress(entityplayer, f1));
		modelMain.setCapsValue(MMM_IModelCaps.caps_isRiding, entityplayer.isRiding());
		modelMain.setCapsValue(MMM_IModelCaps.caps_isSneak, entityplayer.isSneaking());
		modelMain.setCapsValue(MMM_IModelCaps.caps_aimedBow, laimbow);
		modelMain.setCapsValue(MMM_IModelCaps.caps_isWait, false);
		modelMain.setCapsValue(MMM_IModelCaps.caps_isChild, entityplayer.isChild());
		modelMain.setCapsValue(MMM_IModelCaps.caps_entityIdFactor, (Float)0F);
		modelMain.setCapsValue(MMM_IModelCaps.caps_ticksExisted, entityplayer.ticksExisted);
		
		super.func_130009_a(entityplayer, d, d1, d2, f, f1);
		
		
	}

	@Override
	protected void renderModel(EntityLivingBase par1EntityLiving, float par2,
			float par3, float par4, float par5, float par6, float par7) {
		if (!par1EntityLiving.isInvisible()) {
			modelMain.setArmorRendering(true);
		} else {
			modelMain.setArmorRendering(false);
		}
		// アイテムのレンダリング位置を獲得するためrenderを呼ぶ必要がある
		mainModel.render(par1EntityLiving, par2, par3, par4, par5, par6, par7);
	}

	@Override
	protected void renderSpecials(AbstractClientPlayer par1EntityPlayer, float par2) {
		// ハードポイントの描画
		modelMain.renderItems(par1EntityPlayer, this);
		MMM_Client.renderArrowsStuckInEntity(par1EntityPlayer, par2, this, modelMain.model);
	}

	@Override
	protected int getColorMultiplier(EntityLivingBase par1EntityLivingBase,
			float par2, float par3) {
		modelFATT.renderCount = 16;
		return super.getColorMultiplier(par1EntityLivingBase, par2, par3);
	}

	@Override
	protected int inheritRenderPass(EntityLivingBase par1EntityLivingBase,
			int par2, float par3) {
		modelFATT.renderCount = 16;
		return super.inheritRenderPass(par1EntityLivingBase, par2, par3);
	}

}
