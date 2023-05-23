package com.example.chocosolver.problem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;

public class ConstraintTest {
	
	public Term term1;
	public Term term2;
	
	@BeforeEach
	public void init() {
		term1 = new Term(5);
        term2 = new Term(new Variable("A", new Pair(0, 10)));
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
}
