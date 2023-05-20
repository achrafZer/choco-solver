package com.example.chocosolver.problem;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class VariableTest {

    @Test
    public void testCreateVariableWithValueInterval() {
        Pair valueInterval = new Pair(0, 10);
        Variable variable = new Variable("A", valueInterval);
        assertEquals("A", variable.getName());
        assertEquals(valueInterval, variable.getValueInterval());
        assertNull(variable.getValueSet());
    }

    @Test
    public void testCreateVariableWithValueSet() {
        List<Integer> valueSet = Arrays.asList(1, 2, 3);
        Variable variable = new Variable("B", valueSet);
        assertEquals("B", variable.getName());
        assertNull(variable.getValueInterval());
        assertEquals(valueSet, variable.getValueSet());
    }
}
