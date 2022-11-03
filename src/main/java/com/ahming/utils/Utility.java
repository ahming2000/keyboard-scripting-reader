package com.ahming.utils;

public class Utility {

    public static void pause(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt(); // Need to interrupt again for main action thread, last interruption only affect the sleep
        }
    }

}
