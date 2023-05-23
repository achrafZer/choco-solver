package com.example.chocosolver.problem;

import lombok.Data;

import java.util.List;

@Data
public class Term {

    //exemple: A+B ==> variables: {A, B} || operator: PLUS
    private Integer value;
    private Variable variable;
    private List<Term> listvariable;
    private Operator operator;

    //Term : 4
    public Term(int value) {
        this.value = value;
    }

    //Term : A
    public Term(Variable variable) {
    	this.variable=variable;
    }

    //Term : A+B
    public Term(List<Term> variables, Operator operator) {
    	this.listvariable =variables;
    	this.operator=operator;
    }

    @Override
    public String toString() {
        if (this.value != null) {
            return "Term(" + value + ")";
        } else if (this.variable != null) {
            return "Term(" + variable + ")";
        } else {
            return "Term(Variables : " + this.listvariable + ", " + "Operator : " + this.operator + ")";
        }
    }
}
