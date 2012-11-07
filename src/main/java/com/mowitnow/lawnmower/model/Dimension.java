package com.mowitnow.lawnmower.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.google.common.base.Preconditions;
import com.mowitnow.lawnmower.exception.DimensionTooSmallException;

/**
 * Immutable class representing the dimension of the playground.
 * 
 * @author stemmer
 * 
 */
public class Dimension {

    private Integer height;
    private Integer width;

    /**
     * Constructor of a dimension.
     * 
     * @param height
     *            the height, should not be null.
     * @param width
     *            the widtht, should not be null.
     * @throws DimensionTooSmallException
     *             when a side is given less than 1.
     */
    public Dimension(Integer height, Integer width) {
        super();
        Preconditions.checkNotNull(height, "height cannot be null");
        Preconditions.checkNotNull(width, "width cannot be null");
        if (height <= 0 || width <= 0) {
            throw new DimensionTooSmallException();
        }
        this.height = height;
        this.width = width;
    }

    /**
     * Returns the height.
     * 
     * @return the height.
     */
    public Integer getHeight() {
        return height;
    }

    /**
     * Returns the width.
     * 
     * @return the width.
     */
    public Integer getWidth() {
        return width;
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
        return height + " " + width;
    }

}
