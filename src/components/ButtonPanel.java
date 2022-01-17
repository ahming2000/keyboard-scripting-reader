package components;

import app.Loader;
import app.Reset;

import javax.swing.*;
import java.awt.*;

public class ButtonPanel extends JPanel {

    private final JButton loadScriptButton;
    private final JButton resetScriptButton;

    public ButtonPanel() {
        this.setLayout(new FlowLayout());
        this.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

        loadScriptButton = new JButton("Load Script");
        loadScriptButton.addActionListener(new Loader());
        resetScriptButton = new JButton("Reset");
        resetScriptButton.setEnabled(false);
        resetScriptButton.addActionListener(new Reset());

        this.add(loadScriptButton);
        this.add(resetScriptButton);
    }

    public void setLoadButtonEnabled(boolean status) {
        loadScriptButton.setEnabled(status);
    }

    public void setResetButtonEnabled(boolean status) {
        resetScriptButton.setEnabled(status);
    }

}
