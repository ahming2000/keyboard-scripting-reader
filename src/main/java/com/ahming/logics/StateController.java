package com.ahming.logics;

import com.ahming.Main;

public class StateController {

    public static void loading() {
        Main.status.setLoaded(false);

        Main.gui.getButtonPanel().getLoadButton().setEnabled(false);
    }

    public static void load(String name) {
        Main.status.setLoaded(true);

        Main.gui.getButtonPanel().getLoadButton().setEnabled(true);
        Main.gui.getButtonPanel().getResetButton().setEnabled(true);
        Main.gui.getButtonPanel().getToggleLockButton().setEnabled(true);

        Main.gui.getStatusPanel().getTaskLabel().loadedText(name);

        if (Main.status.isEnabled()) {
            Main.gui.getStatusPanel().getHintLabel().enabledText();
        } else {
            Main.gui.getStatusPanel().getHintLabel().disabledText();
        }
    }

    public static void failLoading() {
        if (Main.queue.getScriptName().equals("")) {
            reset();
        } else {
            Main.status.setLoaded(true);
        }

        Main.gui.getButtonPanel().getLoadButton().setEnabled(true);
    }

    public static void run() {
        Main.status.setRunning(true);

        Main.gui.getButtonPanel().getLoadButton().setEnabled(false);
        Main.gui.getButtonPanel().getResetButton().setEnabled(false);
        Main.gui.getButtonPanel().getToggleLockButton().setEnabled(false);

        Main.gui.getStatusPanel().getHintLabel().runningText();
    }

    public static void stop() {
        Main.status.setRunning(false);

        Main.gui.getButtonPanel().getLoadButton().setEnabled(true);
        Main.gui.getButtonPanel().getResetButton().setEnabled(true);
        Main.gui.getButtonPanel().getToggleLockButton().setEnabled(true);

        if (Main.status.isEnabled()) {
            Main.gui.getStatusPanel().getHintLabel().enabledText();
        } else {
            Main.gui.getStatusPanel().getHintLabel().disabledText();
        }
    }

    public static void toggleLock() {
        if (Main.status.isEnabled()) {
            lock();
        } else {
            unlock();
        }
    }

    private static void lock() {
        Main.status.setEnabled(false);

        Main.gui.getButtonPanel().getToggleLockButton().disabledText();

        Main.gui.getStatusPanel().getHintLabel().disabledText();
    }

    private static void unlock() {
        Main.status.setEnabled(true);

        Main.gui.getButtonPanel().getToggleLockButton().enabledText();

        Main.gui.getStatusPanel().getHintLabel().enabledText();
    }

    public static void toggleAlwaysOnTop() {
        if (Main.gui.isAlwaysOnTop()) {
            disableAlwaysOnTop();
        } else {
            enableAlwaysOnTop();
        }
    }

    private static void enableAlwaysOnTop() {
        Main.status.setAlwaysOnTop(true);

        Main.gui.setAlwaysOnTop(true);

        Main.gui.getButtonPanel().getToggleAlwaysOnTopButton().enabledText();
    }

    private static void disableAlwaysOnTop() {
        Main.status.setAlwaysOnTop(false);

        Main.gui.setAlwaysOnTop(false);

        Main.gui.getButtonPanel().getToggleAlwaysOnTopButton().disabledText();
    }

    public static void reset() {
        Main.status.setLoaded(false);

        Main.gui.getButtonPanel().getLoadButton().setEnabled(true);
        Main.gui.getButtonPanel().getResetButton().setEnabled(false);
        Main.gui.getButtonPanel().getToggleLockButton().setEnabled(false);

        Main.gui.getStatusPanel().getHintLabel().notLoadedText();
        Main.gui.getStatusPanel().getTaskLabel().noLoadedText();
    }

    public static boolean canLoad() {
        return !Main.status.isRunning();
    }

    public static boolean canRun(int key) {
        return Main.status.isEnabled() && Main.status.isLoaded() && !Main.status.isRunning() && Main.status.getStartButton() == key;
    }

    public static boolean canStop(int key) {
        return Main.status.isRunning() && Main.status.getStopButton() == key;
    }

    public static boolean canToggleLock() {
        return Main.status.isLoaded();
    }

    public static boolean canReset() {
        return Main.status.isLoaded() && !Main.status.isRunning();
    }

}
