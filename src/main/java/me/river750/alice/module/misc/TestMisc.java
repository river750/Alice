package me.river750.alice.module.misc;

import me.river750.alice.module.Category;
import me.river750.alice.module.Module;
import org.lwjgl.input.Keyboard;

public class TestMisc extends Module {
    // コンストラクタ
    public TestMisc() {
        super("TestMisc", Category.MOVEMENT, Keyboard.KEY_NONE);
    }
}
