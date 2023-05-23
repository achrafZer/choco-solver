package com.example.chocosolver.problem;

import lombok.Data;

import java.util.List;

/**
 * Represents a term used in a problem.
 */
@Data
public class Term {

    //exemple: A+B ==> variables: {A, B} || operator: PLUS

    /**
     * If the term contains just a number : the constant value of the term.
     */
    private final Integer value;

    /**
     * If the term contains a variable only : the variable of the term.
     */
    private final Variable variable;

    /**
     * If the term is not a variable, not a number : the list of the two sub-terms in the term.
     */
    private final List<Term> terms;

    /**
     * If the term is not a variable, not a number : the operator applied to the term.
     */
    private final Operator operator;

    //Term : 4
    /**
     * Constructs a Term object with the specified constant value.
     *
     * @param value the constant value of the term
     */
    public Term(int value) {
        this.value = value;
        this.variable = null;
        this.terms = null;
        this.operator = null;
    }

    //Term : A
    /**
     * Constructs a Term object with the specified variable.
     *
     * @param variable the variable of the term
     */
    public Term(Variable variable) {
    	this.variable=variable;
        this.terms = null;
        this.value = null;
        this.operator = null;
    }

    //Term : A+B
    /**
     * Constructs a Term object with the specified list of sub-terms and operator.
     *
     * @param variables the list of sub-terms in the term
     * @param operator  the operator applied to the term
     */
    public Term(List<Term> variables, Operator operator) {
    	this.terms =variables;
    	this.operator=operator;
        this.value = null;
        this.variable = null;
    }

    /**
     * Constructs a Term object with the specified left and right sub-terms and operator.
     *
     * @param a        the left sub-term
     * @param operator the operator applied to the term
     * @param b        the right sub-term
     */
    public Term(Term a, Operator operator, Term b) {
        this.terms = List.of(a, b);
        this.operator=operator;
        this.value = null;
        this.variable = null;
    }

    /**
     * Returns a string representation of the term.
     * If the term represents a constant value, the string is formatted as "Term(value)".
     * If the term represents a variable, the string is formatted as "Term(variable)".
     * If the term represents an expression involving variables and operators,
     * the string is formatted as "Term(Variables: terms, Operator: operator)".
     *
     * @return a string representation of the term
     */
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
