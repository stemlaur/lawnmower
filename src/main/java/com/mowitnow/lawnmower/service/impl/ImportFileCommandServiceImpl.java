package com.mowitnow.lawnmower.service.impl;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mowitnow.lawnmower.exception.WrongInputFormatException;
import com.mowitnow.lawnmower.model.Vehicle;
import com.mowitnow.lawnmower.service.CommandExecutor;
import com.mowitnow.lawnmower.service.ImportFileCommandService;

/**
 * Implementation of a file executor.
 * 
 * @author stemmer
 * 
 */
public class ImportFileCommandServiceImpl implements ImportFileCommandService {

    private static final Logger LOG = LoggerFactory.getLogger(ImportFileCommandServiceImpl.class);

    private CommandExecutor commandExecutor;

    /**
     * Constructor.
     * 
     * @param commandExecutor
     *            a command executor.
     */
    public ImportFileCommandServiceImpl(CommandExecutor commandExecutor) {
        this.commandExecutor = commandExecutor;
    }

    @Override
    public List<Vehicle> execute(String filePath) throws IOException, WrongInputFormatException {
        LOG.info("Execute for the file path <{}>", filePath);

        FileInputStream fis = null;
        fis = new FileInputStream(filePath);

        InputStreamReader reader = new InputStreamReader(fis); // ASCII
        try {
            return commandExecutor.getVehicles(reader);
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                LOG.error("Impossible to close the InputStreamReader");
            }
            try {
                fis.close();
            } catch (IOException e) {
                LOG.error("Impossible to close the FileInputStream");
            }
        }
    }

}
