package app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reset implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        Thread.currentThread().interrupt(); // safety
        if (!MainProgram.runner.isAlive()) {
            MainProgram.isLoaded = false;
            MainProgram.queue.getActionList().clear();
            MainProgram.queue.setRepeatCount(0);
            MainProgram.statusPanel.reset();
            MainProgram.buttonPanel.reset();
        }
    }
}
