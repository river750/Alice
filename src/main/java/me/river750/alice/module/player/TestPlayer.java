package me.river750.alice.module.player;

import me.river750.alice.module.Category;
import me.river750.alice.module.Module;
import org.lwjgl.input.Keyboard;

public class TestPlayer extends Module {
    // コンストラクタ
    public TestPlayer() {
        super("TestPlayer", Category.MOVEMENT, Keyboard.KEY_NONE);
    }
}
