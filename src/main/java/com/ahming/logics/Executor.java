package com.ahming.logics;

import com.ahming.Main;
import com.ahming.states.Action;
import com.ahming.states.Key;
import com.ahming.states.Queue;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Executor {
    private static Robot robot;

    public static void execute(Runner runner, Queue queue) throws AWTException {
        robot = new Robot();

        System.out.println("Script runner is starting...");
        StateController.run();

        run(runner, queue, queue.getRepeatCount() == 0);

        System.out.println("Script runner is stopping...");
        StateController.stop();
    }

    private static void run(Runner runner, Queue queue, boolean isInfiniteLoop) {
        for (int i = 1; (i <= queue.getRepeatCount() || isInfiniteLoop); i++) {
            if (runner.isInterrupted()) {
                return;
            }

            System.out.println("Attempt " + i + "...");

            for (Action action : queue.getActions()) {
                if (runner.isInterrupted()) {
                    return;
                }

                type(runner, action);
            }

            if (i == queue.getRepeatCount()) {
                runner.interrupt();
                System.out.println("Thread is interrupted for end of the script");
            } else {
                runner.wait(queue.getOffsetMs());
            }
        }
    }

    private static void type(Runner runner, Action action) {
        for (int i = 1; i <= action.getRepeatCount(); i++) {
            if (runner.isInterrupted()) {
                return;
            }

            Main.gui.getStatusPanel().getHintLabel().runningText(action.getName());

            for (Key key : action.getKeys()) {
                click(runner, key);

                if (runner.isInterrupted()) {
                    return;
                }
            }

            if (i == action.getRepeatCount()) {
                runner.wait(action.getOffsetMs());
            }
        }
    }

    private static void click(Runner runner, Key key) {
        if (key.isHoldShift()) robot.keyPress(KeyEvent.VK_SHIFT);
        if (key.isHoldCtrl()) robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(key.getKey());
        runner.wait(100); // Standard Offset
        robot.keyRelease(key.getKey());
        if (key.isHoldCtrl()) robot.keyRelease(KeyEvent.VK_CONTROL);
        if (key.isHoldShift()) robot.keyRelease(KeyEvent.VK_SHIFT);
    }
}
