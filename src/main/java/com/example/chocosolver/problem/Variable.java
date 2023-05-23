package com.example.chocosolver.problem;

import lombok.Data;

import java.util.List;

@Data
public class Variable {

    private String name;
    private Pair valueInterval;
    private List<Integer> valueSet;

    public Variable(String name, Pair valueInterval) {
        this.name = name;
        this.valueInterval = valueInterval;
    }

    public Variable(String name, List<Integer> valueSet) {
        this.name = name;
        this.valueSet = valueSet;
    }

    @Override
    public String toString() {
        if (this.valueInterval != null) {
            return "Variable(" + name + " in" + this.valueInterval + ")";
        } else {
            return "Variable(" + name + " in" + this.valueSet;
        }
    }


}

