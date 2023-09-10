package com.ahming.ui;

import com.ahming.Main;
import com.ahming.ui.panels.ButtonPanel;
import com.ahming.ui.panels.StatusPanel;

import javax.swing.*;

public class MainGUI extends JFrame {

    private final StatusPanel statusPanel;
    private final ButtonPanel buttonPanel;

    public MainGUI() {
        this.setTitle("Keyboard Script Reader (Author: AhMing)");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setAlwaysOnTop(Main.status.isAlwaysOnTop());
        this.setResizable(false);
        this.setVisible(true);

        statusPanel = new StatusPanel();
        buttonPanel = new ButtonPanel();
        this.add(statusPanel, "North");
        this.add(buttonPanel, "South");

        this.pack();
        this.setSize(530, 340);
    }

    public StatusPanel getStatusPanel() {
        return statusPanel;
    }

    public ButtonPanel getButtonPanel() {
        return buttonPanel;
    }
}
