package me.river750.alice.gui.clickgui;

import me.river750.alice.module.Category;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ClickGui extends GuiScreen {
    // インスタンス生成
    public List<Panel> panels = new ArrayList<>();

    @Override
    public void initGui() {
        if (this.panels.isEmpty()) {
            int x = 10;
            for (Category category : Category.values()) {
                panels.add(new Panel(category, x, 10, 100, 15, Minecraft.getMinecraft()));
                x += 110;
            }
        }
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.panels.forEach(panel -> panel.drawScreen(mouseX, mouseY, partialTicks));
    }

    @Override
    public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
        this.panels.forEach(panel -> panel.mouseClicked(mouseX, mouseY, mouseButton));
    }

    @Override
    public void keyTyped(char typedChar, int keyCode) {
        this.panels.forEach(panel -> panel.keyTyped(typedChar, keyCode));
        try { super.keyTyped(typedChar, keyCode); } catch (IOException ignored) { }
    }
}
