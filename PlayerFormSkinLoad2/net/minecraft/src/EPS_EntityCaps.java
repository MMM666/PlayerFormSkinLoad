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
	
	protected MMM_TextureData textureData;
	
//	protected int textureIndex[] = new int[] {0, 0};
//	protected MMM_TextureBoxBase textureBox[] = new MMM_TextureBoxBase[2];
//	protected int color;
//	protected boolean contract = true;
//	protected ResourceLocation textures[][] = new ResourceLocation[][] {
//			{null, null},
//			{null, null, null ,null},
//			{null, null, null ,null}
//	};



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
		caps.put("TextureEntity", caps_TextureEntity);
	}

	public EPS_EntityCaps(EntityPlayer pOwner) {
		super(pOwner);
		owner = pOwner;
		textureData = new MMM_TextureData(pOwner, this);
		textureData.setContract(true);
//		textureData.setTextureInit(MMM_TextureManager.instance.getDefaultTexture(EntityPlayer.class));
		MMM_TextureBox lbox = MMM_TextureManager.instance.getDefaultTexture(EntityPlayer.class);
		textureData.textureBox[0] = textureData.textureBox[1] = lbox;
		textureData.textureIndex[0] = textureData.textureIndex[1] = MMM_TextureManager.instance.getIndexTextureBoxServerIndex(lbox);
		textureData.setColor(textureData.textureBox[0].getRandomContractColor(owner.rand));

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
			return ((MMM_TextureBox)textureData.textureBox[0]).models[0].getCapsValue(caps_PartsStrings);
//			return "BustA,BustB,SideTailR,SideTailL,PonyTail,LongHair,Chignon,Skirt,InvertEyeBlink,HatWear,Gender,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32";
		case caps_TextureEntity:
			return this;
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
		// TODO : Clientへ値を通知
		textureData.setTexturePackIndex(pColor, pIndex);
	}

	@Override
	public void setTexturePackName(MMM_TextureBox[] pTextureBox) {
		textureData.setTexturePackName(pTextureBox);
		setTextureNames();
	}

	/**
	 * テクスチャのファイル名を獲得
	 */
	protected void setTextureNames() {
		textureData.setTextureNames();
	}

	@Override
	public void setColor(int pColor) {
		textureData.setColor(pColor);
	}

	@Override
	public int getColor() {
		return textureData.getColor();
	}

	@Override
	public void setContract(boolean pContract) {
		textureData.setContract(pContract);
	}

	@Override
	public boolean isContract() {
		return textureData.isContract();
	}

	@Override
	public void setTextureBox(MMM_TextureBoxBase[] pTextureBox) {
		textureData.setTextureBox(pTextureBox);
	}

	@Override
	public MMM_TextureBoxBase[] getTextureBox() {
		return textureData.getTextureBox();
	}

	@Override
	public void setTextureIndex(int[] pTextureIndex) {
		textureData.setTextureIndex(pTextureIndex);
	}

	@Override
	public int[] getTextureIndex() {
		return textureData.getTextureIndex();
	}

	@Override
	public void setTextures(int pIndex, ResourceLocation[] pNames) {
		textureData.setTextures(pIndex, pNames);
	}

	@Override
	public ResourceLocation[] getTextures(int pIndex) {
		return textureData.getTextures(pIndex);
	}

	@Override
	public MMM_TextureData getTextureData() {
		return textureData;
	}

}
