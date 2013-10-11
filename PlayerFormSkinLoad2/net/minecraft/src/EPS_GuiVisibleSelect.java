package net.minecraft.src;

import org.lwjgl.opengl.EXTRescaleNormal;
import org.lwjgl.opengl.GL11;

public class EPS_GuiVisibleSelect extends MMM_GuiVisibleSelect {

	public EPS_GuiVisibleSelect(GuiScreen pOwnerScreen, EPS_EntityCaps pTarget) {
		super(pOwnerScreen, pTarget);
	}

	@Override
	public void initAddetionalButton() {
		buttonList.add(new MMM_GuiToggleButton(200, width - 80 * (1 + 34 / 12), (34 % 12) * 20, 80, 20, "TexSel"));
	}

	@Override
	protected void actionPerformed(GuiButton par1GuiButton) {
		if (par1GuiButton.id == 200) {
			mc.displayGuiScreen(new MMM_GuiTextureSelect(this, (MMM_ITextureEntity)target, 0xffff, false));
		}
		super.actionPerformed(par1GuiButton);
	}

}
