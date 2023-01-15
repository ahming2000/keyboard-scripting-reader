package com.ahming.states;

import java.util.ArrayList;

public class Action {

    private ArrayList<Key> keys;
    private int offsetMs;
    private int repeatCount;

    public Action() {
        this.keys = new ArrayList<>();
        this.offsetMs = 100;
        this.repeatCount = 1;
    }

    public ArrayList<Key> getKeys() {
        return keys;
    }

    public void setKeys(ArrayList<Key> keys) {
        this.keys = keys;
    }

    public int getOffsetMs() {
        return offsetMs;
    }

    public void setOffsetMs(int offsetMs) {
        this.offsetMs = offsetMs;
    }

    public int getRepeatCount() {
        return repeatCount;
    }

    public void setRepeatCount(int repeatCount) {
        this.repeatCount = repeatCount;
    }

    @Override
    public String toString() {
        return "Action{" +
                "keys=" + keys +
                ", offsetMs=" + offsetMs +
                ", repeatCount=" + repeatCount +
                '}';
    }

}
