package com.example.chocosolver.problem;

import com.example.chocosolver.problem.ChocoProblem;
import org.chocosolver.solver.constraints.Constraint;
import org.chocosolver.solver.constraints.extension.Tuples;
import org.chocosolver.solver.variables.IntVar;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ChocoProblemTest {

    @Test
    public void testChocoProblem() {
        ChocoProblem problem = new ChocoProblem();

        // Add variables
        problem.addVariable("x", 0, 10);
        problem.addVariable("y", 0, 10);
        problem.addVariable("z", 0, 10);

        // Add constraints
        IntVar x = problem.getVariables().get("x");
        IntVar y = problem.getVariables().get("y");
        IntVar z = problem.getVariables().get("z");

        // Constraint 1: x + y = 10
        Constraint c1 = problem.getModel().arithm(x, "+", y, "=", 10);
        problem.addConstraint(c1);

        // Constraint 2: y + z = 15
        Constraint c2 = problem.getModel().arithm(y, "+", z, "=", 15);
        problem.addConstraint(c2);

        // Solve the problem
        HashMap<String, Integer> solution = problem.solve();
        if (solution != null) {
            System.out.println("Solution found:");
            System.out.println("x = " + solution.get("x"));
            System.out.println("y = " + solution.get("y"));
            System.out.println("z = " + solution.get("z"));
        } else {
            System.out.println("No solution found.");
        }

        assertNotNull(problem.solve());
    }
}
