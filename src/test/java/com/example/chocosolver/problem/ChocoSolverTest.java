package com.example.chocosolver.problem;

import static org.mockito.ArgumentMatchers.anyString;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.example.chocosolver.ChocoSolver;

public class ChocoSolverTest {

	@Test
	public void test()
	{
		Variable A=new  Variable("A",new Pair(0,10));
		Variable B=new  Variable("B",new Pair(0,10));
		ArrayList L=new ArrayList();
		Term termA=new Term(A);
		Term termB=new Term(B);
		L.add(termA);
		L.add(termB);
		Term term1=new Term(L,Operator.ADD);
		Term term2=new Term(10);
		Constraint C=new Constraint(term1,term2,Relation.EQUALS);
		
		Problem p=new Problem();
		p.addVariable(A);
		p.addVariable(B);
		p.addConstraint(C);
		
		ChocoSolver cs=new ChocoSolver(p);
		cs.solve();
		
		
	}
	
}
