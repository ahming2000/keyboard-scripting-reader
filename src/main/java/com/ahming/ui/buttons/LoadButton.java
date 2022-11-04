package com.ahming.ui.buttons;

import com.ahming.logics.Loader;

import javax.swing.*;

public class LoadButton extends JButton {

    public LoadButton() {
        this.setText("Load Script");
        this.addActionListener(new Loader());
    }

}
