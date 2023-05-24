package com.example.chocosolver.problem;
import com.example.chocosolver.input_reader.Choco;
import lombok.Data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Represents a problem to be solved using a solver like choco
 */
@Data
public class Problem {

    /**
     * The variables in the problem sorted by their names.
     */
    private HashMap<String, Variable> variables;

    /**
     * The constraints in the problem.
     */
    private List<Constraint> constraints;

    /**
     * Constructs a Problem object.
     */
    public Problem() {
        this.variables = new HashMap<>();
        this.constraints = new ArrayList<Constraint>();
    }

    public Problem(String script) throws IOException {
        Problem problem = Choco.parse(script);
        assert problem != null;
        this.variables = problem.getVariables();
        this.constraints = problem.getConstraints();
    }

    /**
     * Adds a variable with the specified name and value interval to the problem.
     *
     * @param name        the name of the variable
     * @param lowerBound  the lower bound of the value interval
     * @param upperBound  the upper bound of the value interval
     */
    public void addVariable(String name, int lowerBound, int upperBound) {
        Variable v = variables.get(name);
        if (v == null) {
            v = new Variable(name, new Pair(lowerBound, upperBound));
        } else {
            variables.get(name).setValueInterval(new Pair(lowerBound, upperBound));
        }
        variables.put(v.getName(),v);
    }

    /**
     * Adds a variable with the specified name to the problem.
     *
     * @param name the name of the variable
     * @return the Term representing the added variable
     */
    public Term addVariable(String name) {
        Variable v = variables.get(name);
        if (v == null) {
            v = new Variable(name);
        }
        variables.put(v.getName(),v);
        return new Term(v);
    }

    /**
     * Adds a variable to the problem.
     *
     * @param variable the variable to be added
     */
    public void addVariable(Variable variable) {
        variables.put(variable.getName(),variable);
    }

    /**
     * Adds a constraint to the problem.
     *
     * @param constraint the constraint to be added
     */
    public void addConstraint(Constraint constraint) {
        this.constraints.add(constraint);
    }

    /**
     * Returns the variables in the problem.
     *
     * @return the variables in the problem
     */
    public HashMap<String, Variable> getVariables() {
        return variables;
    }
}
