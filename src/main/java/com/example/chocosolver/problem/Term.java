package com.example.chocosolver.problem;

import lombok.Data;

import java.util.List;

@Data
public class Term {

    //exemple: A+B ==> variables: {A, B} || operator: PLUS
    private final Integer value;
    private final Variable variable;
    private final List<Term> terms;
    private final Operator operator;

    //Term : 4
    public Term(int value) {
        this.value = value;
        this.variable = null;
        this.terms = null;
        this.operator = null;
    }

    //Term : A
    public Term(Variable variable) {
    	this.variable=variable;
        this.terms = null;
        this.value = null;
        this.operator = null;
    }

    //Term : A+B
    public Term(List<Term> variables, Operator operator) {
    	this.terms =variables;
    	this.operator=operator;
        this.value = null;
        this.variable = null;
    }

    public Term(Term a, Operator operator, Term b) {
        this.terms = List.of(a, b);
        this.operator=operator;
        this.value = null;
        this.variable = null;
    }
    @Override
    public String toString() {
        if (this.value != null) {
            return "Term(" + value + ")";
        } else if (this.variable != null) {
            return "Term(" + variable + ")";
        } else {
            return "Term(Variables : " + this.terms + ", " + "Operator : " + this.operator + ")";
        }
    }
    
   
    
}
