package com.example.chocosolver.problem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PairTest {

    @Test
    public void testCreatePair() {
        int first = 5;
        int second = 10;
        Pair pair = new Pair(first, second);
        assertEquals(first, pair.getFirst());
        assertEquals(second, pair.getSecond());
    }
}
