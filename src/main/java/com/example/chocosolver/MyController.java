package com.example.chocosolver;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {

    @RequestMapping("/home")
    public ModelAndView hello() {
        ModelAndView modelAndView = new ModelAndView("Home");
        modelAndView.addObject("message", "Hello World!");
        return modelAndView;
    }
}