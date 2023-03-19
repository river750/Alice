package me.river750.alice.command.commands;

import me.river750.alice.Alice;
import me.river750.alice.command.Command;
import me.river750.alice.module.Module;
import org.lwjgl.input.Keyboard;

public class Bind extends Command {
    // コンストラクタ
    public Bind() {
        super("Bind");
    }

    @Override
    // 実行されたときの処理
    public void onCommand() {
        try {
            // モジュールを参照
            for (Module m : Alice.module.modules) {
                if (m.name.toLowerCase().equals(getArg(1).toLowerCase())) {
                    // キーバインド登録
                    m.keybind = Keyboard.getKeyIndex(getArg(2).toUpperCase());
                    // メッセージ送信
                    sendMessage(m.name + " was bound to " + Keyboard.getKeyName(m.keybind));
                    return;
                }
            }
            sendMessage("no such module");
        } catch (Exception ex) {
            sendMessage("error");
        }
    }
}
