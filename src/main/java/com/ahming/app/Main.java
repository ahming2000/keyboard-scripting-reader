package com.ahming.app;

import com.ahming.ui.components.ButtonPanel;
import com.ahming.ui.DefaultFrame;
import com.ahming.ui.components.StatusPanel;
import com.ahming.objects.Queue;
import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;

public class Main {
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

    public Main() {

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
            new Main();
            GlobalScreen.registerNativeHook();
            GlobalScreen.addNativeKeyListener(new NativeKeyEventActor());
        } catch (NativeHookException e) {
            e.printStackTrace();
        }
    }
}