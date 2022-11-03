package com.ahming.app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reset implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        Thread.currentThread().interrupt(); // safety
        if (!Main.runner.isAlive()) {
            Main.isLoaded = false;
            Main.queue.getActionList().clear();
            Main.queue.setRepeatCount(0);
            Main.statusPanel.reset();
            Main.buttonPanel.reset();
        }
    }
}
