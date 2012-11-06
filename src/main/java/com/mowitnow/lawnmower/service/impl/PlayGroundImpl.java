package com.mowitnow.lawnmower.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Preconditions;
import com.mowitnow.lawnmower.exception.VehicleOutOfTheGroungException;
import com.mowitnow.lawnmower.model.Dimension;
import com.mowitnow.lawnmower.model.Position;
import com.mowitnow.lawnmower.model.Vehicle;
import com.mowitnow.lawnmower.service.PlayGround;

/**
 * 
 * @author stemmer
 * 
 */
public class PlayGroundImpl implements PlayGround {

    private static final Logger LOG = LoggerFactory.getLogger(PlayGroundImpl.class);

    private Vehicle vehicle;
    private Dimension dimension;

    /**
     * Init the playground with a Vehicle in the given position and direction.
     * 
     * @param dimension
     *            dimension of the play ground.
     * @param vehicle
     *            the vehicle.
     */
    public PlayGroundImpl(Dimension dimension, Vehicle vehicle) {
        Preconditions.checkNotNull(dimension, "Dimension cannot be null");
        Preconditions.checkNotNull(vehicle, "Vehicle cannot be null");
        this.vehicle = vehicle;
        this.dimension = dimension;

        if (vehicle.getPosition().getX() > dimension.getWidth()
                || vehicle.getPosition().getY() > dimension.getHeight()) {
            throw new VehicleOutOfTheGroungException();
        }

        LOG.info("Initialisation with vehicle {} and dimension {}", vehicle, dimension);
    }

    @Override
    public void turnLeft() {
        LOG.info("Turning left");
        vehicle.turnLeft();
        if (LOG.isDebugEnabled()) {
            LOG.debug("Vehicle : {}", vehicle);
        }
    }

    @Override
    public void turnRight() {
        LOG.info("Turning right");
        vehicle.turnRight();
        if (LOG.isDebugEnabled()) {
            LOG.debug("Vehicle : {}", vehicle);
        }
    }

    @Override
    public void moveForward() {
        LOG.info("Moving forward");
        Position newPosition = null;
        switch (vehicle.getDirection()) {
        case E:
            newPosition = vehicle.getPosition().incrementX();
            break;
        case N:
            newPosition = vehicle.getPosition().incrementY();
            break;
        case S:
            newPosition = vehicle.getPosition().decrementY();
            break;
        default: // WEST
            newPosition = vehicle.getPosition().decrementX();
            break;
        }

        if (validatePosition(newPosition)) {
            vehicle.setPosition(newPosition);
            if (LOG.isDebugEnabled()) {
                LOG.debug("Vehicle : {}", vehicle);
            }
        } else {
            LOG.warn("Cannot move forward from position {}", vehicle.getPosition());
        }
    }

    /**
     * Validate the position in the play ground.
     * 
     * @param position
     *            the position to validate.
     * 
     * @return true if the position is valid.
     */
    private boolean validatePosition(Position position) {
        return position.getX() >= 0 && position.getY() >= 0
                && position.getX() <= dimension.getWidth()
                && position.getY() <= dimension.getHeight();
    }

    @Override
    public Vehicle getVehicle() {
        return vehicle;
    }

}
