package com.ahming.ui.buttons;

import com.ahming.Main;
import com.ahming.logics.StateController;

import javax.swing.*;

public class ToggleLockButton extends JButton {

    public ToggleLockButton() {
        if (Main.status.isEnabled()) {
            enabledText();
        } else {
            disabledText();
        }
        
        this.setEnabled(StateController.canToggleLock());

        this.addActionListener(e -> StateController.toggleLock());
    }

    public void enabledText() {
        this.setText("Disable Script");
    }

    public void disabledText() {
        this.setText("Enable Script");
    }

}
