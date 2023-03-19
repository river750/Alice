package me.river750.alice.event;

import me.river750.alice.Alice;
import me.river750.alice.module.Module;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.lwjgl.input.Keyboard;

public class PlayerKeyInputEvent {
    @SubscribeEvent
    // キーバインドの実装
    public void toggle(InputEvent.KeyInputEvent e) {
        // ワールドとプレーヤーが存在するか
        if (Minecraft.getMinecraft().player == null || Minecraft.getMinecraft().world ==null)
            return;
        // キー入力がされているか
        if (Keyboard.isCreated() && Keyboard.getEventKeyState()) {
            int key = Keyboard.getEventKey();
            // モジュールを参照
            for (Module m : Alice.module.modules) {
                // 各モジュールに設定されたキーバインドと一致するものがあるか
                if (m.keybind == key) {
                    // トグルする
                    m.toggle();
                    return;
                }
            }
        }
    }
}
