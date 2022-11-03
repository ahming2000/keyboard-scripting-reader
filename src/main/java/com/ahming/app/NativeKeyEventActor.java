package com.ahming.app;

import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

import java.awt.event.KeyEvent;

public class NativeKeyEventActor implements NativeKeyListener {
    @Override
    public void nativeKeyPressed(NativeKeyEvent nativeEvent) {
        // Toggle start and stop running the script
        int DEFAULT_START_BUTTON = KeyEvent.VK_BACK_SPACE;
        if (nativeEvent.getRawCode() == DEFAULT_START_BUTTON && Main.isLoaded && !Main.isLocked) {
            if (!Main.runner.isAlive()) {
                Main.runner = new Runner();
                Main.runner.start();
                Main.isRunning = true;
                Main.buttonPanel.checkRunStatus();
                Main.statusPanel.checkRunStatus();
            } else {
                Main.runner.interrupt();
                Main.isRunning = false;
                Main.statusPanel.checkRunStatus();
                Main.buttonPanel.checkRunStatus();
            }
        }
    }
}
