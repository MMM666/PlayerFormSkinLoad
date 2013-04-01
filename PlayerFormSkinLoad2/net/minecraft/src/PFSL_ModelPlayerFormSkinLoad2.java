package net.minecraft.src;

public class PFSL_ModelPlayerFormSkinLoad2 extends ModelBiped {

	public ModelRenderer Ahoge;
	public ModelRenderer SideTailR;
	public ModelRenderer SideTailL;
	public ModelRenderer Ponytail;
	public ModelRenderer ChignonB;
	public ModelRenderer Long1;
	public ModelRenderer Long2;
	public ModelRenderer Long3;
	public ModelRenderer Long4;

	public ModelRenderer EyeL;
	public ModelRenderer EyeR;
	public ModelRenderer bust1;
	public ModelRenderer bust2;
	public ModelRenderer bust3;
	public ModelRenderer bust4;
	public ModelRenderer uskirtR;
	public ModelRenderer uskirtL;
	public ModelRenderer skirtbase;
	public ModelRenderer skirtF1;
	public ModelRenderer skirtF2;
	public ModelRenderer skirtL1;
	public ModelRenderer skirtL2;
	public ModelRenderer skirtR1;
	public ModelRenderer skirtR2;
	public ModelRenderer skirtB1;
	public ModelRenderer skirtB2;
	private float armPosition;

	public PFSL_ModelPlayerFormSkinLoad2() {
		this(0.0F);
	}
	public PFSL_ModelPlayerFormSkinLoad2(float f) {
		this(f, 0.0F, 64, 32);
	}
	public PFSL_ModelPlayerFormSkinLoad2(float f, float f1, int par3, int par4) {
		super(f, f1, par3, par4);

		Ahoge = new ModelRenderer(this, 52, 16);
		Ahoge.addBox(2.0F, -11F, -1F, 6, 3, 0, f);
		Ahoge.setRotationPoint(0.0F, 0.0F + f1, 0.0F);
		bipedHead.addChild(Ahoge);
		SideTailR = new ModelRenderer(this, 56, 20);
		SideTailR.addBox(-9F, -6F, 0.0F, 3, 11, 1, f);
		SideTailR.setRotationPoint(0.0F, 0.0F + f1, 0.0F);
		SideTailL = new ModelRenderer(this, 56, 20);
		SideTailL.mirror = true;
		SideTailL.addBox(6F, -6F, 0.0F, 3, 11, 1, f);
		SideTailL.setRotationPoint(0.0F, 0.0F + f1, 0.0F);
		bipedHead.addChild(SideTailR);
		bipedHead.addChild(SideTailL);
		Ponytail = new ModelRenderer(this, 56, 20);
		Ponytail.addBox(-1F, 0F, 1F, 2, 10, 2, f + 0.5F);
		Ponytail.setRotationPoint(0.0F, -6F + f1, 4F);
		bipedHead.addChild(Ponytail);
		ChignonB = new ModelRenderer(this, 0, 0);
		ChignonB.addBox(-1.5F, -7F, 4F, 3, 3, 1, f + 0.5F);
		ChignonB.setRotationPoint(0.0F, 0F + f1, 0F);
		bipedHead.addChild(ChignonB);
		Long1 = new ModelRenderer(this, 56, 18);
		Long1.addBox(2F, 0F, -2F, 2, 8, 2, f);
		Long1.setRotationPoint(0.0F, 0F + f1, 0F);
		Long2 = new ModelRenderer(this, 56, 18);
		Long2.addBox(0F, 2F, -2F, 2, 8, 2, f);
		Long2.setRotationPoint(0.0F, 0F + f1, 0F);
		Long3 = new ModelRenderer(this, 56, 18);
		Long3.addBox(-2F, 2F, -2F, 2, 8, 2, f);
		Long3.setRotationPoint(0.0F, 0F + f1, 0F);
		Long4 = new ModelRenderer(this, 56, 18);
		Long4.addBox(-4F, 0F, -2F, 2, 8, 2, f);
		Long4.setRotationPoint(0.0F, 0F + f1, 0F);
		Long1.rotationPointY = Long4.rotationPointY = -2F;
		Long2.rotationPointY = Long3.rotationPointY = -3F;
		Long1.rotationPointZ = Long2.rotationPointZ = Long3.rotationPointZ = Long4.rotationPointZ = 4F;
		bipedHead.addChild(Long1);
		bipedHead.addChild(Long2);
		bipedHead.addChild(Long3);
		bipedHead.addChild(Long4);

		EyeL = new ModelRenderer(this, 36, 16);
		EyeL.addBox(0.0F, -5F, -4.001F, 4, 4, 0, f);
		EyeL.setRotationPoint(0.0F, 0.0F + f1, 0.0F);
		EyeR = new ModelRenderer(this, 12, 16);
		EyeR.addBox(-4F, -5F, -4.001F, 4, 4, 0, f);
		EyeR.setRotationPoint(0.0F, 0.0F + f1, 0.0F);
		bipedHead.addChild(EyeL);
		bipedHead.addChild(EyeR);

		bust1 = new ModelRenderer(this, 18, 20);
		bust2 = new ModelRenderer(this, 18, 22);
		bust3 = new ModelRenderer(this, 18, 18);
		bust4 = new ModelRenderer(this, 17, 20);
		if (mod_PFSL_PlayerFormSkinLoad2.SkinLoad_ModelFemale) {
			armPosition = 4F;
			bipedBody = new ModelRenderer(this, 16, 16);
			bipedBody.addBox(-4F, 0.0F, -2F, 8, 12, 4, f - 0.5F);
			bipedBody.setRotationPoint(0.0F, -0.5F + f1, 0.0F);
			bipedRightArm = new ModelRenderer(this, 40, 16);
			bipedRightArm.addBox(-3F, -2F, -2F, 4, 12, 4, f - 0.5F);
			bipedRightArm.setRotationPoint(-armPosition, 2.0F + f1, 0.0F);
			bipedLeftArm = new ModelRenderer(this, 40, 16);
			bipedLeftArm.mirror = true;
			bipedLeftArm.addBox(-1F, -2F, -2F, 4, 12, 4, f - 0.5F);
			bipedLeftArm.setRotationPoint(armPosition, 2.0F + f1, 0.0F);
			bipedRightLeg = new ModelRenderer(this, 0, 16);
			bipedRightLeg.addBox(-2F, 0.0F, -2F, 4, 12, 4, f - 0.25F);
			bipedRightLeg.setRotationPoint(-2F, 10.75F + f1, 0.0F);
			bipedLeftLeg = new ModelRenderer(this, 0, 16);
			bipedLeftLeg.mirror = true;
			bipedLeftLeg.addBox(-2F, 0.0F, -2F, 4, 12, 4, f - 0.25F);
			bipedLeftLeg.setRotationPoint(2.0F, 10.75F + f1, 0.0F);
			bust1.addBox(-4F, 1.0F, -2.7F, 8, 3, 2, f - 0.51F);
			bust2.addBox(-4F, 3.2F, -2.5F, 8, 1, 2, f - 0.52F);
			bust3.addBox(-4F, 0.6F, -2.4F, 8, 1, 2, f - 0.52F);
			bust4.addBox(-4F, -0.8F, -4.8F, 8, 3, 3, f - 0.6F);
		} else {
			armPosition = 5F;
			bust1.addBox(-4F, 1.0F, -2.7F, 8, 3, 2, f - 0.31F);
			bust2.addBox(-4F, 3.2F, -2.5F, 8, 1, 2, f - 0.32F);
			bust3.addBox(-4F, 0.6F, -2.4F, 8, 1, 2, f - 0.32F);
			bust4.addBox(-4F, -0.8F, -4.8F, 8, 3, 3, f - 0.1F);
		}
		bust1.setRotationPoint(0.0F, 0.0F + f1, 0.0F);
		bust2.setRotationPoint(0.0F, 0.0F + f1, 0.0F);
		bust3.setRotationPoint(0.0F, 0.0F + f1, 0.0F);
		bust4.setRotationPoint(0.0F, 0.0F + f1, 0.0F);
		bust4.rotateAngleX = 0.785F;
		bipedBody.addChild(bust1);
		bipedBody.addChild(bust2);
		bipedBody.addChild(bust3);
		bipedBody.addChild(bust4);

		uskirtR = new ModelRenderer(this, 24, 0);
		uskirtR.addBox(-3F, -1F, -2F, 4, 4, 4, f + 0.5F);
		uskirtR.setRotationPoint(-1F, 10F + f1, 0.0F);
		uskirtL = new ModelRenderer(this, 24, 0);
		uskirtL.mirror = true;
		uskirtL.addBox(-2F, -1F, -2F, 4, 4, 4, f + 0.5F);
		uskirtL.setRotationPoint(2.0F, 10F + f1, 0.0F);

		skirtbase = new ModelRenderer(this);
		skirtF1 = new ModelRenderer(this, 48, 0);
		skirtF1.addBox(-7.2F, 2.0F, -2F, 8, 8, 0, f);
		skirtF1.setRotationPoint(0.0F, 0.0F + f1, 0.0F);
		skirtF2 = new ModelRenderer(this, 48, 0);
		skirtF2.mirror = true;
		skirtF2.addBox(-0.8F, 2.0F, -2F, 8, 8, 0, f);
		skirtF2.setRotationPoint(0.0F, 0.0F + f1, 0.0F);
		skirtR1 = new ModelRenderer(this, 52, 0);
		skirtR1.addBox(-5F, 3F, -1F, 5, 8, 0, f);
		skirtR1.setRotationPoint(0.0F, 0.0F + f1, 0.0F);
		skirtR2 = new ModelRenderer(this, 51, 0);
		skirtR2.mirror = true;
		skirtR2.addBox(0F, 3F, -1F, 6, 8, 0, f);
		skirtR2.setRotationPoint(0.0F, 0.0F + f1, 0.0F);
		skirtL1 = new ModelRenderer(this, 51, 0);
		skirtL1.mirror = true;
		skirtL1.addBox(0F, 3F, 1.0F, 6, 8, 0, f);
		skirtL1.setRotationPoint(0.0F, 0.0F + f1, 0.0F);
		skirtL2 = new ModelRenderer(this, 51, 0);
		skirtL2.addBox(-6F, 3F, 1.0F, 6, 8, 0, f);
		skirtL2.setRotationPoint(0.0F, 0.0F + f1, 0.0F);
		skirtB1 = new ModelRenderer(this, 48, 0);
		skirtB1.mirror = true;
		skirtB1.addBox(-0.8F, 2.0F, 1.5F, 8, 8, 0, f);
		skirtB1.setRotationPoint(0.0F, 0.0F + f1, 0.0F);
		skirtB2 = new ModelRenderer(this, 48, 0);
		skirtB2.addBox(-7.3F, 2.0F, 1.5F, 8, 8, 0, f);
		skirtB2.setRotationPoint(0.0F, 0.0F + f1, 0.0F);
		skirtF1.rotateAngleX = -0.7854F;
		skirtF1.rotateAngleY = 0.2618F;
		skirtF1.rotateAngleZ = -0.2618F;
		skirtF2.rotateAngleX = -0.7854F;
		skirtF2.rotateAngleY = -0.2618F;
		skirtF2.rotateAngleZ = 0.2618F;
		skirtR1.rotateAngleX = -0.61087F;
		skirtR1.rotateAngleY = 1.5708F;
		skirtR1.rotateAngleZ = 0.0F;
		skirtR2.rotateAngleX = -0.61087F;
		skirtR2.rotateAngleY = 1.5708F;
		skirtR2.rotateAngleZ = 0.0F;
		skirtL1.rotateAngleX = 0.61087F;
		skirtL1.rotateAngleY = 1.5708F;
		skirtL1.rotateAngleZ = 0.0F;
		skirtL2.rotateAngleX = 0.61087F;
		skirtL2.rotateAngleY = 1.5708F;
		skirtL2.rotateAngleZ = 0.0F;
		skirtB1.rotateAngleX = 0.7854F;
		skirtB1.rotateAngleY = 0.2618F;
		skirtB1.rotateAngleZ = 0.2618F;
		skirtB2.rotateAngleX = 0.7854F;
		skirtB2.rotateAngleY = -0.2618F;
		skirtB2.rotateAngleZ = -0.2618F;
		bipedBody.addChild(skirtbase);
		skirtbase.addChild(skirtF1);
		skirtbase.addChild(skirtF2);
		skirtbase.addChild(skirtR1);
		skirtbase.addChild(skirtR2);
		skirtbase.addChild(skirtL1);
		skirtbase.addChild(skirtL2);
		skirtbase.addChild(skirtB1);
		skirtbase.addChild(skirtB2);

		// •\Ž¦Ý’è
		bust1.isHidden = bust2.isHidden = bust3.isHidden = !mod_PFSL_PlayerFormSkinLoad2.SkinLoad_ModelBustTypeA;
		bust4.isHidden = !mod_PFSL_PlayerFormSkinLoad2.SkinLoad_ModelBustTypeB;
		SideTailR.isHidden = !mod_PFSL_PlayerFormSkinLoad2.SkinLoad_ModelSideTailR;
		SideTailL.isHidden = !mod_PFSL_PlayerFormSkinLoad2.SkinLoad_ModelSideTailL;
		Ponytail.isHidden = !mod_PFSL_PlayerFormSkinLoad2.SkinLoad_ModelPonytail;
		ChignonB.isHidden = !mod_PFSL_PlayerFormSkinLoad2.SkinLoad_ModelChignon;
		Long1.isHidden = Long2.isHidden = Long3.isHidden = Long4.isHidden = !mod_PFSL_PlayerFormSkinLoad2.SkinLoad_ModelLongHair;
		skirtF1.isHidden = skirtF2.isHidden = skirtB1.isHidden = skirtB2.isHidden = skirtL1.isHidden = skirtL2.isHidden = skirtR1.isHidden = skirtR2.isHidden = uskirtL.isHidden = uskirtR.isHidden = !mod_PFSL_PlayerFormSkinLoad2.SkinLoad_ModelSkirt;

	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		uskirtR.render(f5);
		uskirtL.render(f5);
	}

	@Override
	public void setRotationAngles(float f, float f1, float f2, float f3,
			float f4, float f5, Entity par7Entity) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, par7Entity);
		if (mod_PFSL_PlayerFormSkinLoad2.SkinLoad_ModelHeadWare) {
			bipedHeadwear.rotationPointY = bipedHead.rotationPointY;
		}
		if (mod_PFSL_PlayerFormSkinLoad2.SkinLoad_ModelFemale) {
			bipedRightArm.rotateAngleZ += 0.1F;
			bipedLeftArm.rotateAngleZ -= 0.1F;
		}
		if (isSneak) {
			skirtbase.rotationPointY = 5.0F;
			skirtbase.rotationPointZ = -1.0F;
			skirtbase.rotateAngleX = -0.3F;
			uskirtL.rotationPointY = uskirtR.rotationPointY = 8F;
			uskirtL.rotationPointZ = uskirtR.rotationPointZ = 4F;
			if (mod_PFSL_PlayerFormSkinLoad2.SkinLoad_ModelFemale) {
				bipedRightLeg.rotationPointY = 9F;
				bipedLeftLeg.rotationPointY = 9F;
			}
		} else {
			skirtbase.rotationPointY = 6.5F;
			skirtbase.rotationPointZ = 0.0F;
			skirtbase.rotateAngleX = 0.0F;
			uskirtL.rotationPointY = uskirtR.rotationPointY = 10F;
			uskirtL.rotationPointZ = uskirtR.rotationPointZ = 0.0F;
			if (mod_PFSL_PlayerFormSkinLoad2.SkinLoad_ModelFemale) {
				bipedRightLeg.rotationPointY = 10.5F;
				bipedLeftLeg.rotationPointY = 10.5F;
			}
		}
		if (onGround > -9990F) {
			bipedRightArm.rotationPointZ = MathHelper
					.sin(bipedBody.rotateAngleY) * armPosition;
			bipedRightArm.rotationPointX = -MathHelper
					.cos(bipedBody.rotateAngleY) * armPosition;
			bipedLeftArm.rotationPointZ = -MathHelper
					.sin(bipedBody.rotateAngleY) * armPosition;
			bipedLeftArm.rotationPointX = MathHelper
					.cos(bipedBody.rotateAngleY) * armPosition;
		}
		Ahoge.rotateAngleX = MathHelper.cos(f2 * 0.05F) * 0.1F;
		Ahoge.rotateAngleY = 1.22173F;
		Ahoge.rotateAngleZ = 0.17453F;
		float f6 = MathHelper.sin(f2 * 0.05F) * 0.1F - 0.34907F;
		SideTailR.rotateAngleY = SideTailR.rotateAngleZ = -f6;
		SideTailL.rotateAngleY = SideTailL.rotateAngleZ = f6;

		if (0.0D > (double) (MathHelper.sin(f2 * 0.1F) * 0.3F) + Math.random()
				* 0.10000000149011612D + 0.18000000715255737D) {
			EyeL.showModel = EyeR.showModel = mod_PFSL_PlayerFormSkinLoad2.SkinLoad_ModelInvertBlink;
		} else {
			EyeL.showModel = EyeR.showModel = !mod_PFSL_PlayerFormSkinLoad2.SkinLoad_ModelInvertBlink;
		}
		uskirtR.rotateAngleX = bipedRightLeg.rotateAngleX / 3F;
		uskirtL.rotateAngleX = bipedLeftLeg.rotateAngleX / 3F;
		uskirtR.rotateAngleY = bipedRightLeg.rotateAngleY;
		uskirtL.rotateAngleY = bipedLeftLeg.rotateAngleY;
		uskirtR.rotateAngleZ = bipedRightLeg.rotateAngleZ;
		uskirtL.rotateAngleZ = bipedLeftLeg.rotateAngleZ;

		Ponytail.rotateAngleX = Long1.rotateAngleX = Long2.rotateAngleX = Long3.rotateAngleX = Long4.rotateAngleX = bipedHead.rotateAngleX > 0 ? -bipedHead.rotateAngleX / 2F
				: -bipedHead.rotateAngleX;
		Ponytail.rotateAngleY = MathHelper.sin(f2 * 0.05F) * 0.1F;
	}

}
