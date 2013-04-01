package net.minecraft.src;


/**
 * ����`��p�N���X�iRenderPlayerAPI���L�鎞�p�j
 */
public class PFSL_RenderPlayerAPI extends RenderPlayerBase {

	public PFSL_RenderPlayerAPI(RenderPlayerAPI var1) {
		super(var1);
	}

	@Override
	public void afterLocalConstructing() {
		// ���f���Ȃǂ̏�����
		ModelBiped var1 = new PFSL_ModelPlayerFormSkinLoad2(0.0F);
		ModelBiped var2 = new PFSL_ModelPlayerFormSkinLoad2(1.0F);
		ModelBiped var3 = new PFSL_ModelPlayerFormSkinLoad2(0.5F);
		renderPlayer.setMainModelField(var1);
		renderPlayer.setShadowSizeField(0.5F);
		renderPlayer.setModelBipedMainField(var1);
		renderPlayer.setModelArmorChestplateField(var2);
		renderPlayer.setModelArmorField(var3);
	}

}
