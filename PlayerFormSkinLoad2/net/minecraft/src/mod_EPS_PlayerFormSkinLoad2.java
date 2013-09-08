package net.minecraft.src;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class mod_EPS_PlayerFormSkinLoad2 extends BaseMod {

	@MLProp(info = "Required, when there is no PlayerAPI")
	public static boolean isReplacePlayerControler = true;
	@MLProp()
	public static boolean isToggleCreativemodeKey = false;

	@MLProp(info = "Enable Player Effect.")
	public static boolean isPhysical = true;
	@MLProp(info = "Will burn in sunlight.(0=Disable, 8=Zombie)")
	public static int Physical_BurningPlayer = 0;
	@MLProp(info = "Damage when wet.(0=Disable, 1=Enderman)")
	public static int Physical_MeltingPlayer = 0;
	@MLProp(info = "move magnification in water.(1.0=normal, 0.0=don't move)")
	public static float Physical_Hammer = 1.0F;
	@MLProp(info = "Players Attribute.provided when is no PlayerAPI.(false=nomal, true=Undead)")
	public static boolean Physical_Undead = false;
	@MLProp(info = "DamegeSound.(default = damage.hurtflesh)")
	public static String Physical_HurtSound = "random.hurt";
	// @MLProp(info="Additional Item Capture Range.(default = 0.0)")
	public static float Physical_CaptureRange = 0.0F;

	@MLProp(info = "Enable SkinLoad Model.")
	public static boolean isSkinLoad = true;
	@MLProp(info = "Female silhouette.")
	public static boolean SkinLoad_ModelFemale = false;
	@MLProp(info = "Headwear move with Head.")
	public static boolean SkinLoad_ModelHeadWare = true;
	@MLProp(info = "Eye blink invert.")
	public static boolean SkinLoad_ModelInvertBlink = false;
	@MLProp(info = "Add bust typeA.")
	public static boolean SkinLoad_ModelBustTypeA = false;
	@MLProp(info = "Add bust typeB.")
	public static boolean SkinLoad_ModelBustTypeB = false;
	@MLProp(info = "Add SideTail L.")
	public static boolean SkinLoad_ModelSideTailL = true;
	@MLProp(info = "Add SideTail R.")
	public static boolean SkinLoad_ModelSideTailR = true;
	@MLProp(info = "Add Ponytail.")
	public static boolean SkinLoad_ModelPonytail = false;
	@MLProp(info = "Add LongHair.")
	public static boolean SkinLoad_ModelLongHair = false;
	@MLProp(info = "Add Chignon.")
	public static boolean SkinLoad_ModelChignon = false;
	@MLProp(info = "Add Skirt.")
	public static boolean SkinLoad_ModelSkirt = true;
	@MLProp(info = "using Texture file name. null is upload texture.(nomal=/mod/char.png)")
	public static String SkinLoad_Texture = "/mob/char_skin.png";
	@MLProp
	public static boolean isDebugMessage = true;

	public static boolean isPlayerAPI = false;
	public static boolean isRenderPlayerAPI = false;
	public static Map<String, EPS_EntityCaps> capsMap = new HashMap<String, EPS_EntityCaps>();


	public static void Debug(String pMes, Object... pVal) {
		if (isDebugMessage) {
			System.out.println(String.format("PlayerFormSkinLoad-" + pMes, pVal));
		}
	}

	@Override
	public String getVersion() {
		return "1.6.2-1x";
	}

	@Override
	public String getName() {
		return "PlayerFormSkinLoad2";
	}

	@Override
	public String getPriorities() {
//		return "required-after:mod_MMM_MMMLib;after:mod_SmartRender";
		return "required-after:mod_MMM_MMMLib";
	}

	@Override
	public void load() {
		// MMMLibのRevisionチェック
		MMM_Helper.checkRevision("5");
		MMM_FileManager.getModFile("PlayerForm", "PlayerForm");
		MMM_TextureManager.instance.addSearch("PlayerForm", "/assets/minecraft/textures/entity/ModelMulti/", "ModelMulti_");
		
		// 前提PlayerAPI
		// オプションRenderPlayerAPI
//		ModLoader.setInGUIHook(this, true, false);
		
		
		// PlayerAPI判定
		if (isPhysical) {
			try {
				Class lclass = MMM_Helper.getNameOfClass("PlayerAPI");
				Method mes = lclass.getMethod("register", new Class[] { String.class, Class.class });
//TODO:				mes.invoke(null, getName(), PFSL_PlayerAPI.class);
				isPlayerAPI = true;
				Debug("PlayerAPI Provide.");
			} catch (Exception e) {
				ModLoader.getLogger().fine((new StringBuilder("PlayerAPI not found! ")).toString());
				Debug("PlayerAPI not found!");
			}
		}
		// RenderAPI判定
		if (isSkinLoad) {
			try {
				Class lclass = MMM_Helper.getNameOfClass("RenderPlayerAPI");
				Method mes;
				// SmartMovingの描画分を強制排除
//				mes = lclass.getMethod("unregister", new Class[] { String.class });
//				mes.invoke(null, "Smart Render");
				// PFSL用のものを追加
				mes = lclass.getMethod("register", new Class[] { String.class, Class.class });
//TODO:				mes.invoke(null, getName(), PFSL_RenderPlayerAPI.class);
				isRenderPlayerAPI = true;
				Debug("RenderPlayerAPI Provide.");
			} catch (Exception e) {
				Debug("RenderPlayerAPI not found!");
			}
		}
		
		// テスト
		if (isToggleCreativemodeKey) {
			String s = "key.creative";
			ModLoader.registerKey(this, new KeyBinding(s, 24), false);
			ModLoader.addLocalization((new StringBuilder()).append(s).toString(),
					(new StringBuilder()).append("Toggle CreativeMode").toString());
		}
		String s = "key.pfVisible";
		ModLoader.registerKey(this, new KeyBinding(s, 26), false);
		ModLoader.addLocalization(s, "Model Assemble");
	}

	@Override
	public void modsLoaded() {
		MMM_TextureManager.instance.setDefaultTexture(EntityPlayer.class, MMM_TextureManager.instance.getTextureBox("Crafter_Steve"));
	}

	@Override
	public void addRenderer(Map map) {
		// プレーヤーフォルムの置き換え
		if (isSkinLoad) {
			map.put(EntityPlayer.class, new EPS_RenderPlayer());
		}
	}

	@Override
	public void keyboardEvent(KeyBinding keybinding) {
		Minecraft mcGame = MMM_Helper.mc;
		if (mcGame.theWorld != null && mcGame.currentScreen == null) {
			if (keybinding.keyDescription == "key.creative") {
				if (mcGame.playerController.isInCreativeMode()) {
					mcGame.thePlayer.sendChatMessage("/gamemode 0");
				} else {
					mcGame.thePlayer.sendChatMessage("/gamemode 1");
				}
			}
			if (keybinding.keyDescription == "key.pfVisible") {
				EPS_EntityCaps lcaps = getEntityCaps(mcGame.thePlayer);
				mcGame.displayGuiScreen(new EPS_GuiVisibleSelect(null, lcaps));
			}
		}
	}

	@Override
	public boolean onTickInGUI(float f, Minecraft minecraft, GuiScreen guiscreen) {
		// GUI置き換え
		if (minecraft.playerController.isInCreativeMode()
				&& guiscreen instanceof GuiEnchantment) {
/*
			// エンチャントの効果表示
			if (!(guiscreen instanceof GuiPlayerFormEnchantmentView)) {
				try {
					ContainerEnchantment ce = (ContainerEnchantment) ((GuiEnchantment) guiscreen).inventorySlots;
					int i = (Integer) ModLoader.getPrivateValue(
							ContainerEnchantment.class, ce, 2);
					int j = (Integer) ModLoader.getPrivateValue(
							ContainerEnchantment.class, ce, 3);
					int k = (Integer) ModLoader.getPrivateValue(
							ContainerEnchantment.class, ce, 4);
					minecraft.displayGuiScreen(new GuiPlayerFormEnchantmentView(
							minecraft.thePlayer.inventory,
							minecraft.theWorld, i, j, k));
					System.out.println("Swap GuiEnchantment.");
				} catch (Exception e) {
				}
			}
			*/
		}
		return true;
	}

	public static EPS_EntityCaps getEntityCaps(EntityPlayer pPlayer) {
		EPS_EntityCaps lcaps;
		if (capsMap.containsKey(pPlayer.username)) {
			lcaps = capsMap.get(pPlayer.username);
			lcaps.setOwner(pPlayer);
			return lcaps;
		}
		lcaps = new EPS_EntityCaps(pPlayer);
		capsMap.put(pPlayer.username, lcaps);
		return lcaps;
	}

}
