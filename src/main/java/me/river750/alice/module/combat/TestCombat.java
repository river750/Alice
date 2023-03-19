package me.river750.alice.module.combat;

import me.river750.alice.module.Category;
import me.river750.alice.module.Module;
import org.lwjgl.input.Keyboard;

public class TestCombat extends Module {
    // コンストラクタ
    public TestCombat() {
        super("TestCombat", Category.MOVEMENT, Keyboard.KEY_NONE);
    }
}
