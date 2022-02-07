package components;

import app.MainProgram;

import javax.swing.*;
import java.awt.*;

public class StatusPanel extends JPanel {

    private final JLabel scriptNameLabel;
    private final JLabel hintLabel;

    public StatusPanel(){
        this.setLayout(new GridLayout(3, 1));
        this.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        JLabel versionLabel = new JLabel("v1.1.0");
        versionLabel.setHorizontalAlignment(JLabel.CENTER);
        scriptNameLabel = new JLabel("No script is loaded!");
        scriptNameLabel.setHorizontalAlignment(JLabel.CENTER);
        hintLabel = new JLabel("Load script to start!");
        hintLabel.setHorizontalAlignment(JLabel.CENTER);

        this.add(versionLabel);
        this.add(scriptNameLabel);
        this.add(hintLabel);
    }

    public void checkLoadStatus(String fileName){
        if (MainProgram.isLoaded){
            scriptNameLabel.setText("Loaded Script: " + fileName);
            checkLockStatus();
        }
    }

    public void checkRunStatus(){
        if (MainProgram.isRunning) {
            hintLabel.setText("YOUR SCRIPT IS CURRENTLY RUNNING!");
        } else {
            checkLockStatus();
        }
    }

    public void checkLockStatus(){
        if (MainProgram.isLocked){
            hintLabel.setText("Script is disabled!");
        } else {
            hintLabel.setText("Press BACKSPACE to start the script!");
        }
    }

    public void reset(){
        hintLabel.setText("Load script to start!");
        scriptNameLabel.setText("No script is loaded!");
    }

}
