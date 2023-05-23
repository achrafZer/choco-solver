package com.example.chocosolver;



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
    public ModelAndView solveProblem(@RequestParam("problem") String problemText) {
    	// nous créons le problème
    	Problem p= new Problem(); 
    	
    	
    	Variable A=new  Variable("A",new Pair(0,10));
		Variable B=new  Variable("B",new Pair(0,10));
		ArrayList L=new ArrayList();
		Term termA=new Term(A);
		Term termB=new Term(B);
		L.add(termB);
		L.add(termA);
		Term term1=new Term(L,Operator.SUM);
		Term term2=new Term(10);
		Constraint C=new Constraint(term1,term2,Relation.EQUALS);
		
		
		p.addVariable(A);
		p.addVariable(B);
		p.addConstraint(C);
		
		
    	///nous analysons le string ProblemText et on retire les variable et constraint
    	// nous ajoutons les variable et constraints
    	// on utlise solve pour avoir le resultat
        Solution solution = solve(p);
        ModelAndView modelAndView = new ModelAndView("response");
        modelAndView.addObject("solution", solution);
        modelAndView.addObject("problem", problemText);
        return modelAndView;
    }

    
    private Solution solve(Problem problem) {
    	ChocoSolver cs=new ChocoSolver(problem);
    	Solution s=cs.solve();
    	return s;
    }
}