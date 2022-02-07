package app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Locker implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        Thread.currentThread().interrupt(); // safety
        if (!MainProgram.runner.isAlive()) {
            MainProgram.isLocked = !MainProgram.isLocked;
            MainProgram.statusPanel.checkLockStatus();
            MainProgram.buttonPanel.checkLockStatus();
        }
    }
}
