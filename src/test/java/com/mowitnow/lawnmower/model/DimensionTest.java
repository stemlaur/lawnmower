package com.mowitnow.lawnmower.model;

import org.junit.Test;

import com.mowitnow.lawnmower.exception.DimensionTooSmallException;

/**
 * Test dimension.
 * 
 * @author stemmer
 * 
 */
public class DimensionTest {

    /**
     * Basic instantiation test.
     */
    @Test(expected = RuntimeException.class)
    public void testInstantiatingWithNullHeight() {
        new Dimension(null, 1);
    }

    /**
     * Basic instantiation test.
     */
    @Test(expected = RuntimeException.class)
    public void testInstantiatingWithNullWidth() {
        new Dimension(1, null);
    }

    /**
     * Basic instantiation test.
     */
    @Test(expected = DimensionTooSmallException.class)
    public void testInstantiatingWithZeroWidth() {
        new Dimension(0, 1);
    }

    /**
     * Basic instantiation test.
     */
    @Test(expected = DimensionTooSmallException.class)
    public void testInstantiatingWithZeroHeight() {
        new Dimension(1, 0);
    }

    /**
     * Basic instantiation test.
     */
    @Test(expected = DimensionTooSmallException.class)
    public void testInstantiatingWithNegativeWidth() {
        new Dimension(-1, 1);
    }

    /**
     * Basic instantiation test.
     */
    @Test(expected = DimensionTooSmallException.class)
    public void testInstantiatingWithNegativeHeight() {
        new Dimension(1, -2);
    }

}
