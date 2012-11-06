package com.mowitnow.lawnmower;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        if (args.length != 1) {
            logUsage();
        }
        String filePath = args[0];
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(filePath);
        } catch (FileNotFoundException e) {
            System.err.println("The file does not exist");
        }

        InputStreamReader in = new InputStreamReader(fis); // ASCII

    }

    private static void logUsage() {
        System.err.println("Usage : <file_path>");
    }

}
