package com.ahming.app;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Loader implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {

        String fileName;
        String folderPath;
        String fullPath;

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("."));
        fileChooser.setDialogTitle("Choose your script");
        fileChooser.setFileFilter(new FileNameExtensionFilter("Script", "txt"));
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        // Lock the script
        boolean orgIsLocked = Main.isLocked;
        Main.isLocked = true;

        if (fileChooser.showOpenDialog(Main.buttonPanel) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();

            fileName = file.getName();
            folderPath = "" + fileChooser.getCurrentDirectory();

            if (folderPath.charAt(folderPath.length() - 1) == '.') {
                folderPath = folderPath.substring(0, folderPath.length() - 1);
                fullPath = "" + folderPath + "" + file.getName();
            } else {
                fullPath = "" + folderPath + "/" + file.getName();
            }

            try {
                Main.queue.getActionList().clear();
                Main.queue.setRepeatCount(0);

                Scanner scanner = new Scanner(file);

                while (scanner.hasNextLine()) {
                    String command = scanner.nextLine();
                    Main.queue.generate(command);
                }

                Main.isLoaded = true;
                Main.statusPanel.checkLoadStatus(fileName);
                Main.buttonPanel.checkLoadStatus();

                System.out.println("Action load successfully!");
                System.out.println(Main.queue.getActionList());

            } catch (FileNotFoundException ex) {
                fileName = "File reading error";
                System.out.println(fileName);
            }
        }

        // Restore original isLocked status
        Main.isLocked = orgIsLocked;

    }
}
