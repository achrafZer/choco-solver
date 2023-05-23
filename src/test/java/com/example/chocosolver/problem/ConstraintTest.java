package com.example.chocosolver.problem;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class ConstraintTest {
	
	public Term term1;
	public Term term2;
	
	@BeforeEach
	public void init() {
		term1 = new Term(5);
        term2 = new Term(new Variable("A", new Pair(0, 10)));
	}

    @Test
    public void noArgsConstructorTest() {
        Constraint constraint = new Constraint();
        constraint.setTerm1(new Term(1));
        constraint.setTerm2(new Term(3));
    }

    @Test
    public void testCreateConstraintWithInferior() {
        Relation relation = Relation.INFERIOR;
        Constraint constraint = new Constraint(term1, term2, relation);
        assertEquals(term1, constraint.getTerm1());
        assertEquals(term2, constraint.getTerm2());
        assertEquals(relation, constraint.getRelation());
    }

    @Test
    public void testCreateConstraintWithSuperior() {
       
        Relation relation = Relation.SUPERIOR;
        Constraint constraint = new Constraint(term1, term2, relation);
        assertEquals(term1, constraint.getTerm1());
        assertEquals(term2, constraint.getTerm2());
        assertEquals(relation, constraint.getRelation());
    }

    @Test
    public void testCreateConstraintWithSuperiorOrEqual() {
        Relation relation = Relation.SUPERIORorEQUAL;
        Constraint constraint = new Constraint(term1, term2, relation);
        assertEquals(term1, constraint.getTerm1());
        assertEquals(term2, constraint.getTerm2());
        assertEquals(relation, constraint.getRelation());
    }

    @Test
    public void testCreateConstraintWithInferiorOrEqual() {
        Relation relation = Relation.INFERIORorEQUAL;
        Constraint constraint = new Constraint(term1, term2, relation);
        assertEquals(term1, constraint.getTerm1());
        assertEquals(term2, constraint.getTerm2());
        assertEquals(relation, constraint.getRelation());
    }

    @Test
    public void testCreateConstraintWithEquals() {
        Relation relation = Relation.EQUALS;
        Constraint constraint = new Constraint(term1, term2, relation);
        assertEquals(term1, constraint.getTerm1());
        assertEquals(term2, constraint.getTerm2());
        assertEquals(relation, constraint.getRelation());
    }

    @Test
    public void testCreateConstraintWithDifferent() {
        Relation relation = Relation.DIFFERENT;
        Constraint constraint = new Constraint(term1, term2, relation);
        assertEquals(term1, constraint.getTerm1());
        assertEquals(term2, constraint.getTerm2());
        assertEquals(relation, constraint.getRelation());
    }

    @Test
    public void testOperators() {
        Term term1 = new Term(1);
        Term term2 = new Term(new Variable("A"));
        Term term3 = new Term(term1, Operator.ADD, term2);
        Term term4 = new Term(2);
        Term term5 = new Term(term4, Operator.DIVIDE, term3);
        Term term6 = new Term(new Variable("a"));
        Term term7 = new Term(term5, Operator.AVG, term6);

        assertNotNull(term1);
        assertNotNull(term2);
        assertNotNull(term3);
        assertNotNull(term4);
        assertNotNull(term5);
        assertNotNull(term6);
        assertNotNull(term7);

    }
}
