package com.example.chocosolver;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.example.chocosolver.problem.Problem;

@Controller
public class HomeController {

    private String problemText;

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("problemText", problemText);
        return modelAndView;
    }

    @PostMapping("/solve")
    public ModelAndView solveProblem(@RequestParam("problem") String problemText) throws IOException {
        this.problemText = problemText;
        Problem p = new Problem(problemText);
        ModelAndView modelAndView = new ModelAndView();

        if (p.isError()) {
            modelAndView.setViewName("home");
            modelAndView.addObject("errormessage", p.getErrorMessage());
            modelAndView.addObject("problemText", problemText);
            modelAndView.addObject("error", p.isError());
        } else {
            List<HashMap<String, Integer>> solution = p.solve();
            modelAndView.setViewName("response");
            modelAndView.addObject("solution", solution);
            modelAndView.addObject("problem", formatProblemWithNewLines(problemText));
        }
        return modelAndView;
    }

    private String formatProblemWithNewLines(String problemText) {
        return problemText.replace(";", ";\n").trim();
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception ex) {
    	System.out.println(ex.getMessage());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error");
        modelAndView.addObject("errormessage", "An unexpected error occurred: " + ex.getMessage());
        return modelAndView;
    }
    


}
