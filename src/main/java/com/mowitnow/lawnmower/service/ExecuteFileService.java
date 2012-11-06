package com.mowitnow.lawnmower.service;

import java.io.IOException;

import com.mowitnow.lawnmower.exception.WrongInputFormatException;

/**
 * Service that executes command of a file.
 * 
 * @author stemmer
 * 
 */
public interface ExecuteFileService {

    /**
     * Tries to parse the file and process it.
     * 
     * @param filePath
     *            the file path.
     * @throws IOException
     *             when the file cannot be found or a problem occurs while
     *             reading it.
     * @throws WrongInputFormatException
     *             on wrong input.
     */
    void execute(String filePath) throws IOException, WrongInputFormatException;

}
