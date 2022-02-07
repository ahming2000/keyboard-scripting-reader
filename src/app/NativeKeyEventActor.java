package app;

import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

import java.awt.event.KeyEvent;

public class NativeKeyEventActor implements NativeKeyListener {
    @Override
    public void nativeKeyPressed(NativeKeyEvent nativeEvent) {
        // Toggle start and stop running the script
        int DEFAULT_START_BUTTON = KeyEvent.VK_BACK_SPACE;
        if (nativeEvent.getRawCode() == DEFAULT_START_BUTTON && MainProgram.isLoaded && !MainProgram.isLocked) {
            if (!MainProgram.runner.isAlive()) {
                MainProgram.runner = new Runner();
                MainProgram.runner.start();
                MainProgram.isRunning = true;
                MainProgram.buttonPanel.run();
                MainProgram.statusPanel.run();
            } else {
                MainProgram.runner.interrupt();
                MainProgram.isRunning = false;
                MainProgram.statusPanel.run();
                MainProgram.buttonPanel.run();
            }
        }
    }
}
