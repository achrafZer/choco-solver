package com.example.chocosolver.problem;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TermTest {

    @Test
    public void testCreateTermWithValue() {
        int value = 4;
        Term term = new Term(value);

        assertEquals(value, term.getValue());
        assertNull(term.getVariable());
        assertNull(term.getListvariable());
        assertNull(term.getOperator());
    }

    @Test
    public void testCreateTermWithVariable() {
        Variable variable = new Variable("A", new Pair(0, 10));
        Term term = new Term(variable);

        assertNull(term.getValue());
        assertEquals(variable, term.getVariable());
        assertNull(term.getListvariable());
        assertNull(term.getOperator());
    }
   
    @Test
    public void testCreateTermWithListAndOperatorDifference() {
        Term term1 = new Term(new Variable("A", Collections.singletonList(1)));
        Term term2 = new Term(new Variable("B", Collections.singletonList(2)));
        Operator operator = Operator.SUM;
        Term term = new Term(Arrays.asList(term1, term2), operator);
        assertNull(term.getValue());
        assertNull(term.getVariable());
        assertEquals(Arrays.asList(term1, term2), term.getListvariable());
        assertEquals(operator, term.getOperator());
    }
    @Test
    public void testCreateTermWithListAndOperatorProduct() {
        Term term1 = new Term(new Variable("A", Collections.singletonList(1)));
        Term term2 = new Term(new Variable("B", Collections.singletonList(2)));
        Operator operator = Operator.PRODUCT;
        Term term = new Term(Arrays.asList(term1, term2), operator);
        assertNull(term.getValue());
        assertNull(term.getVariable());
        assertEquals(Arrays.asList(term1, term2), term.getListvariable());
        assertEquals(operator, term.getOperator());
    }
    @Test
    public void testCreateTermWithListAndOperatorQuotient() {
        Term term1 = new Term(new Variable("A", Collections.singletonList(1)));
        Term term2 = new Term(new Variable("B", Collections.singletonList(2)));
        Operator operator = Operator.QUOTIENT;
        Term term = new Term(Arrays.asList(term1, term2), operator);
        assertNull(term.getValue());
        assertNull(term.getVariable());
        assertEquals(Arrays.asList(term1, term2), term.getListvariable());
        assertEquals(operator, term.getOperator());
    }
    @Test
    public void testCreateTermWithListAndOperatorMax() {
        Term term1 = new Term(new Variable("A", Collections.singletonList(1)));
        Term term2 = new Term(new Variable("B", Collections.singletonList(2)));
        Operator operator = Operator.MAX;
        Term term = new Term(Arrays.asList(term1, term2), operator);
        assertNull(term.getValue());
        assertNull(term.getVariable());
        assertEquals(Arrays.asList(term1, term2), term.getListvariable());
        assertEquals(operator, term.getOperator());
    }
    @Test
    public void testCreateTermWithListAndOperatorMin() {
        Term term1 = new Term(new Variable("A", Collections.singletonList(1)));
        Term term2 = new Term(new Variable("B", Collections.singletonList(2)));
        Operator operator = Operator.MIN;
        Term term = new Term(Arrays.asList(term1, term2), operator);
        assertNull(term.getValue());
        assertNull(term.getVariable());
        assertEquals(Arrays.asList(term1, term2), term.getListvariable());
        assertEquals(operator, term.getOperator());
    }
    @Test
    public void testCreateTermWithListAndOperatorAvg() {
        Term term1 = new Term(new Variable("A", Collections.singletonList(1)));
        Term term2 = new Term(new Variable("B", Collections.singletonList(2)));
        Operator operator = Operator.AVG;
        Term term = new Term(Arrays.asList(term1, term2), operator);
        assertNull(term.getValue());
        assertNull(term.getVariable());
        assertEquals(Arrays.asList(term1, term2), term.getListvariable());
        assertEquals(operator, term.getOperator());
    }
}
