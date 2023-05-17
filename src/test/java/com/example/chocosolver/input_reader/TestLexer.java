package com.example.chocosolver.input_reader;

import java.io.IOException;
import java.io.StringReader;

public class TestLexer {
    public static String script = "A + B < 10 ";


    public static void main(String args[]) throws IOException {
        ChocoLexer lexer = new ChocoLexer(TestLexer.script);
        Choco parser = new Choco(lexer);
        if(parser.parse())
            System.out.println("Parsing Result = SUCCESS");
        return;
    }
}
