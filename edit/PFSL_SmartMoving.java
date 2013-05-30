package net.minecraft.src;

import net.smart.moving.SmartMoving;
import net.smart.moving.SmartMovingFactory;
import net.smart.render.SmartRenderRender;
import net.smart.render.statistics.SmartStatistics;
import net.smart.render.statistics.SmartStatisticsFactory;

/**
 * SmartMoving‚ª—L‚é‚É•Ï”‚ğŠl“¾‚·‚éˆ×‚ÌƒNƒ‰ƒX
 */
public class PFSL_SmartMoving {

	public MMM_SmartBase[] fmodels = new MMM_SmartBase[3];

	public void renderPlayer(EntityPlayer var1, double var2, double var4,
			double var6, float var8, float var9) {
		renderPlayerMoving(var1, var2, var4, var6, var8, var9);
		renderPlayerStatics(var1, var2, var4, var6, var8, var9);
	}

	public void renderPlayerMoving(EntityPlayer var1, double var2, double var4,
			double var6, float var8, float var9) {
		SmartMoving var10 = SmartMovingFactory.getInstance(var1);

		if (var10 != null) {
			boolean var11 = var2 == 0.0D && var4 == 0.0D && var6 == 0.0D
					&& var8 == 0.0F && var9 == 1.0F;
			boolean var12 = var10.isClimbing && !var10.isCrawling
					&& !var10.isCrawlClimbing && !var10.isClimbJumping;
			boolean var13 = var10.isClimbJumping;
			int var14 = var10.actualHandsClimbType;
			int var15 = var10.actualFeetClimbType;
			boolean var16 = var10.isHandsVineClimbing;
			boolean var17 = var10.isFeetVineClimbing;
			boolean var18 = var10.isCeilingClimbing;
			boolean var19 = var10.isSwimming && !var10.isDipping;
			boolean var20 = var10.isDiving;
			boolean var21 = var10.isLevitating;
			boolean var22 = var10.isCrawling && !var10.isClimbing;
			boolean var23 = var10.isCrawlClimbing || var10.isClimbing && var10.isCrawling;
			boolean var24 = var10.isJumping();
			boolean var25 = var10.isHeadJumping;
			boolean var26 = var10.doFlyingAnimation();
			boolean var27 = var10.isSliding;
			boolean var28 = var10.doFallingAnimation();
			boolean var29 = var10.isSlow;
			boolean var30 = var10.isAngleJumping();
			int var31 = var10.angleJumpType;
			boolean var32 = var10.isRopeSliding;
			float var33 = !var23 && !var25 ? 0.0F : (float) var10.getOverGroundHeight(5.0D);
			int var34 = var25 && var33 < 5.0F ? var10.getOverGroundBlockId((double) var33) : -1;

			for (int var35 = 0; var35 < this.fmodels.length; ++var35) {
				this.fmodels[var35].isClimb = var12;
				this.fmodels[var35].isClimbJump = var13;
				this.fmodels[var35].handsClimbType = var14;
				this.fmodels[var35].feetClimbType = var15;
				this.fmodels[var35].isHandsVineClimbing = var16;
				this.fmodels[var35].isFeetVineClimbing = var17;
				this.fmodels[var35].isCeilingClimb = var18;
				this.fmodels[var35].isSwim = var19;
				this.fmodels[var35].isDive = var20;
				this.fmodels[var35].isCrawl = var22;
				this.fmodels[var35].isCrawlClimb = var23;
				this.fmodels[var35].isJump = var24;
				this.fmodels[var35].isHeadJump = var25;
				this.fmodels[var35].isSlide = var27;
				this.fmodels[var35].isFlying = var26;
				this.fmodels[var35].isLevitate = var21;
				this.fmodels[var35].isFalling = var28;
				this.fmodels[var35].isGenericSneaking = var29;
				this.fmodels[var35].isAngleJumping = var30;
				this.fmodels[var35].angleJumpType = var31;
				this.fmodels[var35].isRopeSliding = var32;
				this.fmodels[var35].smallOverGroundHeight = var33;
				this.fmodels[var35].overGroundBlockId = var34;
			}

			if (!var11 && var1.isSneaking() && !(var1 instanceof EntityPlayerSP) && var22) {
				var4 += 0.125D;
			}
		}

	//	this.irp.superRenderRenderPlayer(var1, var2, var4, var6, var8, var9);

		if (var10 != null && var10.isLevitating) {
			for (int var36 = 0; var36 < this.fmodels.length; ++var36) {
				this.fmodels[var36].md.currentHorizontalAngle = this.fmodels[var36].md.currentCameraAngle;
			}
		}
	}

	public void renderPlayerStatics(EntityPlayer var1, double var2,
			double var4, double var6, float var8, float var9) {
		SmartStatistics var10 = SmartStatisticsFactory.getInstance(var1);

		if (var10 != null) {
			boolean var11 = var2 == 0.0D && var4 == 0.0D && var6 == 0.0D
					&& var8 == 0.0F && var9 == 1.0F;
			boolean var12 = var1.isPlayerSleeping();
			float var13 = var10.getTotalVerticalDistance(var9);
			float var14 = var10.getCurrentVerticalSpeed(var9);
			float var15 = var10.getTotalDistance(var9);
			float var16 = var10.getCurrentSpeed(var9);
			double var17 = 0.0D;
			double var19 = 0.0D;
			double var21 = 0.0D;
			float var23 = 0.0F;
			float var24 = 0.0F;
			float var25 = 0.0F;

			if (!var11) {
				double var26 = var1.posX - var1.prevPosX;
				double var28 = var1.posY - var1.prevPosY;
				double var30 = var1.posZ - var1.prevPosZ;
				var19 = Math.abs(var28);
				var21 = Math.sqrt(var26 * var26 + var30 * var30);
				var17 = Math.sqrt(var21 * var21 + var19 * var19);
				var23 = var1.rotationYaw / (180F / (float) Math.PI);
				var24 = (float) Math.atan(var28 / var21);

				if (Float.isNaN(var24)) {
					var24 = ((float) Math.PI / 2F);
				}

				var25 = (float) (-Math.atan(var26 / var30));

				if (Float.isNaN(var25)) {
					if (Float.isNaN(var10.prevHorizontalAngle)) {
						var25 = var23;
					} else {
						var25 = var10.prevHorizontalAngle;
					}
				} else if (var30 < 0.0D) {
					var25 += (float) Math.PI;
				}

				var10.prevHorizontalAngle = var25;
			}

			for (int var32 = 0; var32 < this.fmodels.length; ++var32) {
				this.fmodels[var32].isInventory = var11;
				this.fmodels[var32].totalVerticalDistance = var13;
				this.fmodels[var32].currentVerticalSpeed = var14;
				this.fmodels[var32].totalDistance = var15;
				this.fmodels[var32].currentSpeed = var16;
				this.fmodels[var32].distance = var17;
				this.fmodels[var32].verticalDistance = var19;
				this.fmodels[var32].horizontalDistance = var21;
				this.fmodels[var32].currentCameraAngle = var23;
				this.fmodels[var32].currentVerticalAngle = var24;
				this.fmodels[var32].currentHorizontalAngle = var25;
				this.fmodels[var32].prevOuterRenderData = 
						SmartRenderRender.getPreviousRendererData(var1);
				this.fmodels[var32].isSleeping = var12;
			}
		}

	//	this.irp.superRenderPlayer(var1, var2, var4, var6, var8, var9);
	}

}
