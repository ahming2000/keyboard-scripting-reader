package com.ahming;

import com.ahming.logics.Runner;
import com.ahming.ui.MainGUI;
import com.ahming.states.Queue;
import com.ahming.states.Status;
import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;

public class Main {

    public static Status status;
    public static Queue queue;
    public static Runner runner;
    public static MainGUI gui;

    public static void main(String[] args) {
        try {
            status = new Status();
            queue = new Queue();
            runner = new Runner();
            gui = new MainGUI();

            GlobalScreen.registerNativeHook();
            GlobalScreen.addNativeKeyListener(new NativeKeyEventActor());
        } catch (NativeHookException e) {
            e.printStackTrace();
        }
    }

}