package com.example.chocosolver.problem;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Constraint {

    //exemple: A+B < 10 ==> term1: A+B || term2: 10 || relation: INFERIOR
    private Term term1;
    private Term term2;
    private Relation relation;
}
