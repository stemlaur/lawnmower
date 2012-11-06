package com.mowitnow.lawnmower.service;

import com.mowitnow.lawnmower.model.Vehicle;

/**
 * Interface in charged of moving the vehicle.
 * 
 * @author stemmer
 * 
 */
public interface PlayGround {

    /**
     * Turns the vehicle left.
     */
    void turnLeft();

    /**
     * Turns the vehicle left.
     */
    void turnRight();

    /**
     * Moves the vehicle forward.
     */
    void moveForward();

    /**
     * Returns the vehicle.
     * 
     * @return the vehicle.
     */
    Vehicle getVehicle();

}
