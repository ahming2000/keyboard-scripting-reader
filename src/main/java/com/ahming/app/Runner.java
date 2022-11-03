package com.ahming.app;

import com.ahming.objects.Action;
import com.ahming.utils.Utility;

public class Runner extends Thread{

    @Override
    public void run() {
        System.out.println("Script runner is starting...");

        int count = 0;

        while (!Thread.currentThread().isInterrupted()){
            System.out.println("Attempt " + ++count + " ...");
            for (Action action: Main.queue.getActionList()){
                action.press();
            }
            Utility.pause(Main.queue.getOffset());

            if (count == Main.queue.getRepeatCount()){
                Main.runner.interrupt();
                Main.isRunning = false;
                Main.statusPanel.checkRunStatus();
                Main.buttonPanel.checkRunStatus();
                break; // If not set, default = 0
            }
        }

        System.out.println("Script runner was stopped...");
    }
}
