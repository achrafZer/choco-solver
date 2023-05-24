package com.example.chocosolver;

import java.io.IOException;
import java.util.ArrayList;

import org.chocosolver.solver.Solution;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.chocosolver.problem.Constraint;
import com.example.chocosolver.problem.Operator;
import com.example.chocosolver.problem.Pair;
import com.example.chocosolver.problem.Problem;
import com.example.chocosolver.problem.Relation;
import com.example.chocosolver.problem.Term;
import com.example.chocosolver.problem.Variable;

@Controller
public class MyController {

    @GetMapping("/")
    public String index() {
        return "home";
    }

    @PostMapping("/solve")
    public ModelAndView solveProblem(@RequestParam("problem") String problemText) throws IOException {
		Problem p= new Problem(problemText);

        Solution solution = solve(p);
        ModelAndView modelAndView = new ModelAndView("response");
        modelAndView.addObject("solution", solution);
        modelAndView.addObject("problem", problemText);
        return modelAndView;
    }


    private Solution solve(Problem problem) {
    	ChocoSolver cs=new ChocoSolver(problem);
    	Solution s = cs.solve();
    	return s;
    }
}