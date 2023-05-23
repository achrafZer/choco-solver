package com.example.chocosolver;

import com.example.chocosolver.problem.Constraint;
import com.example.chocosolver.problem.Operator;
import com.example.chocosolver.problem.Pair;
import com.example.chocosolver.problem.Problem;
import com.example.chocosolver.problem.Relation;
import com.example.chocosolver.problem.Term;
import com.example.chocosolver.problem.Variable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solution;
import org.chocosolver.solver.Solver;
import org.chocosolver.solver.expression.discrete.arithmetic.ArExpression;
import org.chocosolver.solver.variables.IntVar;

public class ChocoSolver {

	private Problem problem;
	private Model model;
	private Solver solver;
	private HashMap<String, IntVar> intVars;

	public ChocoSolver(Problem problem) {
		this.problem = problem;
		this.model = new Model();
		this.solver = model.getSolver();
		this.intVars = new HashMap<>();
	}

	private void createVariables() {
		IntVar var = null;
		HashMap<String, Variable> variables = problem.getVariables();

		for (Variable variable : variables.values()) {
			if (variable.getValueInterval() != null) {
				Pair valueInterval = variable.getValueInterval();
				var = model.intVar(variable.getName(), valueInterval.getFirst(), valueInterval.getSecond());
			} else if (variable.getValueSet() != null) {
				List<Integer> valueSet = variable.getValueSet();
				int[] values = new int[valueSet.size()];
				for (int i = 0; i < valueSet.size(); i++) {
					values[i] = valueSet.get(i);
				}
				var = model.intVar(variable.getName(), values);
			}
			intVars.put(variable.getName(), var);
		}
	}

	private ArExpression ResolveTerm(Term term) {


		if (term.getVariable() != null) {
			Variable variable = term.getVariable();

			var v=intVars.get(variable.getName());

			return v;

		} else if (term.getValue() != null) {
			int constantTerm1 = term.getValue();
			return model.intVar(constantTerm1);
		}
		else if(term.getTerms().size()==2){
			var t1=ResolveTerm(term.getTerms().get(0));
			var t2=ResolveTerm(term.getTerms().get(1));
			return t1.add(t2);
		}
		else {
			throw new IllegalStateException("term inconnu");
		}

	}

	private void addConstraints() {

		List<Constraint> constraints = problem.getConstraints();

		for (Constraint constraint : constraints) {
			ArExpression term1 = ResolveTerm(constraint.getTerm1());
			ArExpression term2 = ResolveTerm(constraint.getTerm2());
			Relation relation = constraint.getRelation();

			model.arithm(term1.intVar(),relation.toString(),term2.intVar()).post();

		}

	}

	public Solution solve() {
		// Créer les variables
		createVariables();

		// Ajouter les contraintes
		addConstraints();

		// Résoudre le problème
		Solution solution = model.getSolver().findSolution();
		if (solution != null) {
			System.out.println(solution.toString());
		}
		return solution;
	}

}
//private List<IntVar> ResolveTerm(Term term) {
//	List<IntVar> resolvedTerm;
//	resolvedTerm = new ArrayList<>();
//	if (term.getVariable() != null) {
//		Variable variable = term.getVariable();
//		resolvedTerm.add(intVars.get(variable.getName()));
//	} else if (term.getValue() != null) {
//		int constantTerm1 = term.getValue();
//		resolvedTerm.add(model.intVar(constantTerm1));
//	} else {
//		for (Term t : term.getListvariable()) {
//			if (t.getVariable() != null) {
//				Variable variable = t.getVariable();
//				resolvedTerm.add(intVars.get(variable.getName()));
//			} else if (t.getValue() != null) {
//				int constantTerm1 = t.getValue();
//			}
//		}
//	}
//	return resolvedTerm;
//}