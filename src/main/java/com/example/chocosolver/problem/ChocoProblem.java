package com.example.chocosolver.problem;
import org.chocosolver.solver.Model;
import org.chocosolver.solver.variables.IntVar;
import org.chocosolver.solver.constraints.Constraint;

import java.util.ArrayList;
import java.util.HashMap;

public class ChocoProblem {
    private Model model;
    private HashMap<String, IntVar> variables;
    private ArrayList<Constraint> constraints;

    public ChocoProblem() {
        this.model = new Model();
        this.variables = new HashMap<String, IntVar>();
        this.constraints = new ArrayList<Constraint>();
    }

    public void addVariable(String name, int lowerBound, int upperBound) {
        IntVar var = model.intVar(name, lowerBound, upperBound);
        variables.put(name, var);
    }

    public void addConstraint(Constraint constraint) {
        model.post(constraint);
        constraints.add(constraint);
    }

    public HashMap<String, Integer> solve() {
        if (model.getSolver().solve()) {
            HashMap<String, Integer> solution = new HashMap<String, Integer>();
            for (String var : variables.keySet()) {
                solution.put(var, variables.get(var).getValue());
            }
            return solution;
        } else {
            return null;
        }
    }

    public ArrayList<Constraint> getConstraints() {
        return constraints;
    }

    public HashMap<String, IntVar> getVariables() {
        return variables;
    }

    public Model getModel() {
        return model;
    }
}
