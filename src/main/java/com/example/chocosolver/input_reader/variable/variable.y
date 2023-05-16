%{
    import java_cup.runtime.*;
%}

%token ID DANS OPENINTERVAL CLOSEINTERVAL OPENSET CLOSESET SEPARATOR NUMBER

%start program

%%

program: /* vide */
       | program declaration
       ;

declaration: ID DANS ensemble
           | ID DANS intervalle
           ;

ensemble: OPENSET liste_nombre CLOSESET
        ;

liste_nombre: NUMBER
           | liste_nombre SEPARATOR NUMBER
           ;

intervalle: OPENINTERVAL NUMBER SEPARATOR NUMBER CLOSEINTERVAL
          ;

%%

public static void main(String[] args) throws Exception {
    parser p = new parser(new VariableReader(new java.io.FileReader(args[0])));
    Object result = p.parse().value;
}
