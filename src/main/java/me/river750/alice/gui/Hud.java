package me.river750.alice.gui;

import me.river750.alice.Alice;
import me.river750.alice.module.Module;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.awt.*;
import java.util.Collections;
import java.util.Comparator;

// minecraftのGuiScreenを継承
public class Hud extends GuiScreen {
    Minecraft mc = Minecraft.getMinecraft();

    @SubscribeEvent
    // GuiScreenクラスにSubscribeEvent属性を付与したhudメソッドを追加
    public void hud(RenderGameOverlayEvent e) {
        // インスタンス生成（画面の解像度を取得）
        ScaledResolution resolution = new ScaledResolution(mc);
        // 画面上に文字を描画
        FontRenderer renderer = mc.fontRenderer;

        if (e.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
            // 左上にクライアント名を表示
            renderer.drawString(Alice.NAME + " " + Alice.VERSION, 5, 5, Color.MAGENTA.getRGB());
        }

        if (e.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
            int y = 5;

            // ArrayListをモジュールの文字の長さでソート
            Alice.module.modules.sort(Comparator.comparingInt(Module::getNameLength).thenComparing(Module::getName));
            Collections.reverse(Alice.module.modules);

            // モジュールの参照
            for (Module m : Alice.module.modules) {
                // 有効化されているか
                if (m.istoggled) {
                    // 右上にArrayListを表示
                    renderer.drawString(m.name, resolution.getScaledWidth() - renderer.getStringWidth(m.name) - 5, y, Color.MAGENTA.getRGB());
                    // y座標を文字の高さ分ずらす
                    y += renderer.FONT_HEIGHT + 1;
                }
            }
        }

    }
}
