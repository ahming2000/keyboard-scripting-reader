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
        }

        System.out.println("Script runner was stopped...");
    }
}
