package me.river750.alice.command.commands;

import me.river750.alice.Alice;
import me.river750.alice.command.Command;
import me.river750.alice.module.Module;

public class Toggle extends Command {
    // コンストラクタ
    public Toggle() {
        super("Toggle");
    }

    @Override
    // 実行されたときの処理
    public void onCommand() {
        try {
            // モジュールを参照
            for (Module m : Alice.module.modules) {
                if (m.name.toLowerCase().equals(getArg(1).toLowerCase())) {
                    // トグルする
                    m.toggle();
                    return;
                }
            }
            sendMessage("no such module");
        } catch (Exception ex) {
            sendMessage("error");
        }
    }
}
