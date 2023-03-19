package me.river750.alice.module.movement;

import me.river750.alice.module.Category;
import me.river750.alice.module.Module;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;

public class Sprint extends Module {
    // コンストラクタ
    public Sprint() {
        super("Sprint", Category.MOVEMENT, Keyboard.KEY_NONE);
    }

    @Override
    public void onUpdate() {
        // 前に進んでいるか
        if (Minecraft.getMinecraft().player.moveForward > 0) {
            // 走る
            Minecraft.getMinecraft().player.setSprinting(true);
        }
    }
}
