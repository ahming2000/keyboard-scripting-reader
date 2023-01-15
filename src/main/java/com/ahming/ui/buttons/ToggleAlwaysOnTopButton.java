package com.ahming.ui.buttons;

import com.ahming.logics.StateController;

import javax.swing.*;

public class ToggleAlwaysOnTopButton extends JButton {

    public ToggleAlwaysOnTopButton() {
        enabledText();

        this.addActionListener(e -> StateController.toggleAlwaysOnTop());
    }

    public void enabledText() {
        this.setText("Disable Always On Top");
    }

    public void disabledText() {
        this.setText("Enable Always On Top");
    }

}
