%%
%class VariableReader
%public
%int
%line
%column

ID = [A-Z][0-9]*
NUMBER = [0-9]+
WS = [ \t\n\r]+

%%

{ID} {
    System.out.println("Variable : " + yytext());
}

{WS} {
    // Ignore les espaces blancs
}

"dans" {
    System.out.println("Mot-clé : " + yytext());
}

"[" + {NUMBER} + "," + {NUMBER} + "]" {
    System.out.println("Intervalle : " + yytext());
}

"{" + {NUMBER} + ("," + {NUMBER})* + "}" {
    System.out.println("Ensemble : " + yytext());
}

"=" {
    System.out.println("Symbole : " + yytext());
}

{NUMBER} {
    System.out.println("Nombre : " + yytext());

}

. {
    System.out.println("Erreur : caractère non reconnu.");
}
