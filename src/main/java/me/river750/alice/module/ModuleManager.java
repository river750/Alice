package me.river750.alice.module;

import me.river750.alice.module.combat.TestCombat;
import me.river750.alice.module.exploit.TestExploit;
import me.river750.alice.module.misc.TestMisc;
import me.river750.alice.module.movement.Sprint;
import me.river750.alice.module.player.TestPlayer;
import me.river750.alice.module.render.ClickGUI;

import java.util.ArrayList;

public class ModuleManager {
    // インスタンス生成
    public ArrayList<Module> modules = new ArrayList<>();

    // コンストラクタ（モジュールを追加）
    public ModuleManager() {
        modules.add(new Sprint());
        modules.add(new ClickGUI());
        modules.add(new TestCombat());
        modules.add(new TestExploit());
        modules.add(new TestMisc());
        modules.add(new TestPlayer());
    }
}
