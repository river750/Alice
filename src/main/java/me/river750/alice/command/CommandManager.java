package me.river750.alice.command;

import me.river750.alice.command.commands.Bind;
import me.river750.alice.command.commands.Toggle;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.lwjgl.input.Keyboard;

import java.util.ArrayList;
import java.util.Objects;

public class CommandManager {
    // メンバ変数 + インスタンス生成
    public ArrayList<Command> commands = new ArrayList<>();
    public String PREFIX = "-";

    // コンストラクタ（コマンドを追加）
    public CommandManager() {
        commands.add(new Toggle());
        commands.add(new Bind());
    }

    @SubscribeEvent
    // 入力されたキーを取得
    public void key(InputEvent.KeyInputEvent e) {
        // ワールドとプレーヤーが存在するか
        if (Minecraft.getMinecraft().world == null || Minecraft.getMinecraft().player == null) {
            return;
        }
        // キー入力がされているか
        if (Keyboard.isCreated() && Keyboard.getEventKeyState()) {
            final char key = Keyboard.getEventCharacter();
            if (PREFIX.charAt(0) == key) {
                Minecraft.getMinecraft().displayGuiScreen(new GuiChat(PREFIX));
            }
        }
    }

    @SubscribeEvent
    // チャットに入力された文字を取得
    public void listener(ClientChatEvent e) {
        // ワールドとプレーヤーが存在するか
        if (Minecraft.getMinecraft().world == null || Minecraft.getMinecraft().player == null) {
            return;
        }
        String content = String.valueOf(e.getMessage()).toLowerCase();
        // prefixから始まっているか
        if (content.startsWith(PREFIX)) {
            e.setCanceled(true);
            // コマンドを参照
            for (Command c : commands) {
                // コマンドと一致するものがあるか
                if (Objects.equals(c.name.toLowerCase(), content.split(" ")[0].replace(PREFIX, ""))) {
                    c.commandInput = content;
                    c.onCommand();
                    return;
                }
            }
        } else {
            return;
        }
        Command.sendMessage("no such command");
    }
}
