package com.ahming.logics;

import com.ahming.Main;

import java.awt.*;

public class Runner extends Thread {

    @Override
    public void run() {
        try {
            Executor.execute(Main.runner, Main.queue);
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }

    public void wait(int milliseconds) {
        try {
            sleep(milliseconds);
        } catch (InterruptedException ie) {
            // If the task interrupted during waiting period, interrupt again
            // To make sure the task stopped completely
            System.out.println("Thread is interrupted during sleeping");
            interrupt();
            System.out.println("Thread is interrupted after sleeping thread get interrupted");
        }
    }
}
