package com.mowitnow.lawnmower.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.google.common.base.Preconditions;
import com.mowitnow.lawnmower.exception.WrongInputFormatException;
import com.mowitnow.lawnmower.model.Dimension;
import com.mowitnow.lawnmower.model.Direction;
import com.mowitnow.lawnmower.model.Position;
import com.mowitnow.lawnmower.model.Vehicle;
import com.mowitnow.lawnmower.service.CommandExecutor;
import com.mowitnow.lawnmower.service.PlayGround;

/**
 * 
 * @author stemmer
 * 
 */
public class CommandExecutorImpl implements CommandExecutor {

    @Override
    public List<Vehicle> getVehicles(Reader reader) throws IOException, WrongInputFormatException {
        Preconditions.checkNotNull(reader, "reader cannot be null");

        List<Vehicle> vehicles = new ArrayList<Vehicle>();
        BufferedReader bf = new BufferedReader(reader);
        Dimension dimension = readDimension(bf);

        while (true) {
            Vehicle vehicle = readVehicle(bf);
            if (vehicle == null) {
                break;
            }
            PlayGround playGround = new PlayGroundImpl(dimension, vehicle);
            String commands = readCommands(bf);
            for (int i = 0; i < commands.length(); i++) {
                Character c = commands.charAt(i);
                switch (c) {
                case 'A':
                    playGround.moveForward();
                    break;
                case 'D':
                    playGround.turnRight();
                    break;
                case 'G':
                    playGround.turnLeft();
                    break;
                default:
                    throw new WrongInputFormatException("A command cannot be found " + c);
                }
            }

            vehicles.add(vehicle);
        }

        if (vehicles.isEmpty()) {
            throw new WrongInputFormatException("No vehicle positions found");
        }
        return vehicles;
    }

    /**
     * Returns the line of commands.
     * 
     * @param bufferedReader
     *            bufferedReader.
     * @return the line of commands.
     * @throws IOException
     *             on IO exception.
     * @throws WrongInputFormatException
     *             on wrong input.
     */
    private String readCommands(BufferedReader bufferedReader)
            throws IOException,
            WrongInputFormatException {
        String line = bufferedReader.readLine();
        if (StringUtils.isEmpty(line)) {
            throw new WrongInputFormatException("The command line is empty");
        }
        return line;
    }

    /**
     * Read the line of the input, and deduct the vehicle.
     * 
     * @param bufferedReader
     *            the buffered reader.
     * @return the read vehicle.
     * @throws IOException
     *             on IO error.
     * @throws WrongInputFormatException
     *             on format error.
     */
    private Vehicle readVehicle(BufferedReader bufferedReader)
            throws IOException,
            WrongInputFormatException {
        String l = bufferedReader.readLine();
        if (l == null) {
            return null;
        }
        String[] vehicleLine = l.split(" ");

        if (vehicleLine.length != 3) {
            throw new WrongInputFormatException("The vehicle line [" + l + "] is not compatible");
        }

        try {
            return new Vehicle(new Position(
                    Integer.parseInt(vehicleLine[0]),
                    Integer.parseInt(vehicleLine[1])), Direction.valueOf(vehicleLine[2]));
        } catch (NumberFormatException e) {
            throw new WrongInputFormatException("The vehicle line [" + l + "] is not compatible");
        } catch (IllegalArgumentException e) {
            throw new WrongInputFormatException("The vehicle line [" + l + "] is not compatible");
        }
    }

    /**
     * Read the line of the input, and deduct the dimension.
     * 
     * @param bufferedReader
     *            the buffered reader.
     * @return the read dimension.
     * @throws IOException
     *             on IO error.
     * @throws WrongInputFormatException
     *             on format error.
     */
    private Dimension readDimension(BufferedReader bufferedReader)
            throws IOException,
            WrongInputFormatException {
        String line = bufferedReader.readLine();
        if (line == null) {
            throw new WrongInputFormatException("The dimension line [" + line
                    + "] is not compatible");
        }
        String[] dimensionLine = line.split(" ");

        if (dimensionLine.length != 2) {
            throw new WrongInputFormatException("The dimension line [" + line
                    + "] is not compatible");
        }

        try {
            return new Dimension(
                    Integer.parseInt(dimensionLine[0]),
                    Integer.parseInt(dimensionLine[1]));
        } catch (NumberFormatException e) {
            throw new WrongInputFormatException("The dimension line [" + line
                    + "] is not compatible");
        }
    }
}
