package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class RenderPlayerFormSkinLoad2 extends RenderPlayer {

	protected ModelBiped modelBipedMain;
	protected ModelBiped modelArmorChestplate;
	protected ModelBiped modelArmor;

	public RenderPlayerFormSkinLoad2() {
		super();

		// モデルの置き換え
		modelBipedMain = new PFSL_ModelPlayerFormSkinLoad2(0.0F);
		modelArmorChestplate = new PFSL_ModelPlayerFormSkinLoad2(1.0F);
		modelArmor = new PFSL_ModelPlayerFormSkinLoad2(0.5F);
		mainModel = modelBipedMain;

		try {
			ModLoader.setPrivateValue(RenderPlayer.class, this, 0,
					modelBipedMain);
			ModLoader.setPrivateValue(RenderPlayer.class, this, 1,
					modelArmorChestplate);
			ModLoader.setPrivateValue(RenderPlayer.class, this, 2, modelArmor);
		} catch (Exception exception) {
		}
	}

	@Override
	public void renderPlayer(EntityPlayer entityplayer, double d, double d1,
			double d2, float f, float f1) {

		if (!mod_PFSL_PlayerFormSkinLoad2.SkinLoad_Texture.isEmpty()) {
			entityplayer.skinUrl = null;
			entityplayer.texture = mod_PFSL_PlayerFormSkinLoad2.SkinLoad_Texture;
		}
		if (mod_PFSL_PlayerFormSkinLoad2.SkinLoad_ModelFemale) {
			d1 -= 0.125D;
		}
		modelArmorChestplate.isRiding = modelArmor.isRiding = modelBipedMain.isRiding = entityplayer
				.isRiding();
		super.renderPlayer(entityplayer, d, d1, d2, f, f1);
		modelArmorChestplate.isRiding = modelArmor.isRiding = modelBipedMain.isRiding = false;
		;
	}

	@Override
	protected void renderSpecials(EntityPlayer par1EntityPlayer, float par2) {
		// フラワーヘッド
		ItemStack itemstack = par1EntityPlayer.inventory.getStackInSlot(35);
		if (itemstack != null) {
			Item item = itemstack.getItem();
			if (item instanceof ItemBlock) {
				Block block = Block.blocksList[item.itemID];
				if (block instanceof BlockLeaves) {
					GL11.glPushMatrix();
					modelBipedMain.bipedHead.postRender(0.0625F);

					if (RenderBlocks
							.renderItemIn3d(Block.blocksList[itemstack.itemID]
									.getRenderType())) {
						float f = 0.630F;
						GL11.glTranslatef(0.0F, -0.25F, 0.0F);
						GL11.glRotatef(180F, 0.0F, 1.0F, 0.0F);
						GL11.glScalef(f, -f, f);
					}

					renderManager.itemRenderer.renderItem(par1EntityPlayer,
							itemstack, 0);
					GL11.glPopMatrix();
				}
				if (block instanceof BlockFlower) {
					loadTexture("/terrain.png");
					GL11.glEnable(GL11.GL_CULL_FACE);
					GL11.glPushMatrix();
					modelBipedMain.bipedHead.postRender(0.0625F);
					GL11.glScalef(1.0F, -1F, 1.0F);
					GL11.glTranslatef(0.0F, 1.0F, 0.0F);
					GL11.glRotatef(12F, 0.0F, 1.0F, 0.0F);
					renderBlocks.renderBlockAsItem(block,
							itemstack.getItemDamage(), 1.0F);
					GL11.glPopMatrix();
					GL11.glDisable(GL11.GL_CULL_FACE);
				}
			}
		}

		super.renderSpecials(par1EntityPlayer, par2);
	}
}
