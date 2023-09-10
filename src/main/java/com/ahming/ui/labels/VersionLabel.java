package com.ahming.ui.labels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;

public class VersionLabel extends JLabel {

    public VersionLabel() {
        String version = "v2.1.1";
        this.setText("<html><u>" + version + "</u></html>");
        this.setHorizontalAlignment(JLabel.CENTER);

        this.setForeground(Color.BLUE);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        this.setToolTipText("Click to view changing log.");

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent event) {
                try {
                    Desktop.getDesktop().browse(new URI("https://github.com/ahming2000/keyboard-scripting-reader/releases"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
