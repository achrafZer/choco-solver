package com.example.chocosolver.problem;
import lombok.Data;
import java.util.ArrayList;
import java.util.HashMap;


@Data
public class Problem {

    //le but de cette classe est que le seul Model créé soit dans la méthode solve

    private ArrayList<Variable> variables;
    private ArrayList<Constraint> constraints;

    public Problem() {
        this.variables = new ArrayList<Variable>();
        this.constraints = new ArrayList<Constraint>();
    }

    public void addVariable(String name, int lowerBound, int upperBound) {
        Variable v = new Variable(name, new Pair(lowerBound, upperBound));
    	this.variables.add(v);
    }

    public void addVariable(Variable variable) {
        this.variables.add(variable);
    }

    public void addConstraint(Constraint constraint) {
    	this.constraints.add(constraint);
    }

    public void solve() {

    }

}
