package com.example.chocosolver.problem;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Represents a pair of integers.
 */
@Data
@AllArgsConstructor
public class Pair {
    /**
     * The first integer value of the pair.
     */
    private int first;

    /**
     * The second integer value of the pair.
     */
    private int second;

    /**
     * Constructs a Pair object with the specified first and second values.
     *
     * @param first  the first integer value of the pair
     * @param second the second integer value of the pair
     */
    public Pair (Integer first, Integer second) {
        this(first.intValue(), second.intValue());
    }

    /**
     * Returns a string representation of the pair.
     * The string is formatted as "[first, second]".
     *
     * @return a string representation of the pair
     */
    @Override
    public String toString() {
        return "[" + first + " :: " + second + "]";
    }
}

