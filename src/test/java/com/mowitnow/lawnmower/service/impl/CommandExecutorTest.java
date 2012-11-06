package com.mowitnow.lawnmower.service.impl;

import static org.junit.Assert.assertEquals;

import java.io.StringReader;
import java.util.List;

import org.junit.Test;

import com.mowitnow.lawnmower.model.Direction;
import com.mowitnow.lawnmower.model.Position;
import com.mowitnow.lawnmower.model.Vehicle;

/**
 * 
 * @author stemmer
 * 
 */
public class CommandExecutorTest {

    private static final String NEWLINE = "\n";

    /**
     * Basic test of instantiating with null dimension.
     * 
     * @throws Exception
     *             on errors.
     * 
     */
    @Test(expected = RuntimeException.class)
    public void testInstantiationWithNullDimension() throws Exception {
        new CommandExecutorImpl().getVehicles(null);
    }

    /**
     * Basic test of instantiating with null dimension.
     * 
     * @throws Exception
     *             on errors.
     * 
     */
    @Test
    public void testScenario() throws Exception {
        List<Vehicle> vehicles =
                new CommandExecutorImpl().getVehicles(new StringReader("5 5" + NEWLINE + "1 2 N"
                        + NEWLINE + "GAGAGAGAA" + NEWLINE + "3 3 E" + NEWLINE + "AADAADADDA"));

        assertEquals(2, vehicles.size());
        assertEquals(new Vehicle(new Position(1, 3), Direction.N), vehicles.get(0));
        assertEquals(new Vehicle(new Position(5, 1), Direction.E), vehicles.get(1));

    }
}
