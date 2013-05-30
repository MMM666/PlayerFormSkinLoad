package net.minecraft.src;

import net.smart.moving.SmartMoving;
import net.smart.moving.SmartMovingFactory;
import net.smart.moving.render.IModelPlayer;
import net.smart.render.ModelCapeRenderer;
import net.smart.render.ModelEarsRenderer;
import net.smart.render.ModelRotationRenderer;
import net.smart.render.RendererData;
import net.smart.render.SmartRenderModel;

public abstract class MMM_SmartBase extends MMM_ModelMultiBase {

	// SmartMovingModel
//	public IModelPlayer imp;
//	public ModelBiped mp;
	public MMM_SmartBase md;
	public boolean isStandard;
	public boolean isClimb;
	public boolean isClimbJump;
	public int feetClimbType;
	public int handsClimbType;
	public boolean isHandsVineClimbing;
	public boolean isFeetVineClimbing;
	public boolean isCeilingClimb;
	public boolean isSwim;
	public boolean isDive;
	public boolean isCrawl;
	public boolean isCrawlClimb;
	public boolean isJump;
	public boolean isHeadJump;
	public boolean isFlying;
	public boolean isSlide;
	public boolean isLevitate;
	public boolean isFalling;
	public boolean isGenericSneaking;
	public boolean isAngleJumping;
	public int angleJumpType;
	public boolean isRopeSliding;
	public float smallOverGroundHeight;
	public int overGroundBlockId;
//	public int scaleArmType;
//	public int scaleLegType;

	// SmartRenderModel
//	public IModelPlayer imp;
//	public ModelBiped mp;
	public boolean isInventory;
	public int scaleArmType;
	public int scaleLegType;
	public float totalVerticalDistance;
	public float currentVerticalSpeed;
	public float totalDistance;
	public float currentSpeed;
	public double distance;
	public double verticalDistance;
	public double horizontalDistance;
	public float currentCameraAngle;
	public float currentVerticalAngle;
	public float currentHorizontalAngle;
	public float actualRotation;
	public float forwardRotation;
	public float workingAngle;
//	public ModelRotationRenderer bipedOuter;
//	public ModelRotationRenderer bipedTorso;
//	public ModelRotationRenderer bipedBody;
//	public ModelRotationRenderer bipedBreast;
//	public ModelRotationRenderer bipedNeck;
//	public ModelRotationRenderer bipedHead;
//	public ModelRotationRenderer bipedHeadwear;
//	public ModelRotationRenderer bipedRightShoulder;
//	public ModelRotationRenderer bipedRightArm;
//	public ModelRotationRenderer bipedLeftShoulder;
//	public ModelRotationRenderer bipedLeftArm;
//	public ModelRotationRenderer bipedPelvic;
//	public ModelRotationRenderer bipedRightLeg;
//	public ModelRotationRenderer bipedLeftLeg;
//	public ModelEarsRenderer bipedEars;
//	public ModelCapeRenderer bipedCloak;
	public boolean disabled;
	public boolean attemptToCallRenderCape;
	public RendererData prevOuterRenderData;
	public boolean isSleeping;
	public boolean firstPerson;
	
	
	


}
