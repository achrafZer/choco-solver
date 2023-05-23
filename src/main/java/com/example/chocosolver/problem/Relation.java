/**
 * The Relation enum represents relational operators used in constraints.
 * It defines various relational operators that can be used to compare values.
 */
package com.example.chocosolver.problem;

/**
 * Represents relational operators used in constraints.
 */
public enum Relation {
    /**
     * Greater than operator.
     */
    SUPERIOR,

    /**
     * Greater than or equal to operator.
     */
    SUPERIORorEQUAL,

    /**
     * Less than operator.
     */
    INFERIOR,

    /**
     * Less than or equal to operator.
     */
    INFERIORorEQUAL,

    /**
     * Equality operator.
     */
    EQUALS,

    /**
     * Inequality operator.
     */
    DIFFERENT
}
