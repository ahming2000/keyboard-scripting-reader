package com.ahming.ui.panels;

import com.ahming.ui.buttons.LoadButton;
import com.ahming.ui.buttons.ToggleLockButton;
import com.ahming.ui.buttons.ResetButton;
import com.ahming.ui.buttons.ToggleAlwaysOnTopButton;

import javax.swing.*;
import java.awt.*;

public class ButtonPanel extends JPanel {

    private final LoadButton loadButton;
    private final ResetButton resetButton;
    private final ToggleLockButton toggleLockButton;
    private final ToggleAlwaysOnTopButton toggleAlwaysOnTopButton;

    public ButtonPanel() {
        this.setLayout(new GridLayout(2, 1));
        this.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

        JPanel top = new JPanel();
        top.setLayout(new FlowLayout());
        loadButton = new LoadButton();
        resetButton = new ResetButton();
        top.add(loadButton);
        top.add(resetButton);

        JPanel bottom = new JPanel();
        bottom.setLayout(new FlowLayout());
        toggleLockButton = new ToggleLockButton();
        toggleAlwaysOnTopButton = new ToggleAlwaysOnTopButton();
        bottom.add(toggleLockButton);
        bottom.add(toggleAlwaysOnTopButton);

        this.add(top);
        this.add(bottom);
    }

    public LoadButton getLoadButton() {
        return loadButton;
    }

    public ResetButton getResetButton() {
        return resetButton;
    }

    public ToggleLockButton getToggleLockButton() {
        return toggleLockButton;
    }

    public ToggleAlwaysOnTopButton getToggleAlwaysOnTopButton() {
        return toggleAlwaysOnTopButton;
    }

}
