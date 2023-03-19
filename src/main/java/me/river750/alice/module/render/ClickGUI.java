package me.river750.alice.module.render;

import me.river750.alice.gui.clickgui.ClickGui;
import me.river750.alice.module.Category;
import me.river750.alice.module.Module;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;

public class ClickGUI extends Module {
    // コンストラクタ
    public ClickGUI() {
        super("ClickGUI", Category.MOVEMENT, Keyboard.KEY_RSHIFT);
    }

    @Override
    public void onEnable() {
        // mc.displayGuiScreen(new ClickGui());
    }
}
