package me.river750.alice.event;

import me.river750.alice.Alice;
import me.river750.alice.module.Module;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class PlayerTickEvent {
    @SubscribeEvent
    // ティック更新の際のイベントハンドラ
    public void onPlayerTick(TickEvent.PlayerTickEvent e) {
        if (e.phase != TickEvent.Phase.START)
            return;
        if (e.player != Minecraft.getMinecraft().player)
            return;
        // モジュールを参照
        for (Module m : Alice.module.modules) {
            // モジュールが有効になっているか
            if (m.istoggled)
                // アップデートする
                m.onUpdate();
        }
    }
}
