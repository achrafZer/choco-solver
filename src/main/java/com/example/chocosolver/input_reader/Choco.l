package com.example.chocosolver.input_reader;
%%
%public
%standalone

%class Yylex
%{
  public static int yylval;  // Déclaration de yylval
  public static String id;
%}


%line
%column

ID = [A-Z]+
WS = [ \t\n\r]+
NUMBER = ([0-9])+
UNKNOWN_TOKEN = .


%%

<YYINITIAL> {
    {WS}    {}
    {ID}    {
      id = yytext();
      System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]");
      return ChocoLexer.ID;
    }

    "dans" {System.out.println("Mot-clé : " + yytext()); return ChocoLexer.DANS;}


    ";" {System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return ChocoLexer.EOI;}


    {NUMBER} {
        yylval = Integer.valueOf(yytext());
        System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]");
        return ChocoLexer.NUMBER;
    }
    "[" {System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return ChocoLexer.OPENINTERVAL;}
    "]" {System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return ChocoLexer.CLOSEINTERVAL;}
    "," {System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return ChocoLexer.SEPARATOR;}
     "{" {System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return ChocoLexer.OPENSET;}
    "}" {System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return ChocoLexer.CLOSESET;}
      "<" {System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return ChocoLexer.INF;}
    ">" {System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return ChocoLexer.SUP;}
    "=" {System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return ChocoLexer.EQUALS;}
   "+" {System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return ChocoLexer.PLUS;}
    "-" {System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return ChocoLexer.MOINS;}
    "*" {System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return ChocoLexer.MUL;}
    "/" {System.out.println("[token at line " + yyline + ":" + yycolumn + " = \"" + yytext() + "\"]"); return ChocoLexer.DIV;}


    {UNKNOWN_TOKEN} {return ChocoLexer.UNKNOWN_TOKEN;}

}