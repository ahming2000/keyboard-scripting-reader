package com.ahming.objects;

import java.util.ArrayList;

public class Queue {

    private ArrayList<Action> actionList = new ArrayList<>();
    private int offset;
    private int repeatCount = 0;

    public void generate(String command){
        if (command.startsWith("type")){
            String text = command.substring("type ".length());
            for (char c: text.toCharArray()){
                actionList.add(new Action(String.valueOf(c)));
            }
        }
        else if (command.startsWith("press")) {
            String text = command.substring("press ".length());
            actionList.add(new Action(text));
        }
        else if (command.startsWith("hold")) {
            try {
                int duration = Integer.parseInt(command.substring("hold ".length()));
                actionList.add(new Action("hold", duration, 0));
            } catch (NumberFormatException e) {
                System.out.println(command + " is an invalid duration for hold! (Not integer)");
            }
        } else if (command.startsWith("repeat")) {
            try {
                this.repeatCount = Integer.parseInt(command.substring("repeat ".length()));
            } catch (NumberFormatException e) {
                System.out.println(command + " is an invalid number for repeating count! (Not integer)");
            }
        }
        else {
            System.out.println("\"" + command + "\" is not a correct command!");
        }
    }

    public ArrayList<Action> getActionList() {
        return actionList;
    }

    public void setActionList(ArrayList<Action> actionList) {
        this.actionList = actionList;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getRepeatCount() {
        return repeatCount;
    }

    public void setRepeatCount(int repeatCount) {
        this.repeatCount = repeatCount;
    }
}
