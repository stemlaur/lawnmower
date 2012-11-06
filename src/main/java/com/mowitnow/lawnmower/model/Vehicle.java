package com.mowitnow.lawnmower.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.google.common.base.Preconditions;

/**
 * Represents any kind of vehicle with a position on the playground.
 * 
 * @author stemmer
 * 
 */
public class Vehicle {

    private Position position;
    private Direction direction;

    /**
     * Default constructor.
     * 
     * @param position
     *            the position of the Vehicle.
     * @param direction
     *            the direction of the vehicle.
     */
    public Vehicle(final Position position, final Direction direction) {
        Preconditions.checkNotNull(position, "Position cannot be null");
        Preconditions.checkNotNull(direction, "Direction cannot be null");
        this.position = position;
        this.direction = direction;
    }

    /**
     * Turns the vehicle to the right, it's a mutator of the direction.
     * 
     * @return the new direction.
     */
    public Direction turnRight() {
        Direction rightDirection = null;
        switch (direction) {
        case N:
            rightDirection = Direction.E;
            break;
        case E:
            rightDirection = Direction.S;
            break;
        case S:
            rightDirection = Direction.W;
            break;
        default:
            rightDirection = Direction.N;
            break;
        }
        return this.direction = rightDirection;
    }

    /**
     * Turns the vehicle to the left it's a mutator of the direction.
     * 
     * @return the new direction.
     */
    public Direction turnLeft() {
        Direction leftDirection = null;
        switch (direction) {
        case N:
            leftDirection = Direction.W;
            break;
        case E:
            leftDirection = Direction.N;
            break;
        case S:
            leftDirection = Direction.E;
            break;
        default:
            leftDirection = Direction.S;
            break;
        }
        return this.direction = leftDirection;
    }

    /**
     * Returns the position of the vehicle.
     * 
     * @return the position of the vehicle.
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Set the position of the vehicle.
     * 
     * @param position
     *            newposition of the vehicle.
     */
    public void setPosition(Position position) {
        Preconditions.checkNotNull(position, "Position cannot be null");
        this.position = position;
    }

    /**
     * Returns the direction of the vehicle.
     * 
     * @return the direction of the vehicle.
     */
    public Direction getDirection() {
        return direction;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (other == this) {
            return true;
        }
        if (other.getClass() != getClass()) {
            return false;
        }
        return EqualsBuilder.reflectionEquals(this, other);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public String toString() {
        return position.getX() + " " + position.getY() + " " + direction;
    }
}
