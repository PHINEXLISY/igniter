package io.github.trojan_gfw.igniter.initializer;

import android.content.Context;

import io.github.trojan_gfw.igniter.Globals;

/**
 * 在主进程（默认进程）运行的初始化器
 * Initializer that runs in Main Process (Default process).
 */
public class MainInitializer extends Initializer {

    @Override
    public void init(Context context) {
        Globals.Init(context);
    }

    @Override
    public boolean runsInWorkerThread() {
        return false;
    }
}
