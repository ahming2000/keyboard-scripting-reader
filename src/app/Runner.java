package app;

import objects.Action;
import utilities.Utility;

public class Runner extends Thread{

    @Override
    public void run() {
        System.out.println("Script runner is starting...");

        int count = 0;

        while (!Thread.currentThread().isInterrupted()){
            System.out.println("Attempt " + ++count + " ...");
            for (Action action: MainProgram.queue.getActionList()){
                action.press();
            }
            Utility.pause(MainProgram.queue.getOffset());

            if (count == MainProgram.queue.getRepeatCount()){
                MainProgram.runner.interrupt();
                MainProgram.isRunning = false;
                MainProgram.statusPanel.checkRunStatus();
                MainProgram.buttonPanel.checkRunStatus();
                break; // If not set, default = 0
            }
        }

        System.out.println("Script runner was stopped...");
    }
}
