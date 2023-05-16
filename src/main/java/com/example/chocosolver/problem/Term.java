package com.example.chocosolver.problem;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Term {

    //exemple: A+B ==> variables: {A, B} || operator: PLUS
    //si le terme s'agit d'un nombre simplement, isANumber = True et value contient la valeur du terme, dans ce cas les variables variables et operator n'ont aucun rôle
    private int value;
    private Variable variable;
    private List<Term> Listvariable;
    private Operator operator;


    //term1 = term2      A + B = 4 || donc Term1: A + B  et Term2: 4


    //Term2: 4
    public Term(int value) {
        this.value = value;
    }
  //Term1: A
    public Term(Variable variable)
    {
    	this.variable=variable;
    }
    // A+B
    public Term(List<Term> variables, Operator operator)
    {
    	this.Listvariable=variables;
    	this.operator=operator;
    }
}
