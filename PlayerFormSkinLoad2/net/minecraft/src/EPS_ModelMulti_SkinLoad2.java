package net.minecraft.src;

/**
 * SkinLoad2益荒男
 */
public class EPS_ModelMulti_SkinLoad2 extends MMM_ModelMulti_Steve {

	public MMM_ModelRenderer Ahoge;
	public MMM_ModelRenderer SideTailR;
	public MMM_ModelRenderer SideTailL;
	public MMM_ModelRenderer Ponytail;
	public MMM_ModelRenderer ChignonB;
	public MMM_ModelRenderer LongHair;
	public MMM_ModelRenderer Long1;
	public MMM_ModelRenderer Long2;
	public MMM_ModelRenderer Long3;
	public MMM_ModelRenderer Long4;

	public MMM_ModelRenderer bustA;
	public MMM_ModelRenderer bustB;
	public MMM_ModelRenderer uskirtR;
	public MMM_ModelRenderer uskirtL;
	public MMM_ModelRenderer skirtbase;
	public MMM_ModelRenderer skirtF1;
	public MMM_ModelRenderer skirtF2;
	public MMM_ModelRenderer skirtL1;
	public MMM_ModelRenderer skirtL2;
	public MMM_ModelRenderer skirtR1;
	public MMM_ModelRenderer skirtR2;
	public MMM_ModelRenderer skirtB1;
	public MMM_ModelRenderer skirtB2;
	
	public MMM_ModelRenderer bipedBodyF;
	public MMM_ModelRenderer bipedRightArmF;
	public MMM_ModelRenderer bipedLeftArmF;
	public MMM_ModelRenderer bipedRightArmM;
	public MMM_ModelRenderer bipedLeftArmM;
	public MMM_ModelRenderer bipedRightLegF;
	public MMM_ModelRenderer bipedLeftLegF;
	public MMM_ModelRenderer bustAF;
	public MMM_ModelRenderer bustBF;



	public EPS_ModelMulti_SkinLoad2() {
		super();
	}
	public EPS_ModelMulti_SkinLoad2(float psize) {
		super(psize);
	}
	public EPS_ModelMulti_SkinLoad2(float psize, float pyoffset, int pTextureWidth, int pTextureHeight) {
		super(psize, pyoffset, pTextureWidth, pTextureHeight);
	}

	@Override
	public void initModel(float f, float pyoffset) {
		super.initModel(f, pyoffset);
		
		eyeL.clearCubeList();
		eyeL.setTextureOffset(36, 16).addBox(0.0F, -5F, -4.001F, 4, 4, 0, f);
		eyeL.setRotationPoint(0.0F, 0.0F, 0.0F);
		eyeR.clearCubeList();
		eyeR.setTextureOffset(12, 16).addBox(-4F, -5F, -4.001F, 4, 4, 0, f);
		eyeR.setRotationPoint(0.0F, 0.0F, 0.0F);
		
		bipedRightArm.clearCubeList();
		bipedLeftArm.clearCubeList();
		bipedRightArmM = new MMM_ModelRenderer(this, 40, 16);
		bipedRightArmM.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, f);
//		bipedRightArmM.setRotationPoint(-5.0F, 2.0F, 0.0F);
		bipedLeftArmM = new MMM_ModelRenderer(this, 40, 16);
		bipedLeftArmM.mirror = true;
		bipedLeftArmM.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, f);
//		bipedLeftArmM.setRotationPoint(5.0F, 2.0F, 0.0F);
		
		Ahoge = new MMM_ModelRenderer(this, 52, 16);
		Ahoge.addBox(2.0F, -11F, -1F, 6, 3, 0, f);
		Ahoge.setRotationPoint(0.0F, 0.0F, 0.0F);
		SideTailR = new MMM_ModelRenderer(this, 56, 20);
		SideTailR.addBox(-9F, -6F, 0.0F, 3, 11, 1, f);
		SideTailR.setRotationPoint(0.0F, 0.0F, 0.0F);
		SideTailL = new MMM_ModelRenderer(this, 56, 20);
		SideTailL.mirror = true;
		SideTailL.addBox(6F, -6F, 0.0F, 3, 11, 1, f);
		SideTailL.setRotationPoint(0.0F, 0.0F, 0.0F);
		Ponytail = new MMM_ModelRenderer(this, 56, 20);
		Ponytail.addBox(-1F, 0F, 1F, 2, 10, 2, f + 0.5F);
		Ponytail.setRotationPoint(0.0F, -6F, 4F);
		ChignonB = new MMM_ModelRenderer(this, 0, 0);
		ChignonB.addBox(-1.5F, -7F, 4F, 3, 3, 1, f + 0.5F);
		ChignonB.setRotationPoint(0.0F, 0F, 0F);
		LongHair = new MMM_ModelRenderer(this);
		Long1 = new MMM_ModelRenderer(this, 56, 18);
		Long1.addBox(2F, 0F, -2F, 2, 8, 2, f);
		Long1.setRotationPoint(0F, -2F, 4F);
		Long2 = new MMM_ModelRenderer(this, 56, 18);
		Long2.addBox(0F, 2F, -2F, 2, 8, 2, f);
		Long2.setRotationPoint(0F, -3F, 4F);
		Long3 = new MMM_ModelRenderer(this, 56, 18);
		Long3.addBox(-2F, 2F, -2F, 2, 8, 2, f);
		Long3.setRotationPoint(0F, -3F, 4F);
		Long4 = new MMM_ModelRenderer(this, 56, 18);
		Long4.addBox(-4F, 0F, -2F, 2, 8, 2, f);
		Long4.setRotationPoint(0F, -2F, 4F);
		
		bustA = new MMM_ModelRenderer(this);
		bustA.setTextureOffset(18, 20).addBox(-4F, 1.0F, -2.7F, 8, 3, 2, f - 0.31F);
		bustA.setTextureOffset(18, 22).addBox(-4F, 3.2F, -2.5F, 8, 1, 2, f - 0.32F);
		bustA.setTextureOffset(18, 18).addBox(-4F, 0.6F, -2.4F, 8, 1, 2, f - 0.32F);
		bustA.setRotationPoint(0.0F, 0.0F, 0.0F);
		bustB = new MMM_ModelRenderer(this, 17, 20);
		bustB.addBox(-4F, -0.8F, -4.8F, 8, 3, 3, f - 0.1F);
		bustB.setRotationPoint(0.0F, 0.0F, 0.0F);
		bustB.rotateAngleX = 0.785F;
		
		uskirtR = new MMM_ModelRenderer(this, 24, 0);
		uskirtR.addBox(-3F, -1F, -2F, 4, 4, 4, f + 0.5F);
		uskirtR.setRotationPoint(-1F, 10F, 0.0F);
		uskirtL = new MMM_ModelRenderer(this, 24, 0);
		uskirtL.mirror = true;
		uskirtL.addBox(-2F, -1F, -2F, 4, 4, 4, f + 0.5F);
		uskirtL.setRotationPoint(2.0F, 10F, 0.0F);
		
		skirtbase = new MMM_ModelRenderer(this);
		skirtF1 = new MMM_ModelRenderer(this, 48, 0);
		skirtF1.addBox(-7.2F, 2.0F, -2F, 8, 8, 0, f);
		skirtF1.setRotationPoint(0.0F, 0.0F, 0.0F);
		skirtF2 = new MMM_ModelRenderer(this, 48, 0);
		skirtF2.mirror = true;
		skirtF2.addBox(-0.8F, 2.0F, -2F, 8, 8, 0, f);
		skirtF2.setRotationPoint(0.0F, 0.0F, 0.0F);
		skirtR1 = new MMM_ModelRenderer(this, 52, 0);
		skirtR1.addBox(-5F, 3F, -1F, 5, 8, 0, f);
		skirtR1.setRotationPoint(0.0F, 0.0F, 0.0F);
		skirtR2 = new MMM_ModelRenderer(this, 51, 0);
		skirtR2.mirror = true;
		skirtR2.addBox(0F, 3F, -1F, 6, 8, 0, f);
		skirtR2.setRotationPoint(0.0F, 0.0F, 0.0F);
		skirtL1 = new MMM_ModelRenderer(this, 51, 0);
		skirtL1.mirror = true;
		skirtL1.addBox(0F, 3F, 1.0F, 6, 8, 0, f);
		skirtL1.setRotationPoint(0.0F, 0.0F, 0.0F);
		skirtL2 = new MMM_ModelRenderer(this, 51, 0);
		skirtL2.addBox(-6F, 3F, 1.0F, 6, 8, 0, f);
		skirtL2.setRotationPoint(0.0F, 0.0F, 0.0F);
		skirtB1 = new MMM_ModelRenderer(this, 48, 0);
		skirtB1.mirror = true;
		skirtB1.addBox(-0.8F, 2.0F, 1.5F, 8, 8, 0, f);
		skirtB1.setRotationPoint(0.0F, 0.0F, 0.0F);
		skirtB2 = new MMM_ModelRenderer(this, 48, 0);
		skirtB2.addBox(-7.3F, 2.0F, 1.5F, 8, 8, 0, f);
		skirtB2.setRotationPoint(0.0F, 0.0F, 0.0F);
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
		
		bipedBodyF = new MMM_ModelRenderer(this, 16, 16);
		bipedBodyF.addBox(-4F, 0.0F, -2F, 8, 12, 4, f - 0.5F);
		bipedBodyF.setRotationPoint(0.0F, -0.5F, 0.0F);
		bipedRightArmF = new MMM_ModelRenderer(this, 40, 16);
		bipedRightArmF.addBox(-3F, -2F, -2F, 4, 12, 4, f - 0.5F);
//		bipedRightArmF.setRotationPoint(-4F, 2.0F, 0.0F);
		bipedLeftArmF = new MMM_ModelRenderer(this, 40, 16);
		bipedLeftArmF.mirror = true;
		bipedLeftArmF.addBox(-1F, -2F, -2F, 4, 12, 4, f - 0.5F);
//		bipedLeftArmF.setRotationPoint(4F, 2.0F, 0.0F);
		bipedRightLegF = new MMM_ModelRenderer(this, 0, 16);
		bipedRightLegF.addBox(-2F, 0.0F, -2F, 4, 12, 4, f - 0.25F);
		bipedRightLegF.setRotationPoint(-2F, 10.75F, 0.0F);
		bipedLeftLegF = new MMM_ModelRenderer(this, 0, 16);
		bipedLeftLegF.mirror = true;
		bipedLeftLegF.addBox(-2F, 0.0F, -2F, 4, 12, 4, f - 0.25F);
		bipedLeftLegF.setRotationPoint(2.0F, 10.75F, 0.0F);
		bustAF = new MMM_ModelRenderer(this);
		bustAF.setTextureOffset(18, 20).addBox(-4F, 1.0F, -2.7F, 8, 3, 2, f - 0.51F);
		bustAF.setTextureOffset(18, 22).addBox(-4F, 3.2F, -2.5F, 8, 1, 2, f - 0.52F);
		bustAF.setTextureOffset(18, 18).addBox(-4F, 0.6F, -2.4F, 8, 1, 2, f - 0.52F);
		bustAF.setRotationPoint(0.0F, 0.0F, 0.0F);
		bustBF = new MMM_ModelRenderer(this, 17, 20);
		bustBF.addBox(-4F, -0.8F, -4.8F, 8, 3, 3, f - 0.6F);
		bustBF.setRotationPoint(0.0F, 0.0F, 0.0F);
		bustBF.rotateAngleX = 0.785F;

		
		bipedHead.addChild(Ahoge);
		bipedHead.addChild(SideTailR);
		bipedHead.addChild(SideTailL);
		bipedHead.addChild(Ponytail);
		bipedHead.addChild(ChignonB);
		bipedHead.addChild(LongHair);
		LongHair.addChild(Long1);
		LongHair.addChild(Long2);
		LongHair.addChild(Long3);
		LongHair.addChild(Long4);
		
		bipedBody.addChild(bustA);
		bipedBody.addChild(bustB);
		
		bipedPelvic.addChild(uskirtL);
		bipedPelvic.addChild(uskirtR);
		bipedPelvic.addChild(skirtbase);
		skirtbase.addChild(skirtF1);
		skirtbase.addChild(skirtF2);
		skirtbase.addChild(skirtR1);
		skirtbase.addChild(skirtR2);
		skirtbase.addChild(skirtL1);
		skirtbase.addChild(skirtL2);
		skirtbase.addChild(skirtB1);
		skirtbase.addChild(skirtB2);
		
		bipedTorso.addChild(bipedBodyF);
		bipedLeftArm.addChild(bipedLeftArmF);
		bipedLeftArm.addChild(bipedLeftArmM);
		bipedLeftArm.addChild(Arms[1]);
		bipedRightArm.addChild(bipedRightArmF);
		bipedRightArm.addChild(bipedRightArmM);
		bipedRightArm.addChild(Arms[0]);
		bipedBodyF.addChild(bustAF);
		bipedBodyF.addChild(bustBF);
		bipedPelvic.addChild(bipedLeftLegF);
		bipedPelvic.addChild(bipedRightLegF);
	}

	@Override
	public String getUsingTexture() {
		return "SkinLoad";
	}

	@Override
	public void render(MMM_IModelCaps pEntityCaps, float par2, float par3,
			float ticksExisted, float pheadYaw, float pheadPitch, float par7,
			boolean pIsRender) {
		setPartsVisible(pEntityCaps, par2, par3, ticksExisted, pheadYaw, pheadPitch, par7);
		super.render(pEntityCaps, par2, par3, ticksExisted, pheadYaw, pheadPitch, par7, pIsRender);
	}

	@Override
	public void setRotationAngles(float f, float f1, float f2, float f3,
			float f4, float f5, MMM_IModelCaps pEntityCaps) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, pEntityCaps);
		
		int lvisible = MMM_ModelCapsHelper.getCapsValueInt(pEntityCaps, caps_PartsVisible);
		boolean lgender = (lvisible & 0x0400) > 0;
		
		if ((lvisible & 0x0200) > 0) {
			bipedHeadwear.rotationPointY = bipedHead.rotationPointY;
		}
		if (isSneak) {
			skirtbase.rotationPointY = 5.0F;
			skirtbase.rotationPointZ = -1.0F;
			skirtbase.rotateAngleX = -0.3F;
			uskirtL.rotationPointY = uskirtR.rotationPointY = 8F;
//			uskirtL.rotationPointZ = uskirtR.rotationPointZ = 4F;
			if (lgender) {
				bipedRightLeg.rotationPointY = 9F;
				bipedLeftLeg.rotationPointY = 9F;
			}
		} else {
			skirtbase.rotationPointY = 6.5F;
			skirtbase.rotationPointZ = 0.0F;
			skirtbase.rotateAngleX = 0.0F;
			uskirtL.rotationPointY = uskirtR.rotationPointY = 10F;
//			uskirtL.rotationPointZ = uskirtR.rotationPointZ = 0.0F;
			if (lgender) {
				bipedRightLeg.rotationPointY = 10.5F;
				bipedLeftLeg.rotationPointY = 10.5F;
			}
		}
		
		boolean linvBE = (lvisible & 0x0100) > 0;
		if (0.0D > (double) (mh_sin(f2 * 0.1F) * 0.3F) + Math.random()
				* 0.10000000149011612D + 0.18000000715255737D) {
			eyeL.showModel = eyeR.showModel = linvBE;
		} else {
			eyeL.showModel = eyeR.showModel = !linvBE;
		}
		
//		bipedRightArmF.rotateAngleX = bipedRightArm.rotateAngleX;
//		bipedRightArmF.rotateAngleY = bipedRightArm.rotateAngleY;
//		bipedRightArmF.rotateAngleZ = bipedRightArm.rotateAngleZ;
//		bipedLeftArmF.rotateAngleX = bipedLeftArm.rotateAngleX;
//		bipedLeftArmF.rotateAngleY = bipedLeftArm.rotateAngleY;
//		bipedLeftArmF.rotateAngleZ = bipedLeftArm.rotateAngleZ;
		bipedRightLegF.rotateAngleX = bipedRightLeg.rotateAngleX;
		bipedRightLegF.rotateAngleY = bipedRightLeg.rotateAngleY;
		bipedRightLegF.rotateAngleZ = bipedRightLeg.rotateAngleZ;
		bipedLeftLegF.rotateAngleX = bipedLeftLeg.rotateAngleX;
		bipedLeftLegF.rotateAngleY = bipedLeftLeg.rotateAngleY;
		bipedLeftLegF.rotateAngleZ = bipedLeftLeg.rotateAngleZ;

		Ahoge.rotateAngleX = mh_cos(f2 * 0.05F) * 0.1F;
		Ahoge.rotateAngleY = 1.22173F;
		Ahoge.rotateAngleZ = 0.17453F;
		float f6 = mh_sin(f2 * 0.05F) * 0.1F - 0.34907F;
		SideTailR.rotateAngleY = SideTailR.rotateAngleZ = -f6;
		SideTailL.rotateAngleY = SideTailL.rotateAngleZ = f6;
		
		uskirtR.rotateAngleX = bipedRightLeg.rotateAngleX / 3F;
		uskirtL.rotateAngleX = bipedLeftLeg.rotateAngleX / 3F;
		uskirtR.rotateAngleY = bipedRightLeg.rotateAngleY;
		uskirtL.rotateAngleY = bipedLeftLeg.rotateAngleY;
		uskirtR.rotateAngleZ = bipedRightLeg.rotateAngleZ;
		uskirtL.rotateAngleZ = bipedLeftLeg.rotateAngleZ;
		
		Ponytail.rotateAngleX = Long1.rotateAngleX = Long2.rotateAngleX = Long3.rotateAngleX = Long4.rotateAngleX =
				bipedHead.rotateAngleX > 0 ? -bipedHead.rotateAngleX / 2F : -bipedHead.rotateAngleX;
		Ponytail.rotateAngleY = mh_sin(f2 * 0.05F) * 0.1F;
	}

	/**
	 * パーツの表示を制御
	 */
	public void setPartsVisible(MMM_IModelCaps pEntityCaps, float par2, float par3,
			float ticksExisted, float pheadYaw, float pheadPitch, float par7) {
		int lvisible = MMM_ModelCapsHelper.getCapsValueInt(pEntityCaps, caps_PartsVisible);
//		lvisible = 0xffff;
		bustA.showModel = bustAF.showModel = ((lvisible & 0x0001) > 0);
		bustB.showModel = bustBF.showModel = ((lvisible & 0x0002) > 0);
		SideTailR.setVisible((lvisible & 0x0004) > 0);
		SideTailL.setVisible((lvisible & 0x0008) > 0);
		Ponytail.setVisible((lvisible & 0x0010) > 0);
		LongHair.setVisible((lvisible & 0x0020) > 0);
		ChignonB.setVisible((lvisible & 0x0040) > 0);
		skirtbase.setVisible((lvisible & 0x0080) > 0);
		
	}

	@Override
	public void setDefaultPause(float par1, float par2, float pTicksExisted,
			float pHeadYaw, float pHeadPitch, float par6,
			MMM_IModelCaps pEntityCaps) {
		super.setDefaultPause(par1, par2, pTicksExisted, pHeadYaw, pHeadPitch, par6, pEntityCaps);
		
		int lvisible = MMM_ModelCapsHelper.getCapsValueInt(pEntityCaps, caps_PartsVisible);
		boolean lgender = (lvisible & 0x0400) > 0;
		if (lgender) {
			// Femail
			bipedBody.setVisible(false);
			bipedLeftArmM.setVisible(false);
			bipedRightArmM.setVisible(false);
			bipedLeftLeg.setVisible(false);
			bipedRightLeg.setVisible(false);
			bipedBodyF.setVisible(true);
			bipedLeftArmF.setVisible(true);
			bipedRightArmF.setVisible(true);
			bipedLeftLegF.setVisible(true);
			bipedRightLegF.setVisible(true);
			bipedRightArm.rotateAngleZ = 0.1F;
			bipedLeftArm.rotateAngleZ = -0.1F;
			bipedRightArm.setRotationPoint(-4F, 2.0F, 0.0F);
			bipedLeftArm.setRotationPoint(4F, 2.0F, 0.0F);
		} else {
			// Mail
			bipedBody.setVisible(true);
			bipedLeftArmM.setVisible(true);
			bipedRightArmM.setVisible(true);
			bipedLeftLeg.setVisible(true);
			bipedRightLeg.setVisible(true);
			bipedBodyF.setVisible(false);
			bipedLeftArmF.setVisible(false);
			bipedRightArmF.setVisible(false);
			bipedLeftLegF.setVisible(false);
			bipedRightLegF.setVisible(false);
			bipedRightArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
			bipedLeftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
			
		}
	}

	@Override
	public Object getCapsValue(int pIndex, Object... pArg) {
		switch (pIndex) {
		case caps_PartsStrings:
			return "BustA,BustB,SideTailR,SideTailL,PonyTail,LongHair,Chignon,Skirt,InvertEyeBlink,HatWear,Gender";
		}
		
		return super.getCapsValue(pIndex, pArg);
	}

}
