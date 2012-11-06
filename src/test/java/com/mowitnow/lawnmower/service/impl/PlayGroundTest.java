package com.mowitnow.lawnmower.service.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.mowitnow.lawnmower.exception.VehicleOutOfTheGroungException;
import com.mowitnow.lawnmower.model.Dimension;
import com.mowitnow.lawnmower.model.Direction;
import com.mowitnow.lawnmower.model.Position;
import com.mowitnow.lawnmower.model.Vehicle;
import com.mowitnow.lawnmower.service.PlayGround;

/**
 * Test the logic of moving the vehicle in a playground by performing the basic
 * actions.
 * 
 * @author stemmer
 * 
 */
public class PlayGroundTest {

    /**
     * Basic test of instantiating with null dimension.
     */
    @Test(expected = RuntimeException.class)
    public void testInstantiationWithNullDimension() {
        new PlayGroundImpl(null, new Vehicle(new Position(1, 1), Direction.E));
    }

    /**
     * Basic test of instantiating with null vehicle.
     */
    @Test(expected = RuntimeException.class)
    public void testInstantiationWithNullVehicle() {
        new PlayGroundImpl(new Dimension(5, 5), null);
    }

    /**
     * Basic test of instantiating with null vehicle.
     */
    @Test(expected = VehicleOutOfTheGroungException.class)
    public void testInstantiationWithVehicleInWrongInitialXPosition() {
        new PlayGroundImpl(new Dimension(5, 5), new Vehicle(new Position(6, 2), Direction.N));
    }

    /**
     * Basic test of instantiating with null vehicle.
     */
    @Test(expected = VehicleOutOfTheGroungException.class)
    public void testInstantiationWithVehicleInWrongInitialYPosition() {
        new PlayGroundImpl(new Dimension(5, 5), new Vehicle(new Position(2, 6), Direction.N));
    }

    /**
     * Test that the vehicle don't change its position or direction when facing
     * a wall on east.
     */
    @Test
    public void testEastWallDoesNotChangeVehiclePosition() {
        Vehicle expected = new Vehicle(new Position(5, 3), Direction.E);
        PlayGround pg = new PlayGroundImpl(new Dimension(5, 5), expected);
        pg.moveForward();
        assertEquals(expected, pg.getVehicle());
    }

    /**
     * Test that the vehicle don't change its position or direction when facing
     * a wall on east.
     */
    @Test
    public void testWestWallDoesNotChangeVehiclePosition() {
        Vehicle expected = new Vehicle(new Position(0, 2), Direction.W);
        PlayGround pg = new PlayGroundImpl(new Dimension(5, 5), expected);
        pg.moveForward();
        assertEquals(expected, pg.getVehicle());
    }

    /**
     * Test that the vehicle don't change its position or direction when facing
     * a wall on east.
     */
    @Test
    public void testNorthWallDoesNotChangeVehiclePosition() {
        Vehicle expected = new Vehicle(new Position(1, 5), Direction.N);
        PlayGround pg = new PlayGroundImpl(new Dimension(5, 5), expected);
        pg.moveForward();
        assertEquals(expected, pg.getVehicle());
    }

    /**
     * Test that the vehicle don't change its position or direction when facing
     * a wall on east.
     */
    @Test
    public void testSouthWallDoesNotChangeVehiclePosition() {
        Vehicle expected = new Vehicle(new Position(1, 0), Direction.S);
        PlayGround pg = new PlayGroundImpl(new Dimension(5, 5), expected);
        pg.moveForward();
        assertEquals(expected, pg.getVehicle());
    }

    /**
     * Basic test of instantiating with null vehicle.
     */
    @Test
    public void testBasicScenario1() {
        PlayGround pg =
                new PlayGroundImpl(new Dimension(5, 5), new Vehicle(
                        new Position(1, 2),
                        Direction.N));
        pg.turnLeft();
        pg.moveForward();
        pg.turnLeft();
        pg.moveForward();
        pg.turnLeft();
        pg.moveForward();
        pg.turnLeft();
        pg.moveForward();
        pg.moveForward();

        assertEquals(new Vehicle(new Position(1, 3), Direction.N), pg.getVehicle());
    }

    /**
     * Basic test of instantiating with null vehicle.
     */
    @Test
    public void testBasicScenario2() {
        PlayGround pg =
                new PlayGroundImpl(new Dimension(5, 5), new Vehicle(
                        new Position(3, 3),
                        Direction.E));
        pg.moveForward();
        pg.moveForward();
        pg.turnRight();
        pg.moveForward();
        pg.moveForward();
        pg.turnRight();
        pg.moveForward();
        pg.turnRight();
        pg.turnRight();
        pg.moveForward();

        assertEquals(new Vehicle(new Position(5, 1), Direction.E), pg.getVehicle());
    }
}
