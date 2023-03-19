package me.river750.alice.module;

import com.mojang.realmsclient.gui.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.common.MinecraftForge;

public class Module {
    // メンバ変数
    public String name;
    public Category category;
    public boolean istoggled;
    public int keybind;

    // コンストラクタ
    public Module(String name, Category category, int keybind) {
        super();
        this.name = name;
        this.category = category;
        this.keybind = keybind;
        this.istoggled = false;
    }

    // チャットにメッセージを送信
    public static void sendMessage(String content) {
        Minecraft.getMinecraft().player.sendMessage(new TextComponentString( ChatFormatting.RED + "[Alice] " + ChatFormatting.GRAY + content));
    }

    // 有効なときに行われる処理
    // イベントハンドラの登録
    public void enable() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    // 無効なときに行われる処理
    // イベントハンドラの登録解除
    public void disable() {
        MinecraftForge.EVENT_BUS.unregister(this);
    }

    // 有効にしたときに行われる処理
    public void onEnable() {
        sendMessage(this.name + " has been enabled");
    }

    // 無効にしたときに行われる処理
    public void onDisable() {
        sendMessage(this.name + " has been disabled");
    }

    // 変更があったときに行われる処理
    public void onUpdate() { }

    // トグルしたときに行われる処理
    // 有効なら無効にして、無効なら有効にする
    public void toggle() {
        if (istoggled) {
            onDisable();
            disable();
        } else {
            enable();
            onEnable();
        }
        istoggled = !istoggled;
    }

    // モジュールの名前を取得
    public String getName() {
        return this.name;
    }
    // モジュールの名前の長さを取得
    public int getNameLength() {
        return this.name.length();
    }
}
