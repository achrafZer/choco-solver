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
}
