package com.example.chocosolver.input_reader;
%%
%public
%standalone

%class Yylex
%{
	public static int yylval;  // Déclaration de yylval
	public static String id;
	public static int line;
	public static int column;
%}


%line
%column

ID = [A-Za-z]+
WS = [ \t\n\r]+
NUMBER = ([0-9])+
UNKNOWN_TOKEN = .


%%

<YYINITIAL> {

	{WS}    {}
    "dans" {
    	System.out.println("Mot-clé : " + yytext());
    	line = yyline;
		column = yycolumn;
		return ChocoLexer.DANS;

    }

    "ALLDIFF" {
		System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]");
		line = yyline;
		column = yycolumn;
		return ChocoLexer.ALLDIFF;
	}

	{ID}    {
		id = yytext();
		System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]");
		line = yyline;
		column = yycolumn;
		return ChocoLexer.ID;
    }

    ";" {
		System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]");
		line = yyline;
		column = yycolumn;
		return ChocoLexer.EOI;
    }

    {NUMBER} {
        yylval = Integer.valueOf(yytext());
        System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]");
        line = yyline;
		column = yycolumn;
        return ChocoLexer.NUMBER;
    }

	"[" {
		System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]");
		line = yyline;
		column = yycolumn;
		return ChocoLexer.OPENINTERVAL;
	}

    "]" {
		System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]");
		line = yyline;
		column = yycolumn;
		return ChocoLexer.CLOSEINTERVAL;
    }

    "," {
    	System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]");
    	line = yyline;
		column = yycolumn;
    	return ChocoLexer.SEPARATOR;
	}

     "{" {
     	System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]");
     	line = yyline;
		column = yycolumn;
     	return ChocoLexer.OPENSET;
	}

    "}" {
    	System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]");
    	line = yyline;
		column = yycolumn;
    	return ChocoLexer.CLOSESET;
	}

    "<" {
    	System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]");
    	line = yyline;
		column = yycolumn;
    	return ChocoLexer.INF;
	}

    ">" {
    	System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]");
    	line = yyline;
		column = yycolumn;
    	return ChocoLexer.SUP;
	}

    "=" {
    	System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]");
    	line = yyline;
		column = yycolumn;
    	return ChocoLexer.EQUALS;
	}

	"+" {
   		System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]");
   		line = yyline;
		column = yycolumn;
   		return ChocoLexer.PLUS;
	}

    "-" {
    	System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]");
    	line = yyline;
		column = yycolumn;
    	return ChocoLexer.MOINS;
	}

	"*" {
    	System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]");
    	line = yyline;
		column = yycolumn;
    	return ChocoLexer.MUL;
	}

    "/" {
		System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]");
		line = yyline;
		column = yycolumn;
		return ChocoLexer.DIV;
    }

    "!" {
    	System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]");
    	line = yyline;
		column = yycolumn;
    	return ChocoLexer.EXC;
	}

    "(" {
    	System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]");
    	line = yyline;
		column = yycolumn;
    	return ChocoLexer.OPENPAR;
	}

    ")" {
    	System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]");
    	line = yyline;
		column = yycolumn;
    	return ChocoLexer.CLOSEPAR;
	}

    {UNKNOWN_TOKEN} {
		line = yyline;
		column = yycolumn;
    	return ChocoLexer.UNKNOWN_TOKEN;
	}

}