package com.example.chocosolver.problem;

public enum Relation {
    SUPERIOR(">"),
    SUPERIORorEQUAL(">="),
    INFERIOR("<"),
    INFERIORorEQUAL("<="),
    EQUALS("="),
    DIFFERENT("!=");

    private final String sign;

    Relation(String sign) {
        this.sign = sign;
    }

    @Override
    public String toString() {
        return sign;
    }
}
