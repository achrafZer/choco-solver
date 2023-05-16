%token ID OPERATOR COMPARATOR NUM

%%

constraint: expression COMPARATOR expression
    ;

expression: expression OPERATOR term
    | term
    ;

term: ID
    | NUM
    ;

%%
