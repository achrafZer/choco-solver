package com.example.chocosolver.problem;
import lombok.Data;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Data
public class Problem {

    private HashMap<String, Variable> variables;
    private List<Constraint> constraints;

    public Problem() {
        this.variables = new HashMap<>();
        this.constraints = new ArrayList<Constraint>();
    }

    public void addVariable(String name, int lowerBound, int upperBound) {
        Variable v = variables.get(name);
        if (v == null) {
            v = new Variable(name, new Pair(lowerBound, upperBound));
        } else {
            variables.get(name).setValueInterval(new Pair(lowerBound, upperBound));
        }
        variables.put(v.getName(),v);
    }

    public Term addVariable(String name) {
        Variable v = variables.get(name);
        if (v == null) {
            v = new Variable(name);
        }
        variables.put(v.getName(),v);
        return new Term(v);
    }

    public void addVariable(Variable variable) {
        variables.put(variable.getName(),variable);
    }

    public void addConstraint(Constraint constraint) {
        this.constraints.add(constraint);
    }

    public HashMap<String, Variable> getVariables() {
        return variables;
    }
}
