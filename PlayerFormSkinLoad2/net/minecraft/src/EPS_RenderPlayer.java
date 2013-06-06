package net.minecraft.src;

import org.lwjgl.opengl.GL11;

/**
 * 特殊描画の置き換えクラス（RenderPlayerAPIが無い時用）
 */
public class EPS_RenderPlayer extends RenderPlayer {

	protected MMM_ModelBaseDuo modelMain;
	protected MMM_ModelBaseDuo modelFATT;
	

	public EPS_RenderPlayer() {
		super();
		
		// モデルの置き換え
//		EPS_EntityCaps lcaps = new EPS_EntityCaps(null);
		modelFATT = new MMM_ModelBaseDuo(this);
		modelFATT.isModelAlphablend = true;
		modelFATT.isRendering = true;
		modelFATT.textureInner = new String[4];
		modelFATT.textureOuter = new String[4];
//		modelFATT.setEntityCaps(lcaps);
		modelMain = new MMM_ModelBaseDuo(this);
		modelMain.isModelAlphablend = true;
		modelMain.capsLink = modelFATT;
		modelMain.textureInner = new String[4];
//		modelMain.setEntityCaps(lcaps);
		setRenderPassModel(modelFATT);
		
		mainModel = modelMain;
	}

	@Override
	protected int setArmorModel(EntityPlayer par1EntityPlayer, int par2, float par3) {
		// アーマーの表示設定
		modelFATT.renderParts = par2;
		ItemStack is = par1EntityPlayer.getCurrentArmor(par2);
		if (is != null && is.stackSize > 0) {
			modelFATT.showArmorParts(par2);
			return is.isItemEnchanted() ? 15 : 1;
		}
		
		return -1;
	}

	@Override
	protected void preRenderCallback(EntityLiving par1EntityLiving, float par2) {
		Float lscale = (Float)modelMain.getCapsValue(MMM_IModelCaps.caps_ScaleFactor);
		if (lscale != null) {
			GL11.glScalef(lscale, lscale, lscale);
		}
	}

	@Override
	public void renderPlayer(EntityPlayer entityplayer, double d, double d1,
			double d2, float f, float f1) {
		
		EPS_EntityCaps lcaps = mod_EPS_PlayerFormSkinLoad2.getEntityCaps(entityplayer);
		if (lcaps == null) {
			return;
		}
		modelMain.setEntityCaps(lcaps);
		modelFATT.setEntityCaps(lcaps);
		MMM_TextureBox lbox = MMM_TextureManager.instance.getTextureBox("Player_SkinLoad2");
//		MMM_TextureBox lbox = MMM_TextureManager.getTextureBox("Crafter_Steve");
		if (lbox != null) {
			lcaps.texture = lbox;
			modelMain.modelInner = lbox.models[0];
			modelMain.textureInner[0] = lbox.getTextureName(0x0c);
			modelFATT.modelInner = lbox.models[1];
			modelFATT.modelOuter = lbox.models[2];
			modelFATT.textureInner[0] = lbox.getArmorTextureName(true, entityplayer.getCurrentArmor(0));
			modelFATT.textureInner[1] = lbox.getArmorTextureName(true, entityplayer.getCurrentArmor(1));
			modelFATT.textureInner[2] = lbox.getArmorTextureName(true, entityplayer.getCurrentArmor(2));
			modelFATT.textureInner[3] = lbox.getArmorTextureName(true, entityplayer.getCurrentArmor(3));
			modelFATT.textureOuter[0] = lbox.getArmorTextureName(false, entityplayer.getCurrentArmor(0));
			modelFATT.textureOuter[1] = lbox.getArmorTextureName(false, entityplayer.getCurrentArmor(1));
			modelFATT.textureOuter[2] = lbox.getArmorTextureName(false, entityplayer.getCurrentArmor(2));
			modelFATT.textureOuter[3] = lbox.getArmorTextureName(false, entityplayer.getCurrentArmor(3));
		}
		
		((EPS_EntityCaps)modelMain.entityCaps).setOwner(entityplayer);
		modelMain.setRender(this);
		modelMain.isAlphablend = true;
		modelFATT.isAlphablend = true;
		
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
		
		super.renderPlayer(entityplayer, d, d1, d2, f, f1);
		
		
	}

	@Override
	protected void renderModel(EntityLiving par1EntityLiving, float par2,
			float par3, float par4, float par5, float par6, float par7) {
		if (!par1EntityLiving.isInvisible()) {
			
			loadDownloadableImageTexture(par1EntityLiving.skinUrl, par1EntityLiving.getTexture());
			modelMain.setArmorRendering(true);
		} else {
			modelMain.setArmorRendering(false);
		}
		// アイテムのレンダリング位置を獲得するためrenderを呼ぶ必要がある
		mainModel.render(par1EntityLiving, par2, par3, par4, par5, par6, par7);
	}

	@Override
	protected void renderSpecials(EntityPlayer par1EntityPlayer, float par2) {
		// ハードポイントの描画
		modelMain.renderItems(par1EntityPlayer, this);
		MMM_Client.renderArrowsStuckInEntity(par1EntityPlayer, par2, this, modelMain.modelInner);
	}
}
