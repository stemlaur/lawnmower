package com.mowitnow.lawnmower.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.google.common.base.Preconditions;

/**
 * Immutable position.
 * 
 * @author stemmer
 * 
 */
public class Position {

    private Integer x;
    private Integer y;

    /**
     * Construct a position in a cartesian plan.
     * 
     * @param x
     *            the X position, should not be null.
     * @param y
     *            the Y position, should not be null.
     */
    public Position(final Integer x, final Integer y) {
        Preconditions.checkNotNull(x, "x cannot be null");
        Preconditions.checkNotNull(y, "y cannot be null");
        this.x = x;
        this.y = y;
    }

    /**
     * Returns the X position.
     * 
     * @return the X position.
     */
    public Integer getX() {
        return x;
    }

    /**
     * Returns the Y position.
     * 
     * @return the Y position.
     */
    public Integer getY() {
        return y;
    }

    /**
     * Increment X and return a new Position.
     * 
     * @return return a new Position with X incremented.
     */
    public Position incrementX() {
        return new Position(x + 1, y);
    }

    /**
     * Increment Y and return a new Position.
     * 
     * @return return a new Position with Y incremented.
     */
    public Position incrementY() {
        return new Position(x, y + 1);
    }

    /**
     * Decrement X and return a new Position.
     * 
     * @return return a new Position with X decremented.
     */
    public Position decrementX() {
        return new Position(x - 1, y);
    }

    /**
     * Decrement Y and return a new Position.
     * 
     * @return return a new Position with Y decremented.
     */
    public Position decrementY() {
        return new Position(x, y - 1);
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
        return "(" + x + "," + y + ")";
    }
}
