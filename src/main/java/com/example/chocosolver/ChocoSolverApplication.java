package com.example.chocosolver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ChocoSolverApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(ChocoSolverApplication.class, args);
    }

   
    
}
