package com.example.chocosolver.problem;

import lombok.Data;

@Data
public class Constraint {

    //exemple: A+B < 10 ==> term1: A+B || term2: 10 || relation: INFERIOR
    private Term term1;
    private Term term2;
    private Relation relation;

    public Constraint(Term term1, Relation relation, Term term2) {
    	 this.term1 = term1;
         this.term2 = term2;
         this.relation = relation;
    }

    
}
