package app;

import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

import java.awt.event.KeyEvent;

public class NativeKeyEventActor implements NativeKeyListener {
    @Override
    public void nativeKeyPressed(NativeKeyEvent nativeEvent) {
        // Toggle start and stop running the script
        int DEFAULT_START_BUTTON = KeyEvent.VK_BACK_SPACE;
        if (nativeEvent.getRawCode() == DEFAULT_START_BUTTON && MainProgram.isLoaded) {
            if (!MainProgram.runner.isAlive()) {
                MainProgram.buttonPanel.setLoadButtonEnabled(false);
                MainProgram.buttonPanel.setResetButtonEnabled(false);
                MainProgram.runner = new Runner();
                MainProgram.runner.start();
                MainProgram.statusPanel.toggleRunningHint();
            } else {
                MainProgram.runner.interrupt();
                MainProgram.buttonPanel.setResetButtonEnabled(true);
                MainProgram.buttonPanel.setLoadButtonEnabled(true);
                MainProgram.statusPanel.toggleRunningHint();
            }
        }
    }
}
