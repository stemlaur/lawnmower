package com.mowitnow.lawnmower.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Test the states and behaviour of a vehicle.
 * 
 * @author stemmer
 * 
 */
public class VehicleTest {
    private static final Position POSITION = new Position(3, 4);

    /**
     * Basic check of vehicle instantiations.
     */
    @Test
    public void testVehicleInstantiation() {
        Vehicle vehicle = new Vehicle(POSITION, Direction.N);
        assertEquals(POSITION, vehicle.getPosition());
        assertEquals(Direction.N, vehicle.getDirection());
    }

    /**
     * Basic check of vehicle instantiations.
     */
    @Test(expected = RuntimeException.class)
    public void testInstantiationWithNullPosition() {
        new Vehicle(null, Direction.N);
    }

    /**
     * Basic check of vehicle instantiations.
     */
    @Test(expected = RuntimeException.class)
    public void testInstantiationWithNullDirection() {
        new Vehicle(new Position(3, 4), null);
    }

    /**
     * Basic check of vehicle instantiations.
     */
    @Test
    public void testTurnTransitive() {
        Vehicle v = new Vehicle(POSITION, Direction.N);
        v.turnLeft();
        v.turnRight();

        assertEquals(Direction.N, v.getDirection());
    }

    /**
     * Perform a left turn anbd check the state of the new direction.
     * 
     * @param v
     *            the given vehicle.
     * @param expectedDirection
     *            the expected direction after turning left.
     */
    private void performTurnLeftAndCheck(Vehicle v, Direction expectedDirection) {
        Direction returnedDirection = v.turnLeft();
        assertEquals(expectedDirection, v.getDirection());
        assertEquals(expectedDirection, returnedDirection);
    }

    /**
     * Perform a right turn and check the state of the new direction.
     * 
     * @param v
     *            the given vehicle.
     * @param expectedDirection
     *            the expected direction after turning right.
     */
    private void performTurnRightAndCheck(Vehicle v, Direction expectedDirection) {
        Direction returnedDirection = v.turnRight();
        assertEquals(expectedDirection, v.getDirection());
        assertEquals(expectedDirection, returnedDirection);
    }

    /**
     * Basic check of vehicle instantiations.
     */
    @Test
    public void testTurnLeft() {
        performTurnLeftAndCheck(new Vehicle(POSITION, Direction.N), Direction.W);
        performTurnLeftAndCheck(new Vehicle(POSITION, Direction.S), Direction.E);
        performTurnLeftAndCheck(new Vehicle(POSITION, Direction.E), Direction.N);
        performTurnLeftAndCheck(new Vehicle(POSITION, Direction.W), Direction.S);
    }

    /**
     * Basic check of vehicle instantiations.
     */
    @Test
    public void testTurnRight() {
        performTurnRightAndCheck(new Vehicle(POSITION, Direction.N), Direction.E);
        performTurnRightAndCheck(new Vehicle(POSITION, Direction.S), Direction.W);
        performTurnRightAndCheck(new Vehicle(POSITION, Direction.E), Direction.S);
        performTurnRightAndCheck(new Vehicle(POSITION, Direction.W), Direction.N);
    }

    /**
     * Basic check of vehicle instantiations.
     */
    @Test
    public void testTurnDoesNotChangePosition() {
        Vehicle v = new Vehicle(POSITION, Direction.N);
        v.turnLeft();
        assertEquals(POSITION, v.getPosition());
        v.turnRight();
        assertEquals(POSITION, v.getPosition());

        performTurnLeftAndCheck(new Vehicle(POSITION, Direction.N), Direction.W);
        performTurnLeftAndCheck(new Vehicle(POSITION, Direction.S), Direction.E);
        performTurnLeftAndCheck(new Vehicle(POSITION, Direction.E), Direction.N);
        performTurnLeftAndCheck(new Vehicle(POSITION, Direction.W), Direction.S);
    }
}
