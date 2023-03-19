package me.river750.alice.gui.clickgui;

import me.river750.alice.Alice;
import me.river750.alice.module.Category;
import me.river750.alice.module.Module;
import net.minecraft.client.Minecraft;

import java.util.ArrayList;
import java.util.List;

public class Panel {
    // メンバ変数 + インスタンス生成
    private final Category category;
    private final int x;
    private final int y;
    private final int width;
    private final int height;
    private final Minecraft mc;
    private final List<Button> moduleButtons = new ArrayList<>();
    private boolean open = true;

    // コンストラクタ
    public Panel(Category category, int x, int y, int width, int height, Minecraft mc) {
        this.category = category;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.mc = mc;

        for (Module module : Alice.module.modules) {
            if (module.category == this.category) {
                moduleButtons.add(new Button(module, x, y + height, width, height, mc));
            }
        }
    }

    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        RenderUtil.rect(x, y, width, height, 0xFF2B71F3);
        mc.fontRenderer.drawStringWithShadow(category.name(),
                x + width / 2f - mc.fontRenderer.getStringWidth(category.name()) / 2f,
                y + height / 2f - mc.fontRenderer.FONT_HEIGHT / 2f,
                -1);

        int offset = 0;
        if (this.open) {
            for (Button moduleButton : this.moduleButtons) {
                moduleButton.drawScreen(mouseX, mouseY, partialTicks, offset);
                offset += this.height;
            }
        }
    }

    public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
        moduleButtons.forEach(moduleButton -> moduleButton.mouseClicked(mouseX, mouseY, mouseButton));

        if (bounding(mouseX, mouseY) && mouseButton == 1) this.open = !this.open;
    }

    public void keyTyped(char typedChar, int keyCode) {
        if (this.open) moduleButtons.forEach(moduleButton -> moduleButton.keyTyped(typedChar, keyCode));
    }

    public boolean bounding(int mouseX, int mouseY) {
        if (mouseX < this.x) return false;
        if (mouseX > this.x + this.width) return false;
        if (mouseY < this.y) return false;
        return mouseY <= this.y + this.height;
    }
}
