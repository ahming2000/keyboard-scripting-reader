package app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;
import components.ButtonPanel;
import components.DefaultFrame;
import components.StatusPanel;
import objects.Queue;

public class MainProgram {

    // Core Variable
    public static Runner runner;
    public static Queue queue;

    // Core Boolean
    public static boolean isRunning = false; // This flag is only for display (Do not decide Thread behaviour)
    public static boolean isLoaded = false;
    public static boolean isLocked = false;

    // Interface Variable
    public static DefaultFrame frame;
    public static StatusPanel statusPanel;
    public static ButtonPanel buttonPanel;

    public MainProgram() {

        queue = new Queue();
        runner = new Runner();
        frame = new DefaultFrame();
        statusPanel = new StatusPanel();
        buttonPanel = new ButtonPanel();

        frame.add(statusPanel, "North");
        frame.add(buttonPanel, "South");
    }

    public static void main(String[] args) {
        try {
            new MainProgram();
            GlobalScreen.registerNativeHook();
            GlobalScreen.addNativeKeyListener(new NativeKeyEventActor());
        } catch (NativeHookException e) {
            e.printStackTrace();
        }
    }

}
