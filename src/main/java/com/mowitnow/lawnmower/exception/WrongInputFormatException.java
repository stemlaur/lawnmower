package com.mowitnow.lawnmower.exception;

/**
 * Thrown when the input of the system is not in the proper format.
 * 
 * @author stemmer
 * 
 */
public class WrongInputFormatException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructor.
     * 
     * @param message
     *            the message of the exception.
     */
    public WrongInputFormatException(String message) {
        super(message);
    }

}
