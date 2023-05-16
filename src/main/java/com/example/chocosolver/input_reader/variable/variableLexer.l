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
    return Symbol.ID;
}

{WS} {
    // Ignore les espaces blancs
}

"dans" {
    System.out.println("Mot-clé : " + yytext());
    return Symbol.DANS;
}

"[" {
    System.out.println("Ouvrir intervalle : " + yytext());
    return Symbol.OPENINTERVAL;
}

"]" {
    System.out.println("Fermer intervalle : " + yytext());
    return Symbol.CLOSEINTERVAL;
}

"{" {
    System.out.println("Ouvrir ensemble : " + yytext());
    return Symbol.OPENSET;
}

"}" {
    System.out.println("Fermer ensemble : " + yytext());
    return Symbol.CLOSESET;
}

"," {
    System.out.println("Séparateur : " + yytext());
    return Symbol.SEPARATOR;
}

{NUMBER} {
    System.out.println("Nombre : " + yytext());
    return Symbol.NUMBER;
}

. {
    System.out.println("Erreur : caractère non reconnu.");
}
