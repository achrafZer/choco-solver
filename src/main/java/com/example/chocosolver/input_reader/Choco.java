/* A Bison parser, made by GNU Bison 3.5.1.  */

/* Skeleton implementation for Bison LALR(1) parsers in Java

   Copyright (C) 2007-2015, 2018-2020 Free Software Foundation, Inc.

   This program is free software: you can redistribute it and/or modify
   it under the terms of the GNU General Public License as published by
   the Free Software Foundation, either version 3 of the License, or
   (at your option) any later version.

   This program is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
   GNU General Public License for more details.

   You should have received a copy of the GNU General Public License
   along with this program.  If not, see <http://www.gnu.org/licenses/>.  */

/* As a special exception, you may create a larger work that contains
   part or all of the Bison parser skeleton and distribute that work
   under terms of your choice, so long as that work isn't itself a
   parser generator using the skeleton or a modified version thereof
   as a parser skeleton.  Alternatively, if you modify or redistribute
   the parser skeleton itself, you may (at your option) remove this
   special exception, which will cause the skeleton and the resulting
   Bison output files to be licensed under the GNU General Public
   License without this special exception.

   This special exception was added by the Free Software Foundation in
   version 2.2 of Bison.  */




/* "%code imports" blocks.  */
/* "Choco.y":6  */

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

/* "Choco.java":51  */

/**
 * A Bison parser, automatically generated from <tt>Choco.y</tt>.
 *
 * @author LALR (1) parser skeleton written by Paolo Bonzini.
 */
public class Choco
{
    /** Version number for the Bison executable that generated this parser.  */
  public static final String bisonVersion = "3.5.1";

  /** Name of the skeleton that generated this parser.  */
  public static final String bisonSkeleton = "lalr1.java";


  /**
   * True if verbose error messages are enabled.
   */
  private boolean yyErrorVerbose = true;

  /**
   * Whether verbose error messages are enabled.
   */
  public final boolean getErrorVerbose() { return yyErrorVerbose; }

  /**
   * Set the verbosity of error messages.
   * @param verbose True to request verbose error messages.
   */
  public final void setErrorVerbose(boolean verbose)
  { yyErrorVerbose = verbose; }






  /**
   * Communication interface between the scanner and the Bison-generated
   * parser <tt>Choco</tt>.
   */
  public interface Lexer {
    /** Token returned by the scanner to signal the end of its input.  */
    public static final int EOF = 0;

/* Tokens.  */
    /** Token number,to be returned by the scanner.  */
    static final int INF = 258;
    /** Token number,to be returned by the scanner.  */
    static final int SUP = 259;
    /** Token number,to be returned by the scanner.  */
    static final int EQUALS = 260;
    /** Token number,to be returned by the scanner.  */
    static final int PLUS = 261;
    /** Token number,to be returned by the scanner.  */
    static final int MOINS = 262;
    /** Token number,to be returned by the scanner.  */
    static final int MUL = 263;
    /** Token number,to be returned by the scanner.  */
    static final int DIV = 264;
    /** Token number,to be returned by the scanner.  */
    static final int ID = 265;
    /** Token number,to be returned by the scanner.  */
    static final int EOI = 266;
    /** Token number,to be returned by the scanner.  */
    static final int OPENINTERVAL = 267;
    /** Token number,to be returned by the scanner.  */
    static final int CLOSEINTERVAL = 268;
    /** Token number,to be returned by the scanner.  */
    static final int OPENSET = 269;
    /** Token number,to be returned by the scanner.  */
    static final int CLOSESET = 270;
    /** Token number,to be returned by the scanner.  */
    static final int SEPARATOR = 271;
    /** Token number,to be returned by the scanner.  */
    static final int NUMBER = 272;
    /** Token number,to be returned by the scanner.  */
    static final int UNKNOWN_TOKEN = 273;
    /** Token number,to be returned by the scanner.  */
    static final int DANS = 274;
    /** Token number,to be returned by the scanner.  */
    static final int EXC = 275;


    

    /**
     * Method to retrieve the semantic value of the last scanned token.
     * @return the semantic value of the last scanned token.
     */
    Object getLVal ();

    /**
     * Entry point for the scanner.  Returns the token identifier corresponding
     * to the next token and prepares to return the semantic value
     * of the token.
     * @return the token identifier corresponding to the next token.
     */
    int yylex () throws java.io.IOException;

    /**
     * Entry point for error reporting.  Emits an error
     * in a user-defined way.
     *
     * 
     * @param msg The string for the error message.
     */
     void yyerror (String msg);
  }

/**
   * The object doing lexical analysis for us.
   */
  private Lexer yylexer;

  



  /**
   * Instantiates the Bison-generated parser.
   * @param yylexer The scanner that will supply tokens to the parser.
   */
  public Choco (Lexer yylexer) 
  {
    
    this.yylexer = yylexer;
    
  }



  /**
   * Print an error message via the lexer.
   *
   * @param msg The error message.
   */
  public final void yyerror (String msg)
  {
    yylexer.yyerror (msg);
  }



  private final class YYStack {
    private int[] stateStack = new int[16];
    
    private Object[] valueStack = new Object[16];

    public int size = 16;
    public int height = -1;

    public final void push (int state, Object value                            ) {
      height++;
      if (size == height)
        {
          int[] newStateStack = new int[size * 2];
          System.arraycopy (stateStack, 0, newStateStack, 0, height);
          stateStack = newStateStack;
          

          Object[] newValueStack = new Object[size * 2];
          System.arraycopy (valueStack, 0, newValueStack, 0, height);
          valueStack = newValueStack;

          size *= 2;
        }

      stateStack[height] = state;
      
      valueStack[height] = value;
    }

    public final void pop () {
      pop (1);
    }

    public final void pop (int num) {
      // Avoid memory leaks... garbage collection is a white lie!
      if (0 < num) {
        java.util.Arrays.fill (valueStack, height - num + 1, height + 1, null);
        
      }
      height -= num;
    }

    public final int stateAt (int i) {
      return stateStack[height - i];
    }

    public final Object valueAt (int i) {
      return valueStack[height - i];
    }

    // Print the state stack on the debug stream.
    public void print (java.io.PrintStream out) {
      out.print ("Stack now");

      for (int i = 0; i <= height; i++)
        {
          out.print (' ');
          out.print (stateStack[i]);
        }
      out.println ();
    }
  }

  /**
   * Returned by a Bison action in order to stop the parsing process and
   * return success (<tt>true</tt>).
   */
  public static final int YYACCEPT = 0;

  /**
   * Returned by a Bison action in order to stop the parsing process and
   * return failure (<tt>false</tt>).
   */
  public static final int YYABORT = 1;



  /**
   * Returned by a Bison action in order to start error recovery without
   * printing an error message.
   */
  public static final int YYERROR = 2;

  /**
   * Internal return codes that are not supported for user semantic
   * actions.
   */
  private static final int YYERRLAB = 3;
  private static final int YYNEWSTATE = 4;
  private static final int YYDEFAULT = 5;
  private static final int YYREDUCE = 6;
  private static final int YYERRLAB1 = 7;
  private static final int YYRETURN = 8;


  private int yyerrstatus_ = 0;


  /**
   * Whether error recovery is being done.  In this state, the parser
   * reads token until it reaches a known state, and then restarts normal
   * operation.
   */
  public final boolean recovering ()
  {
    return yyerrstatus_ == 0;
  }

  /** Compute post-reduction state.
   * @param yystate   the current state
   * @param yysym     the nonterminal to push on the stack
   */
  private int yyLRGotoState (int yystate, int yysym)
  {
    int yyr = yypgoto_[yysym - yyntokens_] + yystate;
    if (0 <= yyr && yyr <= yylast_ && yycheck_[yyr] == yystate)
      return yytable_[yyr];
    else
      return yydefgoto_[yysym - yyntokens_];
  }

  private int yyaction (int yyn, YYStack yystack, int yylen) 
  {
    /* If YYLEN is nonzero, implement the default value of the action:
       '$$ = $1'.  Otherwise, use the top of the stack.

       Otherwise, the following line sets YYVAL to garbage.
       This behavior is undocumented and Bison
       users should not rely upon it.  */
    Object yyval = (0 < yylen) ? yystack.valueAt (yylen - 1) : yystack.valueAt (0);
    

    switch (yyn)
      {
          case 5:
  if (yyn == 5)
    /* "Choco.y":46  */
                             {
		Variable variable = new Variable(Yylex.id, (Pair) yystack.valueAt (1));
		problem.addVariable(variable);
    };
  break;
    

  case 6:
  if (yyn == 6)
    /* "Choco.y":50  */
                    {
        Variable variable = new Variable(Yylex.id, set);
        problem.addVariable(variable);
        set = new ArrayList<>();
    };
  break;
    

  case 7:
  if (yyn == 7)
    /* "Choco.y":58  */
                           {
        Constraint constraint = new Constraint();
        constraint.setTerm1((Term) yystack.valueAt (3));
		constraint.setTerm2((Term) yystack.valueAt (1));
		constraint.setRelation((Relation) yystack.valueAt (2));
		problem.addConstraint(constraint);
    };
  break;
    

  case 8:
  if (yyn == 8)
    /* "Choco.y":68  */
                                                       {
        yyval = new Pair((Integer) yystack.valueAt (3), (Integer) yystack.valueAt (1));
    };
  break;
    

  case 9:
  if (yyn == 9)
    /* "Choco.y":74  */
        {
    	yyval = Relation.INFERIOR;
    };
  break;
    

  case 10:
  if (yyn == 10)
    /* "Choco.y":77  */
        {
    	yyval = Relation.SUPERIOR;
    };
  break;
    

  case 11:
  if (yyn == 11)
    /* "Choco.y":80  */
           {
    	yyval = Relation.EQUALS;
    };
  break;
    

  case 12:
  if (yyn == 12)
    /* "Choco.y":83  */
                  {
        yyval = Relation.INFERIORorEQUAL;
    };
  break;
    

  case 13:
  if (yyn == 13)
    /* "Choco.y":86  */
                  {
        yyval = Relation.SUPERIORorEQUAL;
    };
  break;
    

  case 14:
  if (yyn == 14)
    /* "Choco.y":89  */
               {
        yyval = Relation.DIFFERENT;
    };
  break;
    

  case 17:
  if (yyn == 17)
    /* "Choco.y":103  */
                                          {
        set.add((Integer) yystack.valueAt (2));
    };
  break;
    

  case 18:
  if (yyn == 18)
    /* "Choco.y":109  */
                     {
    	set.add((Integer) yystack.valueAt (0));
    };
  break;
    

  case 19:
  if (yyn == 19)
    /* "Choco.y":112  */
                                   {
        set.add((Integer) yystack.valueAt (1));
    };
  break;
    

  case 20:
  if (yyn == 20)
    /* "Choco.y":118  */
           {
    	yyval = new Term((Integer) yystack.valueAt (0));
    };
  break;
    

  case 21:
  if (yyn == 21)
    /* "Choco.y":121  */
       {
		yyval = problem.addVariable(Yylex.id);
    };
  break;
    

  case 22:
  if (yyn == 22)
    /* "Choco.y":124  */
                        {
    	yyval = new Term((Term) yystack.valueAt (2), (Operator) yystack.valueAt (1), (Term) yystack.valueAt (0));
    };
  break;
    

  case 23:
  if (yyn == 23)
    /* "Choco.y":130  */
         {
    	yyval = Operator.ADD;
    };
  break;
    

  case 24:
  if (yyn == 24)
    /* "Choco.y":133  */
          {
		yyval = Operator.SUBTRACT;
    };
  break;
    

  case 25:
  if (yyn == 25)
    /* "Choco.y":136  */
        {
    	yyval = Operator.MULTIPLY;
    };
  break;
    

  case 26:
  if (yyn == 26)
    /* "Choco.y":139  */
        {
		yyval = Operator.DIVIDE;
    };
  break;
    


/* "Choco.java":518  */

        default: break;
      }

    yystack.pop (yylen);
    yylen = 0;

    /* Shift the result of the reduction.  */
    int yystate = yyLRGotoState (yystack.stateAt (0), yyr1_[yyn]);
    yystack.push (yystate, yyval);
    return YYNEWSTATE;
  }


  /* Return YYSTR after stripping away unnecessary quotes and
     backslashes, so that it's suitable for yyerror.  The heuristic is
     that double-quoting is unnecessary unless the string contains an
     apostrophe, a comma, or backslash (other than backslash-backslash).
     YYSTR is taken from yytname.  */
  private final String yytnamerr_ (String yystr)
  {
    if (yystr.charAt (0) == '"')
      {
        StringBuffer yyr = new StringBuffer ();
        strip_quotes: for (int i = 1; i < yystr.length (); i++)
          switch (yystr.charAt (i))
            {
            case '\'':
            case ',':
              break strip_quotes;

            case '\\':
              if (yystr.charAt(++i) != '\\')
                break strip_quotes;
              /* Fall through.  */
            default:
              yyr.append (yystr.charAt (i));
              break;

            case '"':
              return yyr.toString ();
            }
      }
    else if (yystr.equals ("$end"))
      return "end of input";

    return yystr;
  }




  /**
   * Parse input from the scanner that was specified at object construction
   * time.  Return whether the end of the input was reached successfully.
   *
   * @return <tt>true</tt> if the parsing succeeds.  Note that this does not
   *          imply that there were no syntax errors.
   */
  public boolean parse () throws java.io.IOException

  {
    


    /* Lookahead and lookahead in internal form.  */
    int yychar = yyempty_;
    int yytoken = 0;

    /* State.  */
    int yyn = 0;
    int yylen = 0;
    int yystate = 0;
    YYStack yystack = new YYStack ();
    int label = YYNEWSTATE;

    /* Error handling.  */
    int yynerrs_ = 0;
    

    /* Semantic value of the lookahead.  */
    Object yylval = null;

    yyerrstatus_ = 0;

    /* Initialize the stack.  */
    yystack.push (yystate, yylval );



    for (;;)
      switch (label)
      {
        /* New state.  Unlike in the C/C++ skeletons, the state is already
           pushed when we come here.  */
      case YYNEWSTATE:

        /* Accept?  */
        if (yystate == yyfinal_)
          return true;

        /* Take a decision.  First try without lookahead.  */
        yyn = yypact_[yystate];
        if (yyPactValueIsDefault (yyn))
          {
            label = YYDEFAULT;
            break;
          }

        /* Read a lookahead token.  */
        if (yychar == yyempty_)
          {

            yychar = yylexer.yylex ();
            yylval = yylexer.getLVal ();

          }

        /* Convert token to internal form.  */
        yytoken = yytranslate_ (yychar);

        /* If the proper action on seeing token YYTOKEN is to reduce or to
           detect an error, take that action.  */
        yyn += yytoken;
        if (yyn < 0 || yylast_ < yyn || yycheck_[yyn] != yytoken)
          label = YYDEFAULT;

        /* <= 0 means reduce or error.  */
        else if ((yyn = yytable_[yyn]) <= 0)
          {
            if (yyTableValueIsError (yyn))
              label = YYERRLAB;
            else
              {
                yyn = -yyn;
                label = YYREDUCE;
              }
          }

        else
          {
            /* Shift the lookahead token.  */
            /* Discard the token being shifted.  */
            yychar = yyempty_;

            /* Count tokens shifted since error; after three, turn off error
               status.  */
            if (yyerrstatus_ > 0)
              --yyerrstatus_;

            yystate = yyn;
            yystack.push (yystate, yylval);
            label = YYNEWSTATE;
          }
        break;

      /*-----------------------------------------------------------.
      | yydefault -- do the default action for the current state.  |
      `-----------------------------------------------------------*/
      case YYDEFAULT:
        yyn = yydefact_[yystate];
        if (yyn == 0)
          label = YYERRLAB;
        else
          label = YYREDUCE;
        break;

      /*-----------------------------.
      | yyreduce -- Do a reduction.  |
      `-----------------------------*/
      case YYREDUCE:
        yylen = yyr2_[yyn];
        label = yyaction (yyn, yystack, yylen);
        yystate = yystack.stateAt (0);
        break;

      /*------------------------------------.
      | yyerrlab -- here on detecting error |
      `------------------------------------*/
      case YYERRLAB:
        /* If not already recovering from an error, report this error.  */
        if (yyerrstatus_ == 0)
          {
            ++yynerrs_;
            if (yychar == yyempty_)
              yytoken = yyempty_;
            yyerror (yysyntax_error (yystate, yytoken));
          }

        
        if (yyerrstatus_ == 3)
          {
            /* If just tried and failed to reuse lookahead token after an
               error, discard it.  */

            if (yychar <= Lexer.EOF)
              {
                /* Return failure if at end of input.  */
                if (yychar == Lexer.EOF)
                  return false;
              }
            else
              yychar = yyempty_;
          }

        /* Else will try to reuse lookahead token after shifting the error
           token.  */
        label = YYERRLAB1;
        break;

      /*-------------------------------------------------.
      | errorlab -- error raised explicitly by YYERROR.  |
      `-------------------------------------------------*/
      case YYERROR:
        
        /* Do not reclaim the symbols of the rule which action triggered
           this YYERROR.  */
        yystack.pop (yylen);
        yylen = 0;
        yystate = yystack.stateAt (0);
        label = YYERRLAB1;
        break;

      /*-------------------------------------------------------------.
      | yyerrlab1 -- common code for both syntax error and YYERROR.  |
      `-------------------------------------------------------------*/
      case YYERRLAB1:
        yyerrstatus_ = 3;       /* Each real token shifted decrements this.  */

        for (;;)
          {
            yyn = yypact_[yystate];
            if (!yyPactValueIsDefault (yyn))
              {
                yyn += yy_error_token_;
                if (0 <= yyn && yyn <= yylast_ && yycheck_[yyn] == yy_error_token_)
                  {
                    yyn = yytable_[yyn];
                    if (0 < yyn)
                      break;
                  }
              }

            /* Pop the current state because it cannot handle the
             * error token.  */
            if (yystack.height == 0)
              return false;

            
            yystack.pop ();
            yystate = yystack.stateAt (0);
          }

        if (label == YYABORT)
            /* Leave the switch.  */
            break;



        /* Shift the error token.  */

        yystate = yyn;
        yystack.push (yyn, yylval);
        label = YYNEWSTATE;
        break;

        /* Accept.  */
      case YYACCEPT:
        return true;

        /* Abort.  */
      case YYABORT:
        return false;
      }
}




  // Generate an error message.
  private String yysyntax_error (int yystate, int tok)
  {
    if (yyErrorVerbose)
      {
        /* There are many possibilities here to consider:
           - If this state is a consistent state with a default action,
             then the only way this function was invoked is if the
             default action is an error action.  In that case, don't
             check for expected tokens because there are none.
           - The only way there can be no lookahead present (in tok) is
             if this state is a consistent state with a default action.
             Thus, detecting the absence of a lookahead is sufficient to
             determine that there is no unexpected or expected token to
             report.  In that case, just report a simple "syntax error".
           - Don't assume there isn't a lookahead just because this
             state is a consistent state with a default action.  There
             might have been a previous inconsistent state, consistent
             state with a non-default action, or user semantic action
             that manipulated yychar.  (However, yychar is currently out
             of scope during semantic actions.)
           - Of course, the expected token list depends on states to
             have correct lookahead information, and it depends on the
             parser not to perform extra reductions after fetching a
             lookahead from the scanner and before detecting a syntax
             error.  Thus, state merging (from LALR or IELR) and default
             reductions corrupt the expected token list.  However, the
             list is correct for canonical LR with one exception: it
             will still contain any token that will not be accepted due
             to an error action in a later state.
        */
        if (tok != yyempty_)
          {
            /* FIXME: This method of building the message is not compatible
               with internationalization.  */
            StringBuffer res =
              new StringBuffer ("syntax error, unexpected ");
            res.append (yytnamerr_ (yytname_[tok]));
            int yyn = yypact_[yystate];
            if (!yyPactValueIsDefault (yyn))
              {
                /* Start YYX at -YYN if negative to avoid negative
                   indexes in YYCHECK.  In other words, skip the first
                   -YYN actions for this state because they are default
                   actions.  */
                int yyxbegin = yyn < 0 ? -yyn : 0;
                /* Stay within bounds of both yycheck and yytname.  */
                int yychecklim = yylast_ - yyn + 1;
                int yyxend = yychecklim < yyntokens_ ? yychecklim : yyntokens_;
                int count = 0;
                for (int x = yyxbegin; x < yyxend; ++x)
                  if (yycheck_[x + yyn] == x && x != yy_error_token_
                      && !yyTableValueIsError (yytable_[x + yyn]))
                    ++count;
                if (count < 5)
                  {
                    count = 0;
                    for (int x = yyxbegin; x < yyxend; ++x)
                      if (yycheck_[x + yyn] == x && x != yy_error_token_
                          && !yyTableValueIsError (yytable_[x + yyn]))
                        {
                          res.append (count++ == 0 ? ", expecting " : " or ");
                          res.append (yytnamerr_ (yytname_[x]));
                        }
                  }
              }
            return res.toString ();
          }
      }

    return "syntax error";
  }

  /**
   * Whether the given <code>yypact_</code> value indicates a defaulted state.
   * @param yyvalue   the value to check
   */
  private static boolean yyPactValueIsDefault (int yyvalue)
  {
    return yyvalue == yypact_ninf_;
  }

  /**
   * Whether the given <code>yytable_</code>
   * value indicates a syntax error.
   * @param yyvalue the value to check
   */
  private static boolean yyTableValueIsError (int yyvalue)
  {
    return yyvalue == yytable_ninf_;
  }

  private static final byte yypact_ninf_ = -12;
  private static final byte yytable_ninf_ = -1;

  /* YYPACT[STATE-NUM] -- Index in YYTABLE of the portion describing
   STATE-NUM.  */
  private static final byte yypact_[] = yypact_init();
  private static final byte[] yypact_init()
  {
    return new byte[]
    {
      -1,    -8,   -12,     8,   -12,   -12,    -3,     1,   -12,    -1,
       9,    26,   -12,   -12,   -12,   -12,   -12,    27,     2,   -12,
     -12,     2,     3,    16,    23,    24,   -12,   -12,   -12,   -12,
      15,    21,    20,    22,   -12,   -12,   -12,    25,    28,    29,
      30,    22,   -12,   -12,   -12
    };
  }

/* YYDEFACT[STATE-NUM] -- Default reduction number in state STATE-NUM.
   Performed when YYTABLE does not specify something else to do.  Zero
   means the default is an error.  */
  private static final byte yydefact_[] = yydefact_init();
  private static final byte[] yydefact_init()
  {
    return new byte[]
    {
       0,    21,    20,     0,     3,     4,     0,     0,     1,     2,
       9,    10,    11,    23,    24,    25,    26,     0,     0,    12,
      13,     0,     0,     0,     0,     0,    15,    16,    14,    21,
       0,    22,     0,     0,     5,     6,     7,     0,     0,     0,
       0,    18,    17,     8,    19
    };
  }

/* YYPGOTO[NTERM-NUM].  */
  private static final byte yypgoto_[] = yypgoto_init();
  private static final byte[] yypgoto_init()
  {
    return new byte[]
    {
     -12,    37,   -12,   -12,   -12,   -12,   -12,   -12,   -12,    -2,
     -11,   -12
    };
  }

/* YYDEFGOTO[NTERM-NUM].  */
  private static final byte yydefgoto_[] = yydefgoto_init();
  private static final byte[] yydefgoto_init()
  {
    return new byte[]
    {
      -1,     9,     4,     5,    24,    18,    19,    20,    25,    39,
       6,    21
    };
  }

/* YYTABLE[YYPACT[STATE-NUM]] -- What to do in state STATE-NUM.  If
   positive, shift that token.  If negative, reduce the rule whose
   number is the opposite.  If YYTABLE_NINF, syntax error.  */
  private static final byte yytable_[] = yytable_init();
  private static final byte[] yytable_init()
  {
    return new byte[]
    {
      10,    11,    12,    13,    14,    15,    16,    30,     8,     1,
      31,     7,    29,    22,    26,    23,     2,    17,     1,     2,
      32,    13,    14,    15,    16,     2,    36,    13,    14,    15,
      16,    27,    28,    33,    34,    35,    37,     3,    38,    44,
       0,     0,    40,    43,    42,    41
    };
  }

private static final byte yycheck_[] = yycheck_init();
  private static final byte[] yycheck_init()
  {
    return new byte[]
    {
       3,     4,     5,     6,     7,     8,     9,    18,     0,    10,
      21,    19,    10,    12,     5,    14,    17,    20,    10,    17,
      17,     6,     7,     8,     9,    17,    11,     6,     7,     8,
       9,     5,     5,    17,    11,    11,    16,     0,    16,    41,
      -1,    -1,    17,    13,    15,    17
    };
  }

/* YYSTOS[STATE-NUM] -- The (internal number of the) accessing
   symbol of state STATE-NUM.  */
  private static final byte yystos_[] = yystos_init();
  private static final byte[] yystos_init()
  {
    return new byte[]
    {
       0,    10,    17,    22,    23,    24,    31,    19,     0,    22,
       3,     4,     5,     6,     7,     8,     9,    20,    26,    27,
      28,    32,    12,    14,    25,    29,     5,     5,     5,    10,
      31,    31,    17,    17,    11,    11,    11,    16,    16,    30,
      17,    17,    15,    13,    30
    };
  }

/* YYR1[YYN] -- Symbol number of symbol that rule YYN derives.  */
  private static final byte yyr1_[] = yyr1_init();
  private static final byte[] yyr1_init()
  {
    return new byte[]
    {
       0,    21,    22,    22,    22,    23,    23,    24,    25,    26,
      26,    26,    26,    26,    26,    27,    28,    29,    30,    30,
      31,    31,    31,    32,    32,    32,    32
    };
  }

/* YYR2[YYN] -- Number of symbols on the right hand side of rule YYN.  */
  private static final byte yyr2_[] = yyr2_init();
  private static final byte[] yyr2_init()
  {
    return new byte[]
    {
       0,     2,     2,     1,     1,     4,     4,     4,     5,     1,
       1,     1,     1,     1,     2,     2,     2,     4,     2,     3,
       1,     1,     3,     1,     1,     1,     1
    };
  }


  /* YYTNAME[SYMBOL-NUM] -- String name of the symbol SYMBOL-NUM.
     First, the terminals, then, starting at \a yyntokens_, nonterminals.  */
  private static final String yytname_[] = yytname_init();
  private static final String[] yytname_init()
  {
    return new String[]
    {
  "$end", "error", "$undefined", "INF", "SUP", "EQUALS", "PLUS", "MOINS",
  "MUL", "DIV", "ID", "EOI", "OPENINTERVAL", "CLOSEINTERVAL", "OPENSET",
  "CLOSESET", "SEPARATOR", "NUMBER", "UNKNOWN_TOKEN", "DANS", "EXC",
  "$accept", "prog", "variable", "constraint", "interval", "relation",
  "inf_or_equals", "sup_or_equals", "set", "sous_ensemble", "term",
  "operateur", null
    };
  }



  /* YYTRANSLATE_(TOKEN-NUM) -- Symbol number corresponding to TOKEN-NUM
     as returned by yylex, with out-of-bounds checking.  */
  private static final byte yytranslate_ (int t)
  {
    int user_token_number_max_ = 275;
    byte undef_token_ = 2;

    if (t <= 0)
      return Lexer.EOF;
    else if (t <= user_token_number_max_)
      return yytranslate_table_[t];
    else
      return undef_token_;
  }
  private static final byte yytranslate_table_[] = yytranslate_table_init();
  private static final byte[] yytranslate_table_init()
  {
    return new byte[]
    {
       0,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     1,     2,     3,     4,
       5,     6,     7,     8,     9,    10,    11,    12,    13,    14,
      15,    16,    17,    18,    19,    20
    };
  }


  private static final byte yy_error_token_ = 1;

  private static final int yylast_ = 45;
  private static final int yynnts_ = 12;
  private static final int yyempty_ = -2;
  private static final int yyfinal_ = 8;
  private static final int yyntokens_ = 21;

/* User implementation code.  */
/* Unqualified %code blocks.  */
/* "Choco.y":19  */

	private Problem problem;
	public static Problem parse(String script) throws IOException {
  		InputStream stream = new ByteArrayInputStream(script.getBytes(StandardCharsets.UTF_8));
        ChocoLexer lexer = new ChocoLexer(stream);
		Choco parser = new Choco(lexer);
        parser.problem = new Problem();
        lexer.setProblem(parser.problem);
        parser.parse();
        return parser.problem;
  	}
/* "Choco.y":32  */

	public static List<Integer> set = new ArrayList<>();

/* "Choco.java":1110  */

}

/* "Choco.y":144  */


class ChocoLexer implements Choco.Lexer {
    InputStreamReader it;
    Yylex yylex;
    Object lastTokenValue;
    Problem problem;

    public ChocoLexer(InputStream is){
        it = new InputStreamReader(is);
        yylex = new Yylex(it);
    }

    public void setProblem(Problem problem) {
        this.problem = problem;
    }

    @Override
    public void yyerror (String s){
        System.err.println(s);
        problem.setError(true);
        problem.setErrorMessage(s);
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
