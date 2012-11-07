package com.mowitnow.lawnmower;

import java.io.IOException;
import java.util.List;

import com.mowitnow.lawnmower.exception.WrongInputFormatException;
import com.mowitnow.lawnmower.model.Vehicle;
import com.mowitnow.lawnmower.service.ImportFileCommandService;
import com.mowitnow.lawnmower.service.impl.CommandExecutorImpl;
import com.mowitnow.lawnmower.service.impl.ImportFileCommandServiceImpl;

/**
 * Main classes to import the command in a file.
 * 
 * @author stemmer
 * 
 */
public final class Main {

    /**
     * Private constructor.
     */
    private Main() {
    }

    /**
     * Main method to import the command in a file.
     * 
     * @param args
     *            An array should containg one element, the file path.
     */
    public static void main(String[] args) {
        if (args.length != 1) {
            logUsage();
            System.exit(0);
        }
        String filePath = args[0];

        ImportFileCommandService importFileCommandService =
                new ImportFileCommandServiceImpl(new CommandExecutorImpl());
        try {
            List<Vehicle> vehicles = importFileCommandService.execute(filePath);
            for (Vehicle vehicle : vehicles) {
                System.out.println(vehicle);
            }
        } catch (IOException e) {
            System.err.println("An error occured while reading the file");
        } catch (WrongInputFormatException e) {
            System.err.println("An error occured while parsing the commands");
        }
    }

    /**
     * Log the usage.
     */
    private static void logUsage() {
        System.err.println("Usage : <file_path>");
    }

}
