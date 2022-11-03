package com.ahming.objects;

import com.ahming.utils.Utility;

import java.awt.*;

public class Action {

    private Key key;

    private int holdDuration = 0;
    private int offset = 100;

    public Action(Key key, int holdDuration, int offset) {
        this.key = key;
        this.holdDuration = holdDuration;
        this.offset = offset;
    }

    public Action(String keyName, int holdDuration, int offset) {
        this.key = new Key(keyName);
        this.holdDuration = holdDuration;
        this.offset = offset;
    }

    public Action(int keyCode) {
        this.key = new Key(keyCode);
    }

    public Action(String keyName){
        this.key = new Key(keyName);
    }

    public void press() {
        if (Thread.currentThread().isInterrupted()) return;

        try {
            Robot robot = new Robot();

            if (key.hasHoldingKey()){
                robot.keyPress(key.getKeyCodeHold());
                robot.keyPress(key.getKeyCode());
                Utility.pause(holdDuration);
                robot.keyRelease(key.getKeyCode());
                robot.keyRelease(key.getKeyCodeHold());
                Utility.pause(offset);
            } else {
                if (key.hasInvalidKey()) {
                    Utility.pause(holdDuration);
                } else {
                    robot.keyPress(key.getKeyCode());
                    Utility.pause(holdDuration);
                    robot.keyRelease(key.getKeyCode());
                    Utility.pause(offset);
                }
            }

        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public int getHoldDuration() {
        return holdDuration;
    }

    public void setHoldDuration(int holdDuration) {
        this.holdDuration = holdDuration;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    @Override
    public String toString() {
        return "Action{" +
                "key=" + key +
                ", holdDuration=" + holdDuration +
                ", offset=" + offset +
                '}';
    }
}
