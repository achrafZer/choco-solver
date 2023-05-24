package com.example.chocosolver.input_reader;

import com.example.chocosolver.problem.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

public class TestLexer {

    @Test
    public void testVariableSet() throws IOException {
        String script = "A dans {1, 2};";
        var p = Choco.parse(script);
        assert p != null;
        assertEquals(p.getVariables().get("A").getName(), "A");
        assertNull(p.getVariables().get("A").getValueInterval());
        assertNotNull(p.getVariables().get("A").getValueSet());
        assertTrue(p.getVariables().get("A").getValueSet().contains(1));
        assertTrue(p.getVariables().get("A").getValueSet().contains(2));
    }

    @Test
    public void testVariableInterval() throws IOException {
        String script = "A dans [1, 2];";
        var p = Choco.parse(script);
        assert p != null;
        assertEquals(p.getVariables().get("A").getName(), "A");
        assertNull(p.getVariables().get("A").getValueSet());
        assertNotNull(p.getVariables().get("A").getValueInterval());
        assertEquals(p.getVariables().get("A").getValueInterval().getFirst(), 1);
        assertEquals(p.getVariables().get("A").getValueInterval().getSecond(), 2);
    }

    @Test
    public void testConstraintSup() throws IOException {
        String script = "B + 2 > 1;";
        var p = Choco.parse(script);

        assertNotNull(p);
        assertNotNull(p.getVariables());
        assertNotNull(p.getConstraints());
        assertEquals(p.getConstraints().size(), 1);

        Constraint constraint = p.getConstraints().get(0); //B + 2 > 1
        Term term1 = constraint.getTerm1(); //B + 2
        Term term2 = constraint.getTerm2(); //1
        Relation relation = constraint.getRelation(); //>

        assertEquals(term1.getTerms().get(0).getVariable().getName(), "B");
        assertEquals(term1.getTerms().get(1).getValue(), 2);
        assertEquals(term1.getOperator(), Operator.ADD);

        assertEquals(term2.getValue(), 1);

        assertEquals(relation, Relation.SUPERIOR);

    }

    @Test
    public void testProblem() throws IOException {
        String script = "A dans {1, 2, 3}; B dans [2, 4]; A != 1;";
        var p = Choco.parse(script);
        assertNotNull(p);
        assertEquals(p.getVariables().size(), 2);
        assertTrue(p.getVariables().get("A").getValueSet().contains(3));
        System.out.println(p);
    }

    @Test
    public void testError() throws IOException {
        String script = "A dans {1, 2, 3}";
        var p = Choco.parse(script);

        assertTrue(p.isError());
        assertEquals(p.getErrorMessage(), "syntax error, unexpected end of input, expecting EOI");
        assertNull(p.getVariables());
        assertNull(p.getConstraints());
    }
}



