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
    private final JButton toggleAlwaysOnTop;

    public ButtonPanel() {

        this.setLayout(new GridLayout(2, 1));
        this.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

        JPanel top = new JPanel();
        top.setLayout(new FlowLayout());
        loadButton = new JButton("Load Script");
        loadButton.addActionListener(new Loader());
        resetButton = new JButton("Reset");
        resetButton.addActionListener(new Reset());
        resetButton.setEnabled(false);
        top.add(loadButton);
        top.add(resetButton);

        JPanel bottom = new JPanel();
        bottom.setLayout(new FlowLayout());
        toggleLockButton = new JButton("Disable Script");
        toggleLockButton.addActionListener(new Locker());
        toggleLockButton.setEnabled(false);
        toggleAlwaysOnTop = new JButton("Disable Always On Top");
        toggleAlwaysOnTop.addActionListener(e -> {
            MainProgram.frame.setAlwaysOnTop(!MainProgram.frame.isAlwaysOnTop());
            if (MainProgram.frame.isAlwaysOnTop()) {
                toggleAlwaysOnTop.setText("Disable Always On Top");
            } else {
                toggleAlwaysOnTop.setText("Enable Always On Top");
            }
        });
        bottom.add(toggleLockButton);
        bottom.add(toggleAlwaysOnTop);

        this.add(top);
        this.add(bottom);
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
