package com.ahming.logics;

import com.ahming.Main;
import com.ahming.states.Action;
import com.ahming.states.Key;
import com.ahming.states.Queue;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Loader implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        if (StateController.canLoad()) {
            StateController.loading();

            File file = chooseFile(e);

            if (file == null) {
                System.out.println("File not chosen or invalid.");
                StateController.failLoading();
            } else {
                String fileName = file.getName();

                try {
                    Main.queue = load(file);

                    StateController.load(fileName);
                    System.out.println("Script Name: " + Main.queue.getScriptName());

                    if (Main.queue.getScriptName().isEmpty()) {
                        StateController.load(fileName);
                    } else {
                        StateController.load(Main.queue.getScriptName());
                    }

                    System.out.println("Action(s) loaded successfully!");
                } catch (FileNotFoundException exception) {
                    StateController.failLoading();
                    System.out.println("File not found.");
                }
            }
        }
    }

    private File chooseFile(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("."));
        fileChooser.setDialogTitle("Load Script");

        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.setFileFilter(new FileNameExtensionFilter("Text Document (*.txt)", "txt"));

        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        if (fileChooser.showOpenDialog((Component) e.getSource()) == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile();
        } else {
            return null;
        }
    }

    private Queue load(File file) throws FileNotFoundException {
        Queue queue = new Queue();
        ArrayList<Action> actions = new ArrayList<>();
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String command = fineTuningCommand(scanner.nextLine());

            if (command.contains("main:")) {
                loadHeader(queue, command);
            } else if (command.contains("loop_start:")) {
                generateLoopedActions(scanner, actions, command);
            } else {
                Action action = generateAction(command);
                if (action != null) actions.add(action);
            }
        }

        scanner.close();
        queue.setActions(actions);

        return queue;
    }

    private void loadHeader(Queue queue, String header) {
        String[] params = header.split(" ");

        for (int i = 0; i < params.length; i++) {
            if (params[i].startsWith("main:")) {
                queue.setScriptName(getSentence(params, i, "main:"));
            }

            if (params[i].startsWith("offset:")) {
                queue.setOffsetMs(getInteger(params[i], "offset:"));
            }

            if (params[i].startsWith("repeat:")) {
                queue.setRepeatCount(getInteger(params[i], "repeat:"));
            }
        }
    }

    private void generateLoopedActions(Scanner scanner, ArrayList<Action> actions, String loopHeader) {
        int loopCount = getInteger(loopHeader.replaceAll("[\t ]", ""), "loop_start:");
        ArrayList<Action> actionsInBlock = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String command = fineTuningCommand(scanner.nextLine());

            if (command.contains("loop_start:")) {
                generateLoopedActions(scanner, actionsInBlock, command);
            }

            Action action = generateAction(command);
            if (action != null) actionsInBlock.add(action);

            if (command.contains("loop_end")) {
                if (loopCount <= 0) {
                    return;
                } else {
                    for (int i = 0; i < loopCount; i++) {
                        actions.addAll(actionsInBlock);
                    }
                }

                break;
            }
        }
    }

    private Action generateAction(String command) {
        Action action = new Action();
        command = command.toLowerCase();

        String[] params = command.split(" ");

        for (int i = 0; i < params.length; i++) {
            if (params[i].startsWith("offset:")) {
                action.setOffsetMs(getInteger(params[i], "offset:"));
            }

            if (params[i].startsWith("repeat:")) {
                action.setRepeatCount(getInteger(params[i], "repeat:"));
            }

            if (params[i].startsWith("type:")) {
                String sentence = getSentence(params, i, "type:");
                action.setName(sentence);
                ArrayList<Key> keys = new ArrayList<>();

                for (char c : sentence.toCharArray()) {
                    keys.add(new Key(c));
                }

                action.setKeys(keys);
            }

            if (params[i].startsWith("press:")) {
                ArrayList<Key> keys = new ArrayList<>();
                String word = getWord(params[i], "press:");
                action.setName(word);
                keys.add(new Key(word));
                action.setKeys(keys); // If type and press present in the same line, only the latest type or press will be the recorded
            }
        }

        return action.getKeys() == null || action.getKeys().isEmpty() ? null : action;
    }

    private int getInteger(String string, String prefix) {
        return Integer.parseInt(string.substring(prefix.length()));
    }

    private String getWord(String string, String prefix) {
        return string.substring(prefix.length());
    }

    private String getSentence(String[] strings, int startIndex, String prefix) {
        String sentence = "";

        for (int i = startIndex; i < strings.length; i++) {
            // Required to add more if more prefix added
            if (strings[i].startsWith("offset:") || strings[i].startsWith("repeat:")) {
                break;
            }

            if (strings[i].startsWith(prefix)) {
                sentence = ""; // Purposely replace whole text with empty string
                sentence = sentence.concat(strings[i].substring(prefix.length()));
            } else {
                sentence = sentence.concat(" " + strings[i]);
            }
        }

        return sentence;
    }

    private String fineTuningCommand(String command) {
        if (command.contains("#")) {
            // Skip comment that inline within the script line
            command = command.substring(0, command.indexOf("#"));
        }

        // Skip the space or tab front and back
        return command.trim();
    }
}
