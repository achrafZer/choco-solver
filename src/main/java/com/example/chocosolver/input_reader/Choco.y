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
        ChocoLexer lexer = new ChocoLexer(stream);
		Choco parser = new Choco(lexer);
        parser.problem = new Problem();
        if(parser.parse())
            return parser.problem;
        return null;
  	}
}

%code {
	public static List<Integer> set = new ArrayList<>();
}

%token INF SUP EQUALS PLUS MOINS MUL DIV ID EOI OPENINTERVAL CLOSEINTERVAL OPENSET CLOSESET SEPARATOR NUMBER UNKNOWN_TOKEN DANS

%%
prog:
	prog prog |
	variable |
	constraint
;

variable:
	ID DANS interval EOI {
		Variable variable = new Variable(Yylex.id, (Pair) $3);
		problem.addVariable(variable);
    } |
    ID DANS set EOI {
        Variable variable = new Variable(Yylex.id, set);
        problem.addVariable(variable);
        set = new ArrayList<>();
    }
;

constraint:
    term relation term EOI {
        Constraint constraint = new Constraint();
        constraint.setTerm1((Term) $1);
		constraint.setTerm2((Term) $3);
		constraint.setRelation((Relation) $2);
		problem.addConstraint(constraint);
    }
;

interval:
    OPENINTERVAL NUMBER SEPARATOR NUMBER CLOSEINTERVAL {
        $$ = new Pair((Integer) $2, (Integer) $4);
    }
;

relation:
    INF {
    	$$ = Relation.INFERIOR;
    } |
    SUP {
    	$$ = Relation.SUPERIOR;
    } |
    EQUALS {
    	$$ = Relation.EQUALS;
    } |
    inf_or_equals {
        $$ = Relation.INFERIORorEQUAL;
    } |
    sup_or_equals {
        $$ = Relation.SUPERIORorEQUAL;
    }
;

inf_or_equals:
 	INF EQUALS
;

sup_or_equals:
	SUP EQUALS
;



set:
    OPENSET NUMBER sous_ensemble CLOSESET {
        set.add((Integer) $2);
    }
;

sous_ensemble:
    SEPARATOR NUMBER {
    	set.add((Integer) $2);
    } |
    SEPARATOR NUMBER sous_ensemble {
        set.add((Integer) $2);
    }
;

term:
    NUMBER {
    	$$ = new Term((Integer) $1);
    } |
    ID {
		$$ = problem.addVariable(Yylex.id);
    } |
    term operateur term {
    	$$ = new Term((Term) $1, (Operator) $2, (Term) $3);
    }
;

operateur:
    PLUS {
    	$$ = Operator.ADD;
    } |
    MOINS {
		$$ = Operator.SUBTRACT;
    } |
    MUL {
    	$$ = Operator.MULTIPLY;
    } |
    DIV {
		$$ = Operator.DIVIDE;
    }
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