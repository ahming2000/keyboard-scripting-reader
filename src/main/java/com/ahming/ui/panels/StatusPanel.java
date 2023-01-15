package com.ahming.ui.panels;

import com.ahming.ui.labels.HintLabel;
import com.ahming.ui.labels.TaskLabel;
import com.ahming.ui.labels.VersionLabel;

import javax.swing.*;
import java.awt.*;

public class StatusPanel extends JPanel {

    private final TaskLabel taskLabel;
    private final HintLabel hintLabel;

    public StatusPanel(){
        this.setLayout(new GridLayout(3, 1));
        this.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        JLabel versionLabel = new VersionLabel();
        taskLabel = new TaskLabel();
        hintLabel = new HintLabel();

        this.add(versionLabel);
        this.add(taskLabel);
        this.add(hintLabel);
    }

    public TaskLabel getTaskLabel() {
        return taskLabel;
    }

    public HintLabel getHintLabel() {
        return hintLabel;
    }

}
