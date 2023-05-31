package com.example.chocosolver;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
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
	public String index() {
		return "home";
	}

	@PostMapping("/solve")
	public ModelAndView solveProblem(@RequestParam("problem") String problemText) throws IOException {
		this.problemText = problemText;
		Problem p = new Problem(problemText);
		ModelAndView modelAndView = new ModelAndView();
		List<HashMap<String, Integer>> solution = p.solve();
		if (p.isError()) {
			modelAndView.setViewName("home");
			modelAndView.addObject("errormessage", p.getErrorMessage());
			modelAndView.addObject("problemText", problemText);
			modelAndView.addObject("error", p.isError());
		} 
		else if(p.isJavaError()){
			modelAndView.setViewName("home");
			modelAndView.addObject("errormessage", p.getJavaErrorMessage());
			modelAndView.addObject("problemText", problemText);
			modelAndView.addObject("error", p.isJavaError());
		}
		else {		
			modelAndView.setViewName("response");
			modelAndView.addObject("solution", solution);
			modelAndView.addObject("problem", formatProblemWithNewLines(problemText));
 
		}
		return modelAndView;
	}
	private String formatProblemWithNewLines(String problemText) {
	    return problemText.replace(";", ";\n").trim();
	}
	
}
