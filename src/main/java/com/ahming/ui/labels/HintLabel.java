package com.ahming.ui.labels;

import javax.swing.*;

public class HintLabel extends JLabel {

    public HintLabel() {
        notLoadedText();
        this.setHorizontalAlignment(JLabel.CENTER);
    }

    public void notLoadedText() {
        this.setText("Load script to start!");
    }

    public void enabledText() {
        this.setText("Press BACKSPACE to start.");
    }

    public void disabledText() {
        this.setText("Script is disabled.");
    }

    public void runningText() {
        this.setText("<html><div align='center'>" +
                "<font color='red'>YOUR TASK IS CURRENTLY RUNNING!</font>" +
                "</div></html>");
    }

    public void runningText(String currentLine) {
        this.setText("<html><div align='center'>" +
                "<font color='red'>YOUR TASK IS CURRENTLY RUNNING!</font>" +
                "<br>Current command: " +
                (currentLine == null ? "<font color='gray'>Pausing...</font>" : currentLine) +
                "</div></html>");
    }

}
