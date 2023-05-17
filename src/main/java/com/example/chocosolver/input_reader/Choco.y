%define api.prefix {Choco}
%define api.parser.class {Choco}
%define api.parser.public
%define parse.error verbose

%code imports{
  import java.io.InputStream;
  import java.io.InputStreamReader;
  import java.io.Reader;
  import java.io.IOException;
}

%code {
  public static void main(String args[]) throws IOException {
    ChocoLexer lexer = new ChocoLexer(System.in);
    Choco parser = new Choco(lexer);
    if(parser.parse())
      System.out.println("Parsing Result = SUCCESS");
    return;
  }
}

%token INF SUP EGAL PLUS MOINS MUL DIV ID EOI OPENINTERVAL CLOSEINTERVAL OPENSET CLOSESET SEPARATOR NUMBER UNKNOWN_TOKEN DANS

%%
prog:
  variable
  | contrainte
;

variable   
    : ID DANS interval EOI
    | ID DANS ensemble EOI
;

interval
    : OPENINTERVAL NUMBER SEPARATOR NUMBER CLOSEINTERVAL
;

ensemble
    : OPENSET NUMBER sous_ensemble CLOSESET
;

contrainte
    : term comparateur term EOI
;

term
    : NUMBER
    | ID
    | ID operateur term
;

operateur
    : PLUS
    | MOINS
    | MUL
    | DIV
;

sous_ensemble
    : SEPARATOR NUMBER
    | SEPARATOR NUMBER sous_ensemble
;

comparateur
    : INF
    | SUP
    | EGAL
;

%%

class ChocoLexer implements Choco.Lexer {
  InputStreamReader it;
  Yylex yylex;

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
    return null;
  }

  @Override
  public int yylex () throws IOException{
    return yylex.yylex();
  }
}