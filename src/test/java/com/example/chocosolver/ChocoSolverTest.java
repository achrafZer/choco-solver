package com.example.chocosolver;

import com.example.chocosolver.ChocoSolver;
import com.example.chocosolver.problem.Constraint;
import com.example.chocosolver.problem.Operator;
import com.example.chocosolver.problem.Pair;
import com.example.chocosolver.problem.Problem;
import com.example.chocosolver.problem.Relation;
import com.example.chocosolver.problem.Term;
import com.example.chocosolver.problem.Variable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.chocosolver.solver.Solution;
import org.chocosolver.solver.variables.IntVar;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ChocoSolverTest {
	private Variable A;
	private Variable B;
	private Variable D;
	private Problem problem;
	private ChocoSolver cs;
	private Variable AVide;
	private Variable BVide;


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
		HashMap<String,Integer> solution = cs.solve().get(0);
		assertNotNull(solution);

		
		int aValue = solution.get(A.getName());
		int bValue = solution.get(B.getName());

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
		HashMap<String,Integer> solution = cs.solve().get(0);
		assertNotNull(solution);


		int aValue = solution.get(A.getName());
		int bValue = solution.get(B.getName());

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
		HashMap<String,Integer> solution = cs.solve().get(0);
		assertNotNull(solution);

	
		int aValue = solution.get(A.getName());
		int bValue = solution.get(B.getName());
		int dValue = solution.get(D.getName());
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
		HashMap<String,Integer> solution = cs.solve().get(0);
		assertNotNull(solution);

	
		int aValue = solution.get(A.getName());
		int bValue = solution.get(B.getName());
		int dValue = solution.get(D.getName());
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
		HashMap<String,Integer> solution = cs.solve().get(0);
		assertNotNull(solution);

		
		int aValue = solution.get(A.getName());
		int bValue = solution.get(B.getName());

		assertEquals(10, aValue - bValue);
	}
	@Test
	public void testSolver6() {
		// A = B +1
		Variable AVide=new Variable("AVide");
		Variable BVide=new Variable("BVide");
		
		ArrayList<Term> termList = new ArrayList<>();
		termList.add(new Term(1));
		termList.add(new Term(BVide));
		Term term2 = new Term(termList, Operator.ADD);
		Term term1 = new Term(AVide);
		Constraint C = new Constraint(term1, term2, Relation.EQUALS);

		problem.addVariable(AVide);
		problem.addVariable(BVide);
		problem.addConstraint(C);

		cs = new ChocoSolver(problem);
		HashMap<String,Integer> solution= cs.solve().get(0);
		System.out.print(solution);
		assertNotNull(solution);

	}
	@Test
	public void testSolver7() {
		// A = 150,B=a;
		AVide=new Variable("AVide");
		BVide=new Variable("BVide");
		
		Term term1 = new Term(150);
		Term term2 = new Term(AVide);
		Constraint C = new Constraint(term1, term2, Relation.EQUALS);
		
		Term term3 = new Term(BVide);
		Term term4 = new Term(AVide);
		Constraint E = new Constraint(term3, term4, Relation.EQUALS);

		problem.addVariable(AVide);
		problem.addVariable(BVide);
		problem.addConstraint(E);
		problem.addConstraint(C);

		cs = new ChocoSolver(problem);
		HashMap<String,Integer> solution= cs.solve().get(0);
		System.out.print(solution);
		assertNotNull(solution);

	}
	
	@Test
	public void TestSolver8()
	{
		List<Integer> valueSetA = Arrays.asList(1, 2, 3);
		List<Integer> valueSetB = Arrays.asList(10, 20, 30);
		A=new Variable("A",valueSetA);
		B=new Variable("B",valueSetB);
		ArrayList<Term> termList = new ArrayList<>();
		termList.add(new Term(A));
		termList.add(new Term(10));
		Term term1 = new Term(termList, Operator.MULTIPLY);
		Term term2 = new Term(B);
		Constraint C = new Constraint(term1, term2, Relation.EQUALS);

		problem.addVariable(A);
		problem.addVariable(B);
		problem.addConstraint(C);

		cs = new ChocoSolver(problem);
		HashMap<String,Integer> solution = cs.solve().get(0);
		assertNotNull(solution);
		int aValue = solution.get(A.getName());
		int bValue = solution.get(B.getName());
		assertEquals(10* aValue , bValue);
	}
	@Test
	public void TestSolver9()
	{
		List<Integer> valueSetA = Arrays.asList(1, 2, 3);
		List<Integer> valueSetB = Arrays.asList(10, 20, 30);
		A=new Variable("A",valueSetA);
		B=new Variable("B",valueSetB);
		ArrayList<Term> termList = new ArrayList<>();
		termList.add(new Term(B));
		termList.add(new Term(10));
		Term term1 = new Term(termList, Operator.DIVIDE);
		Term term2 = new Term(A);
		Constraint C = new Constraint(term1, term2, Relation.INFERIORorEQUAL);

		problem.addVariable(A);
		problem.addVariable(B);
		problem.addConstraint(C);

		cs = new ChocoSolver(problem);
		HashMap<String,Integer> solution = cs.solve().get(0);
		assertNotNull(solution);
		int aValue = solution.get(A.getName());
		int bValue = solution.get(B.getName());
		assertEquals(aValue , bValue/10);
	}
	@Test
	public void TestSolver10()
	{
		List<Integer> valueSetA = Arrays.asList(1, 2, 3);
		List<Integer> valueSetB = Arrays.asList(10, 20, 30);
		A=new Variable("A",valueSetA);
		B=new Variable("B",valueSetB);
		ArrayList<Term> termList = new ArrayList<>();
		termList.add(new Term(B));
		termList.add(new Term(10));
		Term term1 = new Term(termList, Operator.MULTIPLY);
		Term term2 = new Term(A);
		Constraint C = new Constraint(term1, term2, Relation.SUPERIORorEQUAL);

		problem.addVariable(A);
		problem.addVariable(B);
		problem.addConstraint(C);

		cs = new ChocoSolver(problem);
		HashMap<String,Integer> solution = cs.solve().get(0);
		assertNotNull(solution);
		int aValue = solution.get(A.getName());
		int bValue = solution.get(B.getName());
		assertEquals(aValue , bValue/10);
	}
	
}
