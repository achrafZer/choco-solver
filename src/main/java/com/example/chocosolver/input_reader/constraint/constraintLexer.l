%%
%class ConstraintLexer
%public
%int
%line
%column

ID = [A-Z][0-9]*
OPERATOR = [+\-*/]
COMPARATOR = [><=]
WS = [\t\n\r]+

%%

{ID} {
    System.out.println("Variable : " + yytext());
}

{WS} {
    // Ignore les espaces blancs
}

{OPERATOR} {
    System.out.println("Opérateur : " + yytext());
}

{COMPARATOR} {
    System.out.println("Comparateur : " + yytext());
}

. {
    System.out.println("Erreur : caractère non reconnu.");
}
