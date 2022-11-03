package com.ahming.app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Locker implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        Thread.currentThread().interrupt(); // safety
        if (!Main.runner.isAlive()) {
            Main.isLocked = !Main.isLocked;
            Main.statusPanel.checkLockStatus();
            Main.buttonPanel.checkLockStatus();
        }
    }
}
