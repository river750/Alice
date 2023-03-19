package me.river750.alice.command;

import com.mojang.realmsclient.gui.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.TextComponentString;

public class Command {
    // メンバ変数
    public String name;
    public String commandInput;

    // コンストラクタ
    public Command(String name) {
        super();
        this.name = name;
    }

    // コマンドが実行されたときに行われる処理
    public void onCommand() { }

    // ?
    public String getArg(int i) {
        return commandInput.split(" ")[i];
    }

    // チャットにメッセージを送信
    public static void sendMessage(String content) {
        Minecraft.getMinecraft().player.sendMessage(new TextComponentString( ChatFormatting.RED + "[Alice] " + ChatFormatting.GRAY + content));
    }
}
