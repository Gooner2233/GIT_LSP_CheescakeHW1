package org.howard.edu.lsp.midterm.question2;

/**
 * Class representing a range of integers.
 */
public class IntegerRange implements Range {
    private final int lowerBound;
    private final int upperBound;

    /**
     * Constructs a new IntegerRange with the specified lower and upper bounds.
     *
     * @param lowerBound the lower bound of the range (inclusive)
     * @param upperBound the upper bound of the range (inclusive)
     */
    public IntegerRange(int lowerBound, int upperBound) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }
    
    /**
     * Gets the lower bound of the range.
     *
     * @return the lower bound of the range
     */
    @Override
    public int getLowerBound() {
        return lowerBound;
    }

    /**
     * Gets the upper bound of the range.
     *
     * @return the upper bound of the range
     */
    @Override
    public int getUpperBound() {
        return upperBound;
    }

    /**
     * Checks if the range contains the specified value.
     *
     * @param value the value to check
     * @return true if value is within the range, false otherwise
     */
    @Override
    public boolean contains(int value) {
        return value >= lowerBound && value <= upperBound;
    }

    /**
     * Checks if the range overlaps with another range.
     *
     * @param other the other range to check for overlap
     * @return true if the ranges overlap, false otherwise
     */
    @Override
    public boolean overlaps(Range other) {
        int otherLowerBound = other.getLowerBound();
        int otherUpperBound = other.getUpperBound();
        return lowerBound <= otherUpperBound && upperBound >= otherLowerBound;
    }

    /**
     * Returns the number of integers in the range.
     *
     * @return the size of the range
     */
    @Override
    public int size() {
        return upperBound - lowerBound + 1;
    }

    /**
     * Compares this IntegerRange to the specified object.
     * Returns true if the specified object is an IntegerRange
     * with the same lower and upper bounds, false otherwise.
     *
     * @param obj the object to compare
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IntegerRange)) {
            return false;
        }
        IntegerRange other = (IntegerRange) obj;
        return this.lowerBound == other.lowerBound && this.upperBound == other.upperBound;
    }
}
