package com.example.chocosolver.problem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProblemTest {

    private Problem problem;

    @BeforeEach
    public void setUp() {
        problem = new Problem();
    }

    @Test
    public void testAddUndefinedVariableWithBounds() {
        problem.addVariable("variable1", 0, 10);
        assertEquals(1, problem.getVariables().size());
        assertTrue(problem.getVariables().containsKey("variable1"));
    }
    
    @Test
    public void testAddVariableWithBounds() {
        problem.addVariable("variable1", 0, 10);
        assertEquals(1, problem.getVariables().size());
        assertTrue(problem.getVariables().containsKey("variable1"));

        Variable variable1 = problem.getVariables().get("variable1");
        assertEquals(0, variable1.getValueInterval().getFirst());
        assertEquals(10, variable1.getValueInterval().getSecond());
    }

    @Test
    public void testAddVariableWithValueSet() {
    	Variable valueSet=new Variable("variable2",Arrays.asList(1, 2, 3));
        problem.addVariable(valueSet);
        assertEquals(1, problem.getVariables().size());
        assertTrue(problem.getVariables().containsKey("variable2"));
        Variable variable2 = problem.getVariables().get("variable2");
        assertEquals(Arrays.asList(1, 2, 3), variable2.getValueSet());
    }
    

    @Test
    public void testAddConstraint() {
        Variable variable1 = new Variable("A", Arrays.asList(1, 2, 3));
        Variable variable2 = new Variable("B", new Pair(0, 10));
        Term term1 = new Term(variable1);
        Term term2 = new Term(variable2);
        Constraint constraint = new Constraint(term1, term2, Relation.INFERIOR);
        problem.addConstraint(constraint);
        assertEquals(1, problem.getConstraints().size());
        assertTrue(problem.getConstraints().contains(constraint));
    }


}
