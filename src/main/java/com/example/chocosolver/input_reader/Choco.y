%define api.prefix {Choco}
%define api.parser.class {Choco}
%define api.parser.public
%define parse.error verbose

%code imports{
	package com.example.chocosolver.input_reader;
	import java.io.InputStream;
  	import java.io.InputStreamReader;
  	import java.io.Reader;
  	import java.io.IOException;
  	import java.util.ArrayList;
  	import java.util.List;
  	import com.example.chocosolver.problem.*;
  	import java.io.ByteArrayInputStream;
	import java.nio.charset.StandardCharsets;
}

%code {
	private Problem problem;
	public static Problem parse(String script) throws IOException {
  		InputStream stream = new ByteArrayInputStream(script.getBytes(StandardCharsets.UTF_8));
        	ChocoLexer lexer = new ChocoLexer(stream);    Choco parser = new Choco(lexer);
        	parser.problem = new Problem();
    		if(parser.parse())
      			return parser.problem;
    		return null;
  	}
}

%code {
	public static List<Integer> ensemble = new ArrayList<>();
  	public static Pair interval;
  	public static Term term1;
	public static Term term2;
	public static Relation relation;

}

%token INF SUP EGAL PLUS MOINS MUL DIV ID EOI OPENINTERVAL CLOSEINTERVAL OPENSET CLOSESET SEPARATOR NUMBER UNKNOWN_TOKEN DANS

%%
prog:
    prog
  |  variable
  | contrainte
;

variable:
    ID DANS interval EOI {
	Variable variable = new Variable(Yylex.id, interval);
        problem.addVariable(variable);
    }|
    ID DANS ensemble EOI {
        Variable variable = new Variable(Yylex.id, ensemble);
        problem.addVariable(variable);
	}
;

contrainte:
    term comparateur term EOI {
        Constraint constraint = new Constraint();
        constraint.setTerm1(term1);
	constraint.setTerm2(term2);
	constraint.setRelation(relation);
	problem.addConstraint(constraint);
    }
;

interval:
    OPENINTERVAL NUMBER SEPARATOR NUMBER CLOSEINTERVAL {
        interval = new Pair((Integer) $2, (Integer) $4);
    }
;

comparateur:
    INF {
    	relation = Relation.INFERIOR;
    }|
    SUP {
    	relation = Relation.SUPERIOR;
    }|
    EGAL {
    	relation = Relation.EQUALS;
    }
;

ensemble:
    OPENSET NUMBER sous_ensemble CLOSESET {
        ensemble.add((Integer) $2);
    }
;

sous_ensemble:
    SEPARATOR NUMBER {
    	ensemble.add((Integer) $2);
    }|
    SEPARATOR NUMBER sous_ensemble {
        ensemble.add((Integer) $2);
    }
;

term:
    NUMBER {
	if (term1 == null) {
		term1 = new Term((Integer) $1);
	} else {
    		term2 = new Term((Integer) $1);
	}
    }|
    ID {
	if (term1 == null) {
		term1 = new Term(Problem.variables.get(Yylex.id));
	} else {
		term2 = new Term(Problem.variables.get(Yylex.id));
	}
    }|
    ID operateur term {
    }|
    term operateur ID
;

operateur:
    PLUS|
    MOINS|
    MUL|
    DIV
;



%%

class ChocoLexer implements Choco.Lexer {
    InputStreamReader it;
    Yylex yylex;
    Object lastTokenValue;

    public ChocoLexer(InputStream is){
        it = new InputStreamReader(is);
        yylex = new Yylex(it);
    }

    @Override
    public void yyerror (String s){
        System.err.println(s);
    }

    @Override
    public Object getLVal() {
        return lastTokenValue;
    }

    @Override
    public int yylex () throws IOException{
        int tokenType = yylex.yylex();
        lastTokenValue = Yylex.yylval;
        return tokenType;
    }
}