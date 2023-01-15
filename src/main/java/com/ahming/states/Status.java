package com.ahming.states;

import java.awt.event.KeyEvent;

public class Status {

    private int startButton = KeyEvent.VK_BACK_SPACE;
    private int stopButton = KeyEvent.VK_BACK_SPACE;
    private boolean isEnabled = true;
    private boolean isLoaded = false; // Must be false
    private boolean isRunning = false; // Must be false
    private boolean isStopping = false; // Must be false // TODO: Investigate for using this flag or not
    private boolean isAlwaysOnTop = true;

    public int getStartButton() {
        return startButton;
    }

    public void setStartButton(int startButton) {
        this.startButton = startButton;
    }

    public int getStopButton() {
        return stopButton;
    }

    public void setStopButton(int stopButton) {
        this.stopButton = stopButton;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public boolean isLoaded() {
        return isLoaded;
    }

    public void setLoaded(boolean loaded) {
        isLoaded = loaded;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    public boolean isStopping() {
        return isStopping;
    }

    public void setStopping(boolean stopping) {
        isStopping = stopping;
    }

    public boolean isAlwaysOnTop() {
        return isAlwaysOnTop;
    }

    public void setAlwaysOnTop(boolean alwaysOnTop) {
        isAlwaysOnTop = alwaysOnTop;
    }

    @Override
    public String toString() {
        return "Status{" +
                "startButton=" + startButton +
                ", stopButton=" + stopButton +
                ", isEnabled=" + isEnabled +
                ", isLoaded=" + isLoaded +
                ", isRunning=" + isRunning +
                ", isStopping=" + isStopping +
                ", isAlwaysOnTop=" + isAlwaysOnTop +
                '}';
    }
}
