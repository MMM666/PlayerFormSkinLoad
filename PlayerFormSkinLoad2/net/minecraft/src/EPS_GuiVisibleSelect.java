package net.minecraft.src;

public class EPS_GuiVisibleSelect extends GuiScreen {

	public GuiScreen ownerScreen;
	public MMM_GuiToggleButton select[] = new MMM_GuiToggleButton[32];
	public EPS_EntityCaps target;


	public EPS_GuiVisibleSelect(GuiScreen pOwnerScreen, EPS_EntityCaps pTarget) {
		ownerScreen = pOwnerScreen;
		target = pTarget;
	}

	@Override
	public void initGui() {
		String lswitch = (String)target.getCapsValue(MMM_IModelCaps.caps_PartsStrings);
		if (lswitch != null) {
			String lbutton[] = lswitch.split(",");
			int lvisible = MMM_ModelCapsHelper.getCapsValueInt(target, MMM_IModelCaps.caps_PartsVisible);
			
			for (int li = 0; li < 32 && lbutton.length > li; li++) {
				if (lbutton[li] != null) {
//					select[li] = new MMM_GuiToggleButton(li, width - 80 * (3 - li / 12), (li % 12) * 20, 80, 20, lbutton[li]);
					select[li] = new MMM_GuiToggleButton(li, width - 80 * (1 + li / 12), (li % 12) * 20, 80, 20, lbutton[li]);
					if ((lvisible & (1 << li)) > 0) {
						select[li].isDown = true;
					}
					buttonList.add(select[li]);
				}
			}
		}
		buttonList.add(new MMM_GuiToggleButton(100, width - 80 * (1 + 34 / 12), (34 % 12) * 20, 80, 20, "TexSel"));
	}

	@Override
	public void drawScreen(int par1, int par2, float par3) {
		drawDefaultBackground();
		super.drawScreen(par1, par2, par3);
		drawString(fontRenderer, "Visivle", 10, 10, 0xffffff);
	}

	@Override
	protected void actionPerformed(GuiButton par1GuiButton) {
		if (par1GuiButton.id < 32) {
			((MMM_GuiToggleButton)par1GuiButton).isDown = !((MMM_GuiToggleButton)par1GuiButton).isDown;
			
			int lval = 0;
			for (int li = 0; li < 32; li++) {
				if (select[li] != null && select[li].isDown) {
					lval |= (1 << li);
				}
			}
			target.setCapsValue(MMM_IModelCaps.caps_PartsVisible, lval);
		}
		if (par1GuiButton.id == 100) {
			mc.displayGuiScreen(new MMM_GuiTextureSelect(this, target, 0xffff, false));
		}
	}

}
