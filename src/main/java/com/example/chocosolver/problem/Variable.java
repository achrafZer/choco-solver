package com.example.chocosolver.problem;

import org.jgrapht.alg.util.Pair;

import java.util.List;

public class Variable {

    private String name;

    public Variable(String name, Pair<Integer, Integer> valueInterval) {
        //TODO crée une variable à partir de l'intervale représentant sa valeur
    }

    public Variable(String name, List<Integer> valueSet) {
        //TODO crée une variable à partir de l'ensemble des valeurs qu'elle peut contenir
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
