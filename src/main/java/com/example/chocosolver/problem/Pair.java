package com.example.chocosolver.problem;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Pair {
    private int first;
    private int second;

    public Pair (Integer first, Integer second) {
        this(first.intValue(), second.intValue());
    }

    @Override
    public String toString() {
        return "[" + first + ", " + second + "]";
    }
}

