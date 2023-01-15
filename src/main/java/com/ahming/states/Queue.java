package com.ahming.states;

import java.util.ArrayList;

public class Queue {

    private ArrayList<Action> actions;
    private String scriptName;
    private int offsetMs;
    private int repeatCount;

    public Queue() {
        this.actions = new ArrayList<>();
        this.scriptName = "";
        this.offsetMs = 100;
        this.repeatCount = 0; // 0 for infinite loop
    }

    public ArrayList<Action> getActions() {
        return actions;
    }

    public void setActions(ArrayList<Action> actions) {
        this.actions = actions;
    }

    public String getScriptName() {
        return scriptName;
    }

    public void setScriptName(String scriptName) {
        this.scriptName = scriptName;
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
        return "Queue{" +
                "actions=" + actions +
                ", scriptName='" + scriptName + '\'' +
                ", offsetMs=" + offsetMs +
                ", repeatCount=" + repeatCount +
                '}';
    }

}
