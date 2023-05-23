package com.example.chocosolver.problem;

public enum Operator {
    SUM("+"),
    DIFFERENCE("-"),
    PRODUCT("*"),
    QUOTIENT("/"),
    MAX("max"),
    MIN("min"),
    AVG("avg");

    private final String sign;

    Operator(String sign) {
        this.sign = sign;
    }

    @Override
    public String toString() {
        return sign;
    }
}
