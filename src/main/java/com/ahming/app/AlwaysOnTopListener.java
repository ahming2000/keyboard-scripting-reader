package com.ahming.app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlwaysOnTopListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        Main.frame.setAlwaysOnTop(!Main.frame.isAlwaysOnTop());
        Main.buttonPanel.checkAlwaysOnTopStatus();
    }
}
