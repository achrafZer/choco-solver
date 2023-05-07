package mybootapp.model;

import org.chocosolver.solver.Model;
import org.chocosolver.solver.variables.IntVar;
import org.chocosolver.solver.variables.SetVar;
import org.chocosolver.solver.constraints.Constraint;
import java.util.List;

public class ChocoProblem {
    
    private Model model;
    
    public ChocoProblem() {
        model = new Model();
    }
    
    public void addVariable(char name) {
        SetVar var = model.setVar(Character.toString(name));
    }
    
    public void addValues(char name, int[] values) {
        IntVar var = model.intVar(Character.toString(name), values);
    }
    
    public void addValues(char name, int min, int max) {
        IntVar var = model.intVar(Character.toString(name), min, max);
    }
    
    public void addConstraint(Constraint constraint) {
        model.post(constraint);
    }
    
    public void solve() {
        model.getSolver().solve();
        System.out.println(model.getSolver().getSolutionCount() + " solutions found.");
    }
    
}

