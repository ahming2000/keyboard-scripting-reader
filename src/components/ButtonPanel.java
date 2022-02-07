package components;

import app.Loader;
import app.Locker;
import app.MainProgram;
import app.Reset;

import javax.swing.*;
import java.awt.*;

public class ButtonPanel extends JPanel {

    private final JButton loadButton;
    private final JButton resetButton;
    private final JButton toggleLockButton;

    public ButtonPanel() {
        this.setLayout(new FlowLayout());
        this.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

        loadButton = new JButton("Load Script");
        loadButton.addActionListener(new Loader());
        resetButton = new JButton("Reset");
        resetButton.addActionListener(new Reset());
        resetButton.setEnabled(false);
        toggleLockButton = new JButton("Disable Script");
        toggleLockButton.addActionListener(new Locker());
        toggleLockButton.setEnabled(false);

        this.add(loadButton);
        this.add(resetButton);
        this.add(toggleLockButton);
    }

    public void load(){
        if (MainProgram.isLoaded) {
            resetButton.setEnabled(true);
            toggleLockButton.setEnabled(true);
        } else {
            resetButton.setEnabled(false);
            toggleLockButton.setEnabled(false);
        }
    }

    public void run(){
        if (MainProgram.isRunning) {
            loadButton.setEnabled(false);
            resetButton.setEnabled(false);
            toggleLockButton.setEnabled(false);
        } else {
            loadButton.setEnabled(true);
            resetButton.setEnabled(true);
            toggleLockButton.setEnabled(true);
        }
    }

    public void lock(){
        if (MainProgram.isLocked) {
            toggleLockButton.setText("Enable Script");
        } else {
            toggleLockButton.setText("Disable Script");
        }
    }

    public void reset(){
        loadButton.setEnabled(true);
        resetButton.setEnabled(false);
        toggleLockButton.setEnabled(false);
    }

}
