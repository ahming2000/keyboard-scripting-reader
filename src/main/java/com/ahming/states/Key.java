package com.ahming.states;

import java.awt.event.KeyEvent;

public class Key {

    private final int key;
    private boolean holdShift = false;
    private boolean holdCtrl = false;

    public Key(char key) {
        // Set to character space for invalid key
        if (key < 32 || key > 126) key = KeyEvent.VK_SPACE;

        // Convert to upper case
        if (key >= 97 && key <= 122) key = String.valueOf(key).toUpperCase().charAt(0);

        this.key = convertKeyRequireShift(key);

        // Make sure key that requiring holding shift can work
        if (key >= 33 && key <= 38 || key >= 40 && key <= 43 || key == 58 || key == 60 || key >= 62 && key <= 64 || key >= 94 && key <= 95 || key >= 123) {
            this.holdShift = true;
        }
    }

    public Key(String key) {
        // Convert to upper case
        key = key.toUpperCase();

        this.key = convertKeyRequireCtrl(key);
    }
    private int convertKeyRequireShift(char keyRequireShift) {
        switch (keyRequireShift) {
            case '~': return KeyEvent.VK_BACK_QUOTE;
            case '!': return KeyEvent.VK_1;
            case '@': return KeyEvent.VK_2;
            case '#': return KeyEvent.VK_3;
            case '$': return KeyEvent.VK_4;
            case '%': return KeyEvent.VK_5;
            case '^': return KeyEvent.VK_6;
            case '&': return KeyEvent.VK_7;
            case '*': return KeyEvent.VK_8;
            case '(': return KeyEvent.VK_9;
            case ')': return KeyEvent.VK_0;
            case '_': return KeyEvent.VK_MINUS;
            case '+': return KeyEvent.VK_EQUALS;
            case '{': return KeyEvent.VK_OPEN_BRACKET;
            case '}': return KeyEvent.VK_CLOSE_BRACKET;
            case '|': return KeyEvent.VK_BACK_SLASH;
            case ':': return KeyEvent.VK_SEMICOLON;
            case '\"': return KeyEvent.VK_QUOTE;
            case '<': return KeyEvent.VK_COMMA;
            case '>': return KeyEvent.VK_PERIOD;
            case '?': return KeyEvent.VK_SLASH;
            default: return keyRequireShift;
        }
    }

    private int convertKeyRequireCtrl(String keyRequireCtrl) {
        switch (keyRequireCtrl) {
            case "ESC": return KeyEvent.VK_ESCAPE;
            case "ENTER": case "RETURN": case "\n": return KeyEvent.VK_ENTER;
            case "SPACE": case " ": return KeyEvent.VK_SPACE;
            case "CTRL": return KeyEvent.VK_CONTROL;
            case "SHIFT": return KeyEvent.VK_SHIFT;
            case "ALT": return KeyEvent.VK_ALT;
            case "TAB": return KeyEvent.VK_TAB;
            case "CONTEXT_MENU": return KeyEvent.VK_CONTEXT_MENU;
            case "NUM": case "NUMLK": case "NUM_LOCK": return KeyEvent.VK_NUM_LOCK;
            case "CAPS": case "CAPSLK": case "CAPS_LOCK": return KeyEvent.VK_CAPS_LOCK;
            case "SCR": case "SCRLK": case "SCROLL_LOCK": return KeyEvent.VK_SCROLL_LOCK;
            case "COPY": case "CTRL+C":
                this.holdCtrl = true;
                return KeyEvent.VK_C;
            case "CUT": case "CTRL+X":
                this.holdCtrl = true;
                return KeyEvent.VK_X;
            case "PASTE": case "CTRL+V":
                this.holdCtrl = true;
                return KeyEvent.VK_V;
            case "START": case "WINDOWS_KEY": case "WINDOW": case "WINDOWS": return KeyEvent.VK_WINDOWS;
            case "LEFT": return KeyEvent.VK_LEFT;
            case "RIGHT": return KeyEvent.VK_RIGHT;
            case "UP": case "TOP": return KeyEvent.VK_UP;
            case "DOWN": case "BOTTOM": return KeyEvent.VK_DOWN;
            case "F1": return KeyEvent.VK_F1;
            case "F2": return KeyEvent.VK_F2;
            case "F3": return KeyEvent.VK_F3;
            case "F4": return KeyEvent.VK_F4;
            case "F5": return KeyEvent.VK_F5;
            case "F6": return KeyEvent.VK_F6;
            case "F7": return KeyEvent.VK_F7;
            case "F8": return KeyEvent.VK_F8;
            case "F9": return KeyEvent.VK_F9;
            case "F10": return KeyEvent.VK_F10;
            case "F11": return KeyEvent.VK_F11;
            case "F12": return KeyEvent.VK_F12;
            default: return KeyEvent.VK_SPACE;
        }
    }

    public int getKey() {
        return key;
    }

    public boolean isHoldShift() {
        return holdShift;
    }

    public boolean isHoldCtrl() {
        return holdCtrl;
    }

    @Override
    public String toString() {
        return "Key{" +
                "key=" + key +
                ", holdShift=" + holdShift +
                ", holdCtrl=" + holdCtrl +
                '}';
    }

}
