package com.mowitnow.lawnmower.service;

import java.io.IOException;
import java.util.List;

import com.mowitnow.lawnmower.exception.WrongInputFormatException;
import com.mowitnow.lawnmower.model.Vehicle;

/**
 * Service that executes command of a file.
 * 
 * @author stemmer
 * 
 */
public interface ImportFileCommandService {

    /**
     * Tries to parse the file and process it.
     * 
     * @param filePath
     *            the file path.
     * @return the list of vehicles on the last position.
     * @throws IOException
     *             when the file cannot be found or a problem occurs while
     *             reading it.
     * @throws WrongInputFormatException
     *             on wrong input.
     */
    List<Vehicle> execute(String filePath) throws IOException, WrongInputFormatException;

}
