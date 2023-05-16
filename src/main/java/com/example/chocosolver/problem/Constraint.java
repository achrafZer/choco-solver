package com.example.chocosolver.problem;

import lombok.Data;

@Data
public class Constraint {

    //exemple: A+B < 10 ==> term1: A+B || term2: 10 || relation: INFERIOR
    private final Term term1;
    private final Relation relation;
    private final Term term2;

    public Constraint(Term term1, Relation relation, Term term2) {
    	 this.term1 = term1;
         this.term2 = term2;
         this.relation = relation;
    }

    
}
