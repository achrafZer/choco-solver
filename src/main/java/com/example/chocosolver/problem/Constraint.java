package com.example.chocosolver.problem;

public class Constraint {

    //exemple: A+B < 10 ==> term1: A+B || term2: 10 || relation: INFERIOR
    private Term term1;
    private Term term2;
    private Relation relation;

    public Constraint(Term term1, Relation relation, Term term2) {
        //TODO
    }

    public Relation getRelation() {
        return relation;
    }

    public Term getTerm1() {
        return term1;
    }

    public Term getTerm2() {
        return term2;
    }

    public void setRelation(Relation relation) {
        this.relation = relation;
    }

    public void setTerm1(Term term1) {
        this.term1 = term1;
    }

    public void setTerm2(Term term2) {
        this.term2 = term2;
    }
}