package com.example.chocosolver.problem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a constraint in a problem.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Constraint {

    //exemple: A+B < 10 ==> term1: A+B || term2: 10 || relation: INFERIOR

    /**
     * The first term in the constraint.
     */
    private Term term1;
    
    /**
     * The second term in the constraint.
     */
    private Term term2;

    /**
     * The relation between the two terms.
     */
    private Relation relation;

    private boolean allDiff;

    public Constraint(Term term1, Term term2, Relation relation) {
        this.term1 = term1;
        this.term2 = term2;
        this.relation = relation;
        this.allDiff = false;
    }
}
