package com.ahming.objects;

import java.awt.event.KeyEvent;

public class Key {

    private String name;
    private int keyCode;
    private int keyCodeHold;

    public Key(int keyCode, int keyCodeHold) {
        this.keyCode = keyCode;
        this.keyCodeHold = keyCodeHold;
    }

    public Key(int keyCode) {
        this.keyCode = keyCode;
    }

    public Key(String name){
        this.name = name;
        initKeyCode();
    }

    public boolean hasInvalidKey(){
        return keyCode == 0;
    }

    public boolean hasHoldingKey(){
        return keyCodeHold != 0;
    }

    private void initKeyCode(){

        String n = this.name.toUpperCase();

        switch (n) {
            case "A": keyCode = KeyEvent.VK_A; break;
            case "B": keyCode = KeyEvent.VK_B; break;
            case "C": keyCode = KeyEvent.VK_C; break;
            case "D": keyCode = KeyEvent.VK_D; break;
            case "E": keyCode = KeyEvent.VK_E; break;
            case "F": keyCode = KeyEvent.VK_F; break;
            case "G": keyCode = KeyEvent.VK_G; break;
            case "H": keyCode = KeyEvent.VK_H; break;
            case "I": keyCode = KeyEvent.VK_I; break;
            case "J": keyCode = KeyEvent.VK_J; break;
            case "K": keyCode = KeyEvent.VK_K; break;
            case "L": keyCode = KeyEvent.VK_L; break;
            case "M": keyCode = KeyEvent.VK_M; break;
            case "N": keyCode = KeyEvent.VK_N; break;
            case "O": keyCode = KeyEvent.VK_O; break;
            case "P": keyCode = KeyEvent.VK_P; break;
            case "Q": keyCode = KeyEvent.VK_Q; break;
            case "R": keyCode = KeyEvent.VK_R; break;
            case "S": keyCode = KeyEvent.VK_S; break;
            case "T": keyCode = KeyEvent.VK_T; break;
            case "U": keyCode = KeyEvent.VK_U; break;
            case "V": keyCode = KeyEvent.VK_V; break;
            case "W": keyCode = KeyEvent.VK_W; break;
            case "X": keyCode = KeyEvent.VK_X; break;
            case "Y": keyCode = KeyEvent.VK_Y; break;
            case "Z": keyCode = KeyEvent.VK_Z; break;
            case "`": keyCode = KeyEvent.VK_BACK_QUOTE; break;
            case "1": keyCode = KeyEvent.VK_1; break;
            case "2": keyCode = KeyEvent.VK_2; break;
            case "3": keyCode = KeyEvent.VK_3; break;
            case "4": keyCode = KeyEvent.VK_4; break;
            case "5": keyCode = KeyEvent.VK_5; break;
            case "6": keyCode = KeyEvent.VK_6; break;
            case "7": keyCode = KeyEvent.VK_7; break;
            case "8": keyCode = KeyEvent.VK_8; break;
            case "9": keyCode = KeyEvent.VK_9; break;
            case "NUM1": keyCode = KeyEvent.VK_NUMPAD1; break;
            case "NUM2": keyCode = KeyEvent.VK_NUMPAD2; break;
            case "NUM3": keyCode = KeyEvent.VK_NUMPAD3; break;
            case "NUM4": keyCode = KeyEvent.VK_NUMPAD4; break;
            case "NUM5": keyCode = KeyEvent.VK_NUMPAD5; break;
            case "NUM6": keyCode = KeyEvent.VK_NUMPAD6; break;
            case "NUM7": keyCode = KeyEvent.VK_NUMPAD7; break;
            case "NUM8": keyCode = KeyEvent.VK_NUMPAD8; break;
            case "NUM9": keyCode = KeyEvent.VK_NUMPAD9; break;
            case "NUM0": keyCode = KeyEvent.VK_NUMPAD0; break;
            case "-": keyCode = KeyEvent.VK_MINUS; break;
            case "=": keyCode = KeyEvent.VK_EQUALS; break;
            case "[": keyCode = KeyEvent.VK_OPEN_BRACKET; break;
            case "]": keyCode = KeyEvent.VK_CLOSE_BRACKET; break;
            case "\\": keyCode = KeyEvent.VK_BACK_SLASH; break;
            case ";": keyCode = KeyEvent.VK_SEMICOLON; break;
            case "'": keyCode = KeyEvent.VK_QUOTE; break;
            case ",": keyCode = KeyEvent.VK_COMMA; break;
            case ".": keyCode = KeyEvent.VK_PERIOD; break;
            case "/": keyCode = KeyEvent.VK_SLASH; break;
            case "~":
                keyCode = KeyEvent.VK_BACK_QUOTE;
                keyCodeHold = KeyEvent.VK_SHIFT;
                break;
            case "!":
                keyCode = KeyEvent.VK_1;
                keyCodeHold = KeyEvent.VK_SHIFT;
                break;
            case "@":
                keyCode = KeyEvent.VK_2;
                keyCodeHold = KeyEvent.VK_SHIFT;
                break;
            case "#":
                keyCode = KeyEvent.VK_3;
                keyCodeHold = KeyEvent.VK_SHIFT;
                break;
            case "$":
                keyCode = KeyEvent.VK_4;
                keyCodeHold = KeyEvent.VK_SHIFT;
                break;
            case "%":
                keyCode = KeyEvent.VK_5;
                keyCodeHold = KeyEvent.VK_SHIFT;
                break;
            case "^":
                keyCode = KeyEvent.VK_6;
                keyCodeHold = KeyEvent.VK_SHIFT;
                break;
            case "&":
                keyCode = KeyEvent.VK_7;
                keyCodeHold = KeyEvent.VK_SHIFT;
                break;
            case "*":
                keyCode = KeyEvent.VK_8;
                keyCodeHold = KeyEvent.VK_SHIFT;
                break;
            case "(":
                keyCode = KeyEvent.VK_9;
                keyCodeHold = KeyEvent.VK_SHIFT;
                break;
            case ")":
                keyCode = KeyEvent.VK_0;
                keyCodeHold = KeyEvent.VK_SHIFT;
                break;
            case "_":
                keyCode = KeyEvent.VK_MINUS;
                keyCodeHold = KeyEvent.VK_SHIFT;
                break;
            case "+":
                keyCode = KeyEvent.VK_EQUALS;
                keyCodeHold = KeyEvent.VK_SHIFT;
                break;
            case "{":
                keyCode = KeyEvent.VK_OPEN_BRACKET;
                keyCodeHold = KeyEvent.VK_SHIFT;
                break;
            case "}":
                keyCode = KeyEvent.VK_CLOSE_BRACKET;
                keyCodeHold = KeyEvent.VK_SHIFT;
                break;
            case "|":
                keyCode = KeyEvent.VK_BACK_SLASH;
                keyCodeHold = KeyEvent.VK_SHIFT;
                break;
            case ":":
                keyCode = KeyEvent.VK_SEMICOLON;
                keyCodeHold = KeyEvent.VK_SHIFT;
                break;
            case "\"":
                keyCode = KeyEvent.VK_QUOTE;
                keyCodeHold = KeyEvent.VK_SHIFT;
                break;
            case "<":
                keyCode = KeyEvent.VK_COMMA;
                keyCodeHold = KeyEvent.VK_SHIFT;
                break;
            case ">":
                keyCode = KeyEvent.VK_PERIOD;
                keyCodeHold = KeyEvent.VK_SHIFT;
                break;
            case "?":
                keyCode = KeyEvent.VK_SLASH;
                keyCodeHold = KeyEvent.VK_SHIFT;
                break;
            case "ESC": keyCode = KeyEvent.VK_ESCAPE; break;
            case "ENTER": case "RETURN": case "\n": keyCode = KeyEvent.VK_ENTER; break;
            case "SPACE": case " ": keyCode = KeyEvent.VK_SPACE; break;
            case "CTRL": keyCode = KeyEvent.VK_CONTROL; break;
            case "SHIFT": keyCode = KeyEvent.VK_SHIFT; break;
            case "ALT": keyCode = KeyEvent.VK_ALT; break;
            case "TAB": keyCode = KeyEvent.VK_TAB; break;
            case "CONTEXT_MENU": keyCode = KeyEvent.VK_CONTEXT_MENU; break;
            case "NUM": case "NUMLK": case "NUM_LOCK": keyCode = KeyEvent.VK_NUM_LOCK; break;
            case "CAPS": case "CAPSLK": case "CAPS_LOCK": keyCode = KeyEvent.VK_CAPS_LOCK; break;
            case "SCR": case "SCRLK": case "SCROLL_LOCK": keyCode = KeyEvent.VK_SCROLL_LOCK; break;
            case "COPY": case "CTRL+C":
                keyCode = KeyEvent.VK_C;
                keyCodeHold = KeyEvent.VK_CONTROL;
                break;
            case "CUT": case "CTRL+X":
                keyCode = KeyEvent.VK_X;
                keyCodeHold = KeyEvent.VK_CONTROL;
                break;
            case "PASTE": case "CTRL+V":
                keyCode = KeyEvent.VK_V;
                keyCodeHold = KeyEvent.VK_CONTROL;
                break;
            case "START": case "WINDOWS_KEY": case "WINDOW": case "WINDOWS": keyCode = KeyEvent.VK_WINDOWS; break;
            case "LEFT": keyCode = KeyEvent.VK_LEFT; break;
            case "RIGHT": keyCode = KeyEvent.VK_RIGHT; break;
            case "UP": case "TOP": keyCode = KeyEvent.VK_UP; break;
            case "DOWN": case "BOTTOM": keyCode = KeyEvent.VK_DOWN; break;
            case "F1": keyCode = KeyEvent.VK_F1; break;
            case "F2": keyCode = KeyEvent.VK_F2; break;
            case "F3": keyCode = KeyEvent.VK_F3; break;
            case "F4": keyCode = KeyEvent.VK_F4; break;
            case "F5": keyCode = KeyEvent.VK_F5; break;
            case "F6": keyCode = KeyEvent.VK_F6; break;
            case "F7": keyCode = KeyEvent.VK_F7; break;
            case "F8": keyCode = KeyEvent.VK_F8; break;
            case "F9": keyCode = KeyEvent.VK_F9; break;
            case "F10": keyCode = KeyEvent.VK_F10; break;
            case "F11": keyCode = KeyEvent.VK_F11; break;
            case "F12": keyCode = KeyEvent.VK_F12; break;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKeyCode() {
        return keyCode;
    }

    public void setKeyCode(int keyCode) {
        this.keyCode = keyCode;
    }

    public int getKeyCodeHold() {
        return keyCodeHold;
    }

    public void setKeyCodeHold(int keyCodeHold) {
        this.keyCodeHold = keyCodeHold;
    }

    @Override
    public String toString() {
        return "Key{" +
                "name='" + name + '\'' +
                ", keyCode=" + keyCode +
                ", keyCodeHold=" + keyCodeHold +
                '}';
    }
}
