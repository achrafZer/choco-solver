package com.example.chocosolver;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {

    @GetMapping("/")
    public String index() {
        return "home";
    }
    
    @PostMapping("/solve")
    public ModelAndView solveProblem(@RequestParam("problem") String problem) {
        String solution = solve(problem);
        ModelAndView modelAndView = new ModelAndView("response");
        modelAndView.addObject("solution", solution);
        modelAndView.addObject("problem", problem);
        return modelAndView;
    }

    
    private String solve(String problem) {
		return null;
    }
}