package org.howard.edu.lsp.midterm.question2;

/**
 * Interface representing a range of integers.
 */
public interface Range {
    /**
     * Returns true if the value is within the range, false otherwise.
     *
     * @param value the value to check
     * @return true if value is within the range, false otherwise
     */
    boolean contains(int value);

    /**
     * Returns true if the range overlaps with another range, false otherwise.
     *
     * @param other the other range to check for overlap
     * @return true if the ranges overlap, false otherwise
     */
    boolean overlaps(Range other);

    /**
     * Returns the number of integers in the range.
     *
     * @return the size of the range
     */
    int size();
    
    /**
     * Returns the lower bound of the range.
     *
     * @return the lower bound of the range
     */
    int getLowerBound();
    
    /**
     * Returns the upper bound of the range.
     *
     * @return the upper bound of the range
     */
    int getUpperBound();
}