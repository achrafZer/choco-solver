package com.example.chocosolver.problem;

import com.example.chocosolver.ChocoSolver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.chocosolver.solver.Solution;
import org.chocosolver.solver.variables.IntVar;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ChocoSolverTest {
	private Variable A;
	private Variable B;
	private Variable D;
	private Problem problem;
	private ChocoSolver cs;

	@BeforeEach
	public void init() {
		A = new Variable("A", new Pair(0, 100));
		B = new Variable("B", new Pair(0, 100));
		D = new Variable("D", new Pair(0, 100));
		problem = new Problem();
	}

	@Test
	public void testSolver() {
		// A + B = 10
		ArrayList<Term> termList = new ArrayList<>();
		termList.add(new Term(A));
		termList.add(new Term(B));
		Term term1 = new Term(termList, Operator.ADD);
		Term term2 = new Term(10);
		Constraint C = new Constraint(term1, term2, Relation.EQUALS);

		problem.addVariable(A);
		problem.addVariable(B);
		problem.addConstraint(C);

		cs = new ChocoSolver(problem);
		Solution solution = cs.solve();
		assertNotNull(solution);

		IntVar varA = cs.getIntVar(A.getName());
		IntVar varB = cs.getIntVar(B.getName());
		int aValue = solution.getIntVal(varA);
		int bValue = solution.getIntVal(varB);

		assertEquals(10, aValue + bValue);
	}
	

	@Test
	public void testSolver2() {
		// A = B
		Term term1 = new Term(A);
		Term term2 = new Term(B);
		Constraint C = new Constraint(term1, term2, Relation.EQUALS);

		problem.addVariable(A);
		problem.addVariable(B);
		problem.addConstraint(C);

		cs = new ChocoSolver(problem);
		Solution solution = cs.solve();
		assertNotNull(solution);

		IntVar varA = cs.getIntVar(A.getName());
		IntVar varB = cs.getIntVar(B.getName());
		int aValue = solution.getIntVal(varA);
		int bValue = solution.getIntVal(varB);

		assertEquals(aValue, bValue);
	}

	@Test
	public void testSolver3() {
		// A = D+B
		ArrayList<Term> termList = new ArrayList<>();
		termList.add(new Term(D));
		termList.add(new Term(B));
		Term term2 = new Term(termList, Operator.ADD);
		Term term1 = new Term(A);
		Term term3 = new Term(2);
		Constraint C = new Constraint(term1, term2, Relation.INFERIOR);
		Constraint E = new Constraint(term1,term3,Relation.SUPERIORorEQUAL);

		problem.addVariable(A);
		problem.addVariable(B);
		problem.addVariable(D);
		problem.addConstraint(C);
		problem.addConstraint(E);

		cs = new ChocoSolver(problem);
		Solution solution = cs.solve();
		assertNotNull(solution);

		IntVar varA = cs.getIntVar(A.getName());
		IntVar varB = cs.getIntVar(B.getName());
		IntVar varD = cs.getIntVar(D.getName());

		int aValue = solution.getIntVal(varA);
		int bValue = solution.getIntVal(varB);
		int dValue = solution.getIntVal(varD);
		assertTrue(aValue < (dValue+bValue));
		assertTrue(aValue >= 2);
	}
	@Test
	public void testSolver4() {
		// A +B+C= 50
		ArrayList<Term> termList = new ArrayList<>();
		termList.add(new Term(D));
		termList.add(new Term(B));
		termList.add(new Term(A));
		Term term1 = new Term(termList, Operator.MULTIPLY);
		Term term2 = new Term(50);
		
		Constraint C = new Constraint(term1, term2, Relation.INFERIOR);

		problem.addVariable(A);
		problem.addVariable(B);
		problem.addVariable(D);
		problem.addConstraint(C);

		cs = new ChocoSolver(problem);
		Solution solution = cs.solve();
		assertNotNull(solution);

		IntVar varA = cs.getIntVar(A.getName());
		IntVar varB = cs.getIntVar(B.getName());
		IntVar varD = cs.getIntVar(D.getName());

		int aValue = solution.getIntVal(varA);
		int bValue = solution.getIntVal(varB);
		int dValue = solution.getIntVal(varD);
		assertTrue((aValue * dValue * bValue) < 50 );
	}
	
	@Test
	public void testSolver5() {
		// A + B = 10
		ArrayList<Term> termList = new ArrayList<>();
		termList.add(new Term(A));
		termList.add(new Term(B));
		Term term1 = new Term(termList, Operator.SUBTRACT);
		Term term2 = new Term(10);
		Constraint C = new Constraint(term1, term2, Relation.EQUALS);

		problem.addVariable(A);
		problem.addVariable(B);
		problem.addConstraint(C);

		cs = new ChocoSolver(problem);
		Solution solution = cs.solve();
		assertNotNull(solution);

		IntVar varA = cs.getIntVar(A.getName());
		IntVar varB = cs.getIntVar(B.getName());
		int aValue = solution.getIntVal(varA);
		int bValue = solution.getIntVal(varB);

		assertEquals(10, aValue - bValue);
	}
}
