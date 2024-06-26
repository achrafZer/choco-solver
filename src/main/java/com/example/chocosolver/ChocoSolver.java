package com.example.chocosolver;

import com.example.chocosolver.problem.Constraint;
import com.example.chocosolver.problem.Pair;
import com.example.chocosolver.problem.Problem;
import com.example.chocosolver.problem.Relation;
import com.example.chocosolver.problem.Term;
import com.example.chocosolver.problem.Variable;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solution;
import org.chocosolver.solver.Solver;
import org.chocosolver.solver.exception.InvalidSolutionException;
import org.chocosolver.solver.expression.discrete.arithmetic.ArExpression;
import org.chocosolver.solver.variables.IntVar;


@Data
public class ChocoSolver {

	private Problem problem;
	private Model model;
	private Solver solver;
	private HashMap<String, IntVar> intVars;
	private Boolean isHigherThan100;
	
	public ChocoSolver(Problem problem) {
		this.problem = problem;
		this.model = new Model();
		this.solver = model.getSolver();
		this.intVars = new HashMap<>();
		this.isHigherThan100=false;
		
	}

	public IntVar getIntVar(String varName) {
		return intVars.get(varName);
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
			} else {
				var = model.intVar(variable.getName(), -999999, 999999);
			}
			intVars.put(variable.getName(), var);
		}
	}

	private ArExpression resolveTerm(Term term) {
		if (term.getVariable() != null) {
			Variable variable = term.getVariable();
			var v = intVars.get(variable.getName());
			return v;

		} else if (term.getValue() != null) {
			int constantTerm1 = term.getValue();
			return model.intVar(constantTerm1);
		} else if (term.getTerms().size() == 2) {
			var t1 = resolveTerm(term.getTerms().get(0));
			var t2 = resolveTerm(term.getTerms().get(1));
			switch (term.getOperator()) {
			case ADD:
				return t1.add(t2);
			case SUBTRACT:
				return t1.sub(t2);
			case MULTIPLY:
				return t1.mul(t2);
			case DIVIDE:
				return t1.div(t2);
			case MAX:
				return t1.max(t2);
			case MIN:
				return t1.min(t2);
			case AVG:
				return t1.min(t2);
			}
		} else {
			ArExpression result = null;
			for (int i = 0; i < term.getTerms().size(); i++) {
				ArExpression currentTerm = resolveTerm(term.getTerms().get(i));
				if (result == null) {
					result = currentTerm;
				} else {

					switch (term.getOperator()) {
					case ADD:
						result = result.add(currentTerm);
					case SUBTRACT:
						result = result.sub(currentTerm);

					case MULTIPLY:
						result = result.mul(currentTerm);
					case DIVIDE:
						result = result.div(currentTerm);
					case MAX:
						result = result.max(currentTerm);
					case MIN:
						result = result.min(currentTerm);
					case AVG:
						result = result.add(currentTerm);
					}
				}
			}
			return result;
		}

		throw new IllegalStateException("term inconnu");

	}

	private void addConstraints() {

		List<Constraint> constraints = problem.getConstraints();
 

		for (Constraint constraint : constraints) {
			 if (constraint.isAllDiff()) {
		            List<String> allDiffVariables = constraint.getAllDiffVariables();
		            IntVar[] list = new IntVar[allDiffVariables.size()];
		            System.out.println(allDiffVariables.size());
		            for (int i = 0; i < allDiffVariables.size(); i++) {
		                list[i] = intVars.get(allDiffVariables.get(i));
		                System.out.println(intVars.get(allDiffVariables.get(i)));
		            }
		            model.allDifferent(list).post();
			} else {
				ArExpression term1 = resolveTerm(constraint.getTerm1());
				ArExpression term2 = resolveTerm(constraint.getTerm2());
				Relation relation = constraint.getRelation();

				switch (relation) {
				case SUPERIOR:
					model.arithm(term1.intVar(), ">", term2.intVar()).post();
					break;
				case SUPERIORorEQUAL:
					model.arithm(term1.intVar(), ">=", term2.intVar()).post();
					break;
				case INFERIOR:
					model.arithm(term1.intVar(), "<", term2.intVar()).post();
					break;
				case INFERIORorEQUAL:
					model.arithm(term1.intVar(), "<=", term2.intVar()).post();
					break;
				case EQUALS:
					model.arithm(term1.intVar(), "=", term2.intVar()).post();
					break;
				case DIFFERENT:
					model.arithm(term1.intVar(), "!=", term2.intVar()).post();
					break;
				}
			}
		}
	}

	public List<HashMap<String, Integer>> solve() {
		// Create the variables
		createVariables();

		// Add the constraints
		addConstraints();

		// Solve the problem
		ArrayList<Solution> solutions = new ArrayList<>();

		
		
		for (int i = 0; i < 101; i++) {
			try {
				Solution solution = model.getSolver().findSolution();
				if(i==100)
				{
					if(solution!=null)
					{
						this.isHigherThan100=true;	
						System.out.println(this.isHigherThan100.toString());
					}
						
				}
				if (solution != null) {
					solutions.add(solution);
				}
				
			} catch (InvalidSolutionException e) {
				continue;
			}
		}

		
		
		List<HashMap<String, Integer>> resultList = new ArrayList<>();

		for (Solution solution : solutions) {
			HashMap<String, Integer> variableMap = new HashMap<>();

			for (IntVar intVar : intVars.values()) {
				int intVarValue = solution.getIntVal(intVar);
				variableMap.put(intVar.getName(), intVarValue);
			}

			resultList.add(variableMap);
		}

		return resultList;
	}

}
