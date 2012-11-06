package com.mowitnow.lawnmower.service.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import com.mowitnow.lawnmower.exception.WrongInputFormatException;
import com.mowitnow.lawnmower.service.CommandExecutor;
import com.mowitnow.lawnmower.service.ExecuteFileService;

/**
 * Implementation of a file executor.
 * 
 * @author stemmer
 * 
 */
public class ExecuteFileServiceImpl implements ExecuteFileService {

    private CommandExecutor commandExecutor;

    /**
     * Constructor.
     * 
     * @param commandExecutor
     *            a command executor.
     */
    public ExecuteFileServiceImpl(CommandExecutor commandExecutor) {
        this.commandExecutor = commandExecutor;
    }

    @Override
    public void execute(String filePath) throws IOException, WrongInputFormatException {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(filePath);
        } catch (FileNotFoundException e) {
            System.err.println("The file does not exist");
        }

        InputStreamReader reader = new InputStreamReader(fis); // ASCII
        commandExecutor.getVehicles(reader);

        reader.close();
        fis.close();
    }

}
