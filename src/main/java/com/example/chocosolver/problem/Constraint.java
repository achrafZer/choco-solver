package com.example.chocosolver.problem;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Constraint {

    //exemple: A+B < 10 ==> term1: A+B || term2: 10 || relation: INFERIOR
    private final Term term1;
    private final Term term2;
    private final Relation relation;
    
}
