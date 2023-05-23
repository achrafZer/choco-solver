package com.example.chocosolver.problem;
import lombok.Data;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Data
public class Problem {

    //le but de cette classe est que le seul Model créé soit dans la méthode solve

    private HashMap<String, Variable> variables;
    private List<Constraint> constraints;

    public Problem() {
        this.variables = new HashMap<>();
        this.constraints = new ArrayList<Constraint>();
    }

    public void addVariable(String name, int lowerBound, int upperBound) {
        Variable v = new Variable(name, new Pair(lowerBound, upperBound));
        this.variables.put(v.getName(),v);
    }

    public void addVariable(Variable variable) {
        this.variables.put(variable.getName(),variable);
    }

    public void addConstraint(Constraint constraint) {
        this.constraints.add(constraint);
    }
      
} 