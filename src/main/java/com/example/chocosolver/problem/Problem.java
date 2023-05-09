package com.example.chocosolver.problem;
import org.chocosolver.solver.Model;
import org.chocosolver.solver.variables.IntVar;

import java.util.ArrayList;
import java.util.HashMap;

public class Problem {

    //le but de cette classe est que le seul Model créé soit dans la méthode solve

    private ArrayList<Variable> variables;
    private ArrayList<Constraint> constraints;

    public Problem() {
        this.variables = new ArrayList<Variable>();
        this.constraints = new ArrayList<Constraint>();
    }

    public void addVariable(String name, int lowerBound, int upperBound) {
        //TODO crée la variable à partir de sa valeur
    }

    public void addVariable(Variable variable) {
        //TODO
    }

    public void addConstraint(Constraint constraint) {
        //FIXME
    }

    public HashMap<String, Integer> solve() {
        //TODO crée un model, le remplit puis l'utilise pour résoudre
        return null;
    }

    public ArrayList<Constraint> getConstraints() {
        return constraints;
    }

    public ArrayList<Variable> getVariables() {
        return variables;
    }

    public void setConstraints(ArrayList<Constraint> constraints) {
        this.constraints = constraints;
    }

    public void setVariables(ArrayList<Variable> variables) {
        this.variables = variables;
    }
}
