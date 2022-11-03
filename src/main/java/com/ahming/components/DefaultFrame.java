package com.ahming.components;

import javax.swing.*;

public class DefaultFrame extends JFrame {

    public DefaultFrame() {
        this.setTitle("AhMing's Keyboard Script Reader");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setAlwaysOnTop(true);
        this.setResizable(true);
        this.setVisible(true);

        this.setSize(530, 300);
    }
}
