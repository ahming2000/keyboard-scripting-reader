package com.ahming.ui.labels;

import javax.swing.*;

public class TaskLabel extends JLabel {

    public TaskLabel() {
        noLoadedText();
        this.setHorizontalAlignment(JLabel.CENTER);
    }

    public void noLoadedText() {
        this.setText("No script is loaded!");
    }

    public void loadedText(String name) {
        this.setText("Loaded Script: " + name);
    }

}
