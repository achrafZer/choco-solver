package com.example.chocosolver.problem;

import lombok.Data;

import java.util.List;

/**
 * Represents a variable used in a problem.
 */
@Data

public class Variable {

    /**
     * The name of the variable.
     */
    private final String name;

    /**
     * If the user provided the interval that contains the possible values of the variable in an interval : The interval of the
     * possible values of the variable.
     */
    private Pair valueInterval;

    /**
     * If the user provided the set that contains the possible values of the variable in a list : The set of the
     * possible values of the variable.
     */
    private List<Integer> valueSet;

    /**
     * Constructs a Variable object with the specified name.
     *
     * @param name the name of the variable
     */
    public Variable(String name) {
        this.name = name;
        this.valueSet = null;
        this.valueInterval = null;
    }

    /**
     * Constructs a Variable object with the specified name and value interval.
     *
     * @param name          the name of the variable
     * @param valueInterval the value interval of the variable
     */
    public Variable(String name, Pair valueInterval) {
        this.name = name;
        this.valueInterval = valueInterval;
        this.valueSet = null;
    }

    /**
     * Constructs a Variable object with the specified name and value set.
     *
     * @param name      the name of the variable
     * @param valueSet  the value set of the variable
     */
    public Variable(String name, List<Integer> valueSet) {
        this.name = name;
        this.valueSet = valueSet;
        this.valueInterval = null;
    }

    /**
     * Returns a string representation of the variable.
     * If the value interval is set, the string is formatted as "Variable(name in valueInterval)".
     * If the value set is set, the string is formatted as "Variable(name in valueSet)".
     *
     * @return a string representation of the variable
     */
    @Override
    public String toString() {
        if (this.valueInterval != null) {
            return "Variable(" + name + " in " + this.valueInterval + ")";
        } else {
            return "Variable(" + name + " in " + this.valueSet;
        }
    }
}

