package com.example.chocosolver.problem;

import lombok.Data;
import org.jgrapht.alg.util.Pair;

import java.util.List;

@Data
public class Variable {

    private String name;
    private boolean isANumber;
    private Pair<Integer, Integer> valueInterval;
    private List<Integer> valueSet;
    private Integer constantValue;



    public Variable(String name, Pair<Integer, Integer> valueInterval) {
    	this.name=name;
    	this.isANumber = false;
        this.valueInterval = valueInterval;
    }

    public Variable(String name, List<Integer> valueSet) {
    	this.name=name;
    	this.isANumber = false;
    	this.valueSet=valueSet;
    }
    public Variable(String name, Integer value) {
    	this.name=name;
    	this.isANumber = true;
    	this.constantValue=value;
    }

}

