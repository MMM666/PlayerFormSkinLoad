package net.minecraft.src;

import java.util.List;

import net.minecraft.client.Minecraft;

public class PFSL_PlayerAPI extends PlayerBase {

	public PFSL_PlayerAPI(PlayerAPI playerapi) {
		super(playerapi);
	}

	@Override
	public void afterLocalConstructing(Minecraft minecraft, World world,
			Session session, int i) {
		if (!mod_PFSL_PlayerFormSkinLoad2.SkinLoad_Texture.isEmpty()) {
			player.skinUrl = null;
			player.texture = mod_PFSL_PlayerFormSkinLoad2.SkinLoad_Texture;
		}
	}

	@Override
	public void beforeOnLivingUpdate() {
		if (!player.worldObj.isRemote) {
			if (mod_PFSL_PlayerFormSkinLoad2.Physical_BurningPlayer > 0
					&& player.worldObj.isDaytime()) {
				float f = player.getBrightness(1.0F);
				if (f > 0.5F
						&& player.worldObj.canBlockSeeTheSky(
								MathHelper.floor_double(player.posX),
								MathHelper.floor_double(player.posY),
								MathHelper.floor_double(player.posZ))
						&& player.rand.nextFloat() * 30F < (f - 0.4F) * 2.0F) {
					player.setFire(mod_PFSL_PlayerFormSkinLoad2.Physical_BurningPlayer);
				}
			}
			if (mod_PFSL_PlayerFormSkinLoad2.Physical_MeltingPlayer > 0
					&& player.isWet()) {
				player.attackEntityFrom(DamageSource.drown,
						mod_PFSL_PlayerFormSkinLoad2.Physical_MeltingPlayer);
			}
		}

		// Magnetic
		if (player.getHealth() > 0
				&& mod_PFSL_PlayerFormSkinLoad2.Physical_CaptureRange > 0.0F) {
			float f = mod_PFSL_PlayerFormSkinLoad2.Physical_CaptureRange;
			List list = player.worldObj.getEntitiesWithinAABBExcludingEntity(
					player,
					player.boundingBox.expand(1.0D + f, 0.0D + f, 1.0D + f));
			if (list != null) {
				for (int i = 0; i < list.size(); i++) {
					Entity entity = (Entity) list.get(i);
					if (!entity.isDead) {
						entity.onCollideWithPlayer(player);
					}
				}
			}
		}

	}

	@Override
	public void moveEntityWithHeading(float f, float f1) {
		if (!player.worldObj.isRemote && player.isInWater()) {
			// player.motionX *= mod_PlayerFormSkinLoad2.Physical_Hammer;
			// player.motionZ *= mod_PlayerFormSkinLoad2.Physical_Hammer;
			f *= mod_PFSL_PlayerFormSkinLoad2.Physical_Hammer;
			f1 *= mod_PFSL_PlayerFormSkinLoad2.Physical_Hammer;
			if (player.motionY > 0.0F) {
				player.motionY *= mod_PFSL_PlayerFormSkinLoad2.Physical_Hammer;
			}
		}
		player.localMoveEntityWithHeading(f, f1);
	}

	@Override
	public String getHurtSound() {
		return mod_PFSL_PlayerFormSkinLoad2.Physical_HurtSound;
	}

}
