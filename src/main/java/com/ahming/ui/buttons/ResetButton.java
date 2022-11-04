package com.ahming.ui.buttons;

import com.ahming.logics.StateController;

import javax.swing.*;

public class ResetButton extends JButton {

    public ResetButton() {
        this.setText("Reset");
        this.setEnabled(StateController.canReset());

        this.addActionListener(e -> {
            StateController.reset();
        });
    }

}
