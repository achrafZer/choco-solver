package com.example.chocosolver.input_reader;

import com.example.chocosolver.problem.Pair;
import com.example.chocosolver.problem.Problem;
import com.example.chocosolver.problem.Term;
import com.example.chocosolver.problem.Variable;
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
    public static String script = " A dans {1, 2};";

    @Test
    public void testVariable() throws IOException {
        testVariableSet();
        testVariableInterval();
    }

    @Test
    public void testVariableSet() throws IOException {
        String script = "A dans {1, 2};";
        var p = Choco.parse(script);
        assertNotNull(p);
        System.out.println(p);
    }

    @Test
    public void testVariableInterval() throws IOException {
        String script = "A dans [1, 2];";
        var p = Choco.parse(script);
        assertNotNull(p);
        System.out.println(p);
    }

    @Test
    public void testConstraintInf1() throws IOException {
        String script = "0 < 1;";
        var p = Choco.parse(script);
        assertNotNull(p);
        assertNotNull(p.getConstraints());
        assertNull(p.getConstraints().get(0).getTerm1().getVariable());
        assertEquals(p.getConstraints().get(0).getTerm2().getValue(), 1);

        System.out.println(p);
    }
}



