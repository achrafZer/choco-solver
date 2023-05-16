package com.example.chocosolver.problem;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Term {

    //exemple: A+B ==> variables: {A, B} || operator: PLUS
    private ArrayList<Variable> variables;
    private Operator operator;

    //si le terme s'agit d'un nombre simplement, isANumber = True et value contient la valeur du terme, dans ce cas les variables variables et operator n'ont aucun rôle
    private int value;
    private boolean isANumber;

    public Term(ArrayList<Variable> variables, Operator operator) {
        this.variables = variables;
        this.operator = operator;
    }

    public Term(int value) {
        this.isANumber = true;
        this.value = value;
    }

  
}
