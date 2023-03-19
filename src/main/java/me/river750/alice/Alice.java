package me.river750.alice;

import me.river750.alice.event.PlayerKeyInputEvent;
import me.river750.alice.event.PlayerTickEvent;
import me.river750.alice.command.CommandManager;
import me.river750.alice.gui.Hud;
import me.river750.alice.module.ModuleManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;
import org.lwjgl.opengl.Display;

// MOD宣言
@Mod(modid = Alice.MOD_ID, name = Alice.NAME, version = Alice.VERSION)
public class Alice {
    // メンバ変数
    public static final String MOD_ID = "alice";
    public static final String NAME = "Alice Client";
    public static final String VERSION = "0.3.0";

    private static Logger logger;

    // インスタンス生成（クライアント起動時に呼び出すものを登録）
    public static ModuleManager module = new ModuleManager();
    public PlayerKeyInputEvent playerKeyInputEvent = new PlayerKeyInputEvent();
    public PlayerTickEvent playerTickEvent = new PlayerTickEvent();
    public Hud hud = new Hud();
    public CommandManager commands = new CommandManager();

    @EventHandler
    // Minecraftが起動して一番最初に実行される処理
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
    }

    @EventHandler
    // MODが読み込まれたときに実行される処理
    public void init(FMLInitializationEvent event) {
        // ウインドウのタイトルを変更
        Display.setTitle(NAME + " " + VERSION);

        // EventBusの登録
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(playerKeyInputEvent);
        MinecraftForge.EVENT_BUS.register(playerTickEvent);
        MinecraftForge.EVENT_BUS.register(hud);
        MinecraftForge.EVENT_BUS.register(commands);
    }
}
