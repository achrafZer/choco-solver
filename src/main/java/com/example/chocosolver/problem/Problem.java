package com.example.chocosolver.problem;

import com.example.chocosolver.ChocoSolver;
import com.example.chocosolver.input_reader.Choco;
import lombok.Data;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.chocosolver.solver.Solution;

/**
 * Represents a problem to be solved using a solver like choco
 */
@Data
public class Problem {

	/**
	 * The variables in the problem sorted by their names.
	 */
	private HashMap<String, Variable> variables;

	/**
	 * The constraints in the problem.
	 */
	private List<Constraint> constraints;

	/**
	 * If a problem is described containing a problem, error = true
	 */
	private boolean error;

	private String errorMessage;

	private boolean isSaved;

	private boolean isHigherThan100;

	/**
	 * Constructs a Problem object.
	 */
	public Problem() {
		this.variables = new HashMap<>();
		this.constraints = new ArrayList<Constraint>();
	}

	public Problem(String script) throws IOException {
		Problem problem = Choco.parse(script);
		this.errorMessage = problem.errorMessage;
		this.variables = problem.getVariables();
		this.constraints = problem.getConstraints();
		this.error = problem.isError();
		this.isSaved = false;
		this.isHigherThan100 = false;
	}

	/**
	 * Adds a variable with the specified name and value interval to the problem.
	 *
	 * @param name       the name of the variable
	 * @param lowerBound the lower bound of the value interval
	 * @param upperBound the upper bound of the value interval
	 */
	public void addVariable(String name, int lowerBound, int upperBound) {
		Variable v = variables.get(name);
		if (v == null) {
			v = new Variable(name, new Pair(lowerBound, upperBound));
		} else {
			variables.get(name).setValueInterval(new Pair(lowerBound, upperBound));
		}
		variables.put(v.getName(), v);
	}

	/**
	 * Adds a variable with the specified name to the problem.
	 *
	 * @param name the name of the variable
	 * @return the Term representing the added variable
	 */
	public Term addVariable(String name) {
		Variable v = variables.get(name);
		if (v == null) {
			v = new Variable(name);
		}
		variables.put(v.getName(), v);
		return new Term(v);
	}

	/**
	 * Adds a variable to the problem.
	 *
	 * @param variable the variable to be added
	 */
	public void addVariable(Variable variable) {
		variables.put(variable.getName(), variable);
	}

	/**
	 * Adds a constraint to the problem.
	 *
	 * @param constraint the constraint to be added
	 */
	public void addConstraint(Constraint constraint) {
		this.constraints.add(constraint);
	}

	/**
	 * Returns the variables in the problem.
	 *
	 * @return the variables in the problem
	 */
	public HashMap<String, Variable> getVariables() {
		return variables;
	}

	public List<HashMap<String, Integer>> solve() {
		ChocoSolver cs = new ChocoSolver(this);
		List<HashMap<String, Integer>> s = cs.solve();
		this.isHigherThan100 = cs.getIsHigherThan100();
		return s;

	}

	public void setErrorMessage(String errorMessage) {
		this.error = true;
		this.constraints = null;
		this.variables = null;
		this.errorMessage = errorMessage;
	}

	public void saveResult(List<HashMap<String, Integer>> solution, String problem, String fileName)
			throws IOException {
		String csvFilePath = "C:\\Users\\Zerho\\OneDrive\\Bureau\\Fac\\S8\\TER\\chocoSolver\\solutions\\" + fileName + ".csv";
		try (CSVPrinter csvPrinter = new CSVPrinter(new FileWriter(csvFilePath), CSVFormat.DEFAULT)) {
			csvPrinter.print("# Problem : ");
			csvPrinter.print(problem);
			csvPrinter.println();
			csvPrinter.print("#S");
			for (String key : solution.get(0).keySet()) {
				csvPrinter.print(key);
			}
			csvPrinter.println();
			int s = 1;
			for (HashMap<String, Integer> rowData : solution) {
				csvPrinter.print(s++);
				for (String key : rowData.keySet()) {
					csvPrinter.print(rowData.get(key));
				}
				csvPrinter.println();
			}

			csvPrinter.flush();
			System.out.println("Solution data saved to CSV file: " + csvFilePath);
		} catch (IOException e) {
			System.err.println("Error saving solution data to CSV file: " + e.getMessage());
		}
	}

}
