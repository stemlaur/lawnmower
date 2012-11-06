package com.mowitnow.lawnmower.service;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import com.mowitnow.lawnmower.exception.WrongInputFormatException;
import com.mowitnow.lawnmower.model.Vehicle;

/**
 * 
 * @author stemmer
 * 
 */
public interface CommandExecutor {

    /**
     * Parse the reader to get the command and execute them. The reader should
     * be closed by the calling class.
     * 
     * @param reader
     *            the reader to parse.
     * @return the list of vehicles on the last position.
     * @throws IOException
     *             when error occurs while reading the reader.
     * @throws WrongInputFormatException
     *             when the reader is not correctly formated.
     */
    List<Vehicle> getVehicles(Reader reader) throws IOException, WrongInputFormatException;

}
