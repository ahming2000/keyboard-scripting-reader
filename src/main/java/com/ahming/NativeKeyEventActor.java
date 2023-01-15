package com.ahming;

import com.ahming.logics.Runner;
import com.ahming.logics.StateController;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

public class NativeKeyEventActor implements NativeKeyListener {

    @Override
    public void nativeKeyPressed(NativeKeyEvent nativeEvent) {
        if (StateController.canRun(nativeEvent.getRawCode()) && !Main.runner.isAlive()) {
            Main.runner = new Runner();
            Main.runner.start();
        }

        if (StateController.canStop(nativeEvent.getRawCode())) {
            System.out.println("Thread is interrupted after clicking stop key");
            for (int i = 1; Main.runner.isAlive(); i++) {
                Main.runner.interrupt();
                System.out.println("Attempt " + i + ": Stopping the thread...");
            }
        }
    }

}
