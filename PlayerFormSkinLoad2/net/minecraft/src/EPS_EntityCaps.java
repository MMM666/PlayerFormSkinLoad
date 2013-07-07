package net.minecraft.src;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Entityのデータ読み取り用のクラス
 * 別にEntityにインターフェース付けてもOK
 */
public class EPS_EntityCaps extends MMM_EntityCaps implements MMM_ITextureEntity {

	protected EntityPlayer owner;
	private static Map<String, Integer> caps;
	
	protected ItemStack equipItem[] = new ItemStack[2];
	protected EnumAction actions[] = new EnumAction[2];
	protected float grounds[] = new float[] {0F, 0F};
	protected int visible;
//	protected MMM_TextureBox texture;
	
	protected int textureIndex[] = new int[] {0, 0};
	protected MMM_TextureBoxBase textureBox[] = new MMM_TextureBoxBase[2];
	protected int color;
	protected boolean contract = true;
	protected ResourceLocation textures[][] = new ResourceLocation[][] {
			{null, null},
			{null, null, null ,null},
			{null, null, null ,null}
	};



	static {
		caps = new HashMap<String, Integer>();
		caps.put("isBlocking", caps_isBlocking);
		caps.put("isOpenInv", caps_isOpenInv);
		caps.put("isMasked", caps_isMasked);
		caps.put("isCamouflage", caps_isCamouflage);
		caps.put("isPlanter", caps_isPlanter);
		caps.put("entityIdFactor", caps_entityIdFactor);
		caps.put("height", caps_height);
		caps.put("width", caps_width);
		caps.put("YOffset", caps_YOffset);
		caps.put("dominantArm", caps_dominantArm);
		caps.put("HeadMount", caps_HeadMount);
		caps.put("stabiliser", caps_stabiliser);
		caps.put("Items", caps_Items);
		caps.put("Actions", caps_Actions);
		caps.put("Grounds", caps_Grounds);
		caps.put("Ground", caps_Ground);
		caps.put("Inventory", caps_Inventory);
		caps.put("Entity", caps_Entity);
		caps.put("health", caps_health);
		caps.put("currentArmor", caps_currentArmor);
		caps.put("currentEquippedItem", caps_currentEquippedItem);
	}

	public EPS_EntityCaps(EntityPlayer pOwner) {
		super(pOwner);
		owner = pOwner;
		textureBox[0] = textureBox[1] = MMM_TextureManager.instance.getDefaultTexture(EntityPlayer.class);
		color = textureBox[0].getRandomContractColor(new Random());
		setTextureNames();
	}

	public void setOwner(EntityPlayer pOwner) {
		owner = pOwner;
	}

	@Override
	public Map<String, Integer> getModelCaps() {
		return caps;
	}

	@Override
	public Object getCapsValue(int pIndex, Object ...pArg) {
		int li = 0;
		ItemStack lish = owner.inventory.getStackInSlot(35);
		Block lblock = (lish != null && lish.getItem() instanceof ItemBlock) ? Block.blocksList[lish.itemID] : null;
		
		switch (pIndex) {
		case caps_Entity:
			return owner;
		case caps_health:
			return (int)owner.func_110143_aJ();
		case caps_healthFloat:
			return owner.func_110143_aJ();
		case caps_isBlocking:
			return owner.isBlocking();
		case caps_isOpenInv:
			return MMM_Helper.mc.currentScreen != null;
		case caps_isMasked:
			return owner.getCurrentArmor(3) != null;
		case caps_isCamouflage:
			return lblock != null && lblock instanceof BlockLeavesBase;
		case caps_isPlanter:
			return lblock != null && lblock instanceof BlockFlower;
		case caps_entityIdFactor:
			return (float)(owner.entityId * 70);
		case caps_height:
			return owner.height;
		case caps_width:
			return owner.width;
		case caps_YOffset:
			return owner.yOffset;
		case caps_dominantArm:
			return 0;
		case caps_HeadMount:
			return lish;
//		case caps_HardPoint:
		case caps_Items:
			equipItem[0] = owner.getCurrentEquippedItem();
			equipItem[1] = null;
			return equipItem;
		case caps_Actions:
			actions[0] = owner.isUsingItem() ? owner.getItemInUse().getItemUseAction() : null;
			actions[1] = null;
			return actions;
		case caps_Grounds:
			grounds[0] = owner.getSwingProgress(pArg != null ? (Float)pArg[0] : 0F);
			grounds[1] = 0F;
			return grounds;
		case caps_Ground:
			return owner.getSwingProgress(pArg != null ? (Float)pArg[0] : 0);
		case caps_Inventory:
			return owner.inventory;
		case caps_currentArmor:
			return owner.getCurrentArmor((Integer)pArg[0]);
		case caps_currentEquippedItem:
			return owner.getCurrentEquippedItem();
		case caps_PartsVisible:
			return visible;
		case caps_PartsStrings:
			return ((MMM_TextureBox)textureBox[0]).models[0].getCapsValue(caps_PartsStrings);
//			return "BustA,BustB,SideTailR,SideTailL,PonyTail,LongHair,Chignon,Skirt,InvertEyeBlink,HatWear,Gender,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32";
		}
		
		return null;
	}

	@Override
	public boolean setCapsValue(int pIndex, Object... pArg) {
		switch (pIndex) {
		case caps_PartsVisible:
			visible = (Integer)pArg[0];
			return true;
		}
		return false;
	}


	//

	@Override
	public void setTexturePackIndex(int pColor, int[] pIndex) {
		color = pColor;
		textureIndex[0] = pIndex[0];
		textureIndex[1] = pIndex[1];
		// TODO : Clientへ値を通知
	}

	@Override
	public void setTexturePackName(MMM_TextureBox[] pTextureBox) {
		textureBox[0] = pTextureBox[0];
		textureBox[1] = pTextureBox[1];
		setTextureNames();
	}

	/**
	 * テクスチャのファイル名を獲得
	 */
	protected void setTextureNames() {
		textures[0][0] = ((MMM_TextureBox)textureBox[0]).getTextureName(color + (contract ? 0 : MMM_TextureManager.tx_wild));
		textures[0][1] = ((MMM_TextureBox)textureBox[0]).getTextureName(color + (contract ? MMM_TextureManager.tx_eye : MMM_TextureManager.tx_eye));
		textures[1][0] = ((MMM_TextureBox)textureBox[1]).getArmorTextureName(MMM_TextureManager.tx_armor1, owner.getCurrentArmor(0));
		textures[1][1] = ((MMM_TextureBox)textureBox[1]).getArmorTextureName(MMM_TextureManager.tx_armor1, owner.getCurrentArmor(1));
		textures[1][2] = ((MMM_TextureBox)textureBox[1]).getArmorTextureName(MMM_TextureManager.tx_armor1, owner.getCurrentArmor(2));
		textures[1][3] = ((MMM_TextureBox)textureBox[1]).getArmorTextureName(MMM_TextureManager.tx_armor1, owner.getCurrentArmor(3));
		textures[2][0] = ((MMM_TextureBox)textureBox[1]).getArmorTextureName(MMM_TextureManager.tx_armor2, owner.getCurrentArmor(0));
		textures[2][1] = ((MMM_TextureBox)textureBox[1]).getArmorTextureName(MMM_TextureManager.tx_armor2, owner.getCurrentArmor(1));
		textures[2][2] = ((MMM_TextureBox)textureBox[1]).getArmorTextureName(MMM_TextureManager.tx_armor2, owner.getCurrentArmor(2));
		textures[2][3] = ((MMM_TextureBox)textureBox[1]).getArmorTextureName(MMM_TextureManager.tx_armor2, owner.getCurrentArmor(3));
	}

	@Override
	public void setColor(int pColor) {
		color = pColor;
	}

	@Override
	public int getColor() {
		return color;
	}

	@Override
	public void setContract(boolean pContract) {
		contract = pContract;
	}

	@Override
	public boolean isContract() {
		return contract;
	}

	@Override
	public void setTextureBox(MMM_TextureBoxBase[] pTextureBox) {
		textureBox = pTextureBox;
	}

	@Override
	public MMM_TextureBoxBase[] getTextureBox() {
		return textureBox;
	}

	@Override
	public void setTextureIndex(int[] pTextureIndex) {
		textureIndex = pTextureIndex;
	}

	@Override
	public int[] getTextureIndex() {
		return textureIndex;
	}

	@Override
	public void setTextures(int pIndex, ResourceLocation[] pNames) {
		textures[pIndex] = pNames;
	}

	@Override
	public ResourceLocation[] getTextures(int pIndex) {
		return textures[pIndex];
	}

}
