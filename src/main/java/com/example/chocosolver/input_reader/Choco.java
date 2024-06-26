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
    static final int OPENPAR = 259;
    /** Token number,to be returned by the scanner.  */
    static final int CLOSEPAR = 260;
    /** Token number,to be returned by the scanner.  */
    static final int ALLDIFF = 261;
    /** Token number,to be returned by the scanner.  */
    static final int SUP = 262;
    /** Token number,to be returned by the scanner.  */
    static final int EQUALS = 263;
    /** Token number,to be returned by the scanner.  */
    static final int PLUS = 264;
    /** Token number,to be returned by the scanner.  */
    static final int MOINS = 265;
    /** Token number,to be returned by the scanner.  */
    static final int MUL = 266;
    /** Token number,to be returned by the scanner.  */
    static final int DIV = 267;
    /** Token number,to be returned by the scanner.  */
    static final int ID = 268;
    /** Token number,to be returned by the scanner.  */
    static final int EOI = 269;
    /** Token number,to be returned by the scanner.  */
    static final int OPENINTERVAL = 270;
    /** Token number,to be returned by the scanner.  */
    static final int CLOSEINTERVAL = 271;
    /** Token number,to be returned by the scanner.  */
    static final int OPENSET = 272;
    /** Token number,to be returned by the scanner.  */
    static final int CLOSESET = 273;
    /** Token number,to be returned by the scanner.  */
    static final int SEPARATOR = 274;
    /** Token number,to be returned by the scanner.  */
    static final int NUMBER = 275;
    /** Token number,to be returned by the scanner.  */
    static final int UNKNOWN_TOKEN = 276;
    /** Token number,to be returned by the scanner.  */
    static final int DANS = 277;
    /** Token number,to be returned by the scanner.  */
    static final int EXC = 278;


    

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
    /* "Choco.y":48  */
           {
		yyval = (String) Yylex.id;
	};
  break;
    

  case 7:
  if (yyn == 7)
    /* "Choco.y":54  */
                     {
		yyval = (Integer) yystack.valueAt (0) * -1 ;
	};
  break;
    

  case 8:
  if (yyn == 8)
    /* "Choco.y":59  */
                             {
		Variable variable = new Variable(Yylex.id, (Pair) yystack.valueAt (1));
		problem.addVariable(variable);
    };
  break;
    

  case 9:
  if (yyn == 9)
    /* "Choco.y":63  */
                    {
        Variable variable = new Variable(Yylex.id, set);
        problem.addVariable(variable);
        set = new ArrayList<>();
    };
  break;
    

  case 10:
  if (yyn == 10)
    /* "Choco.y":71  */
                           {
        Constraint constraint = new Constraint();
        constraint.setTerm1((Term) yystack.valueAt (3));
				constraint.setTerm2((Term) yystack.valueAt (1));
				constraint.setRelation((Relation) yystack.valueAt (2));
				problem.addConstraint(constraint);
    };
  break;
    

  case 11:
  if (yyn == 11)
    /* "Choco.y":78  */
                                                      {
        Constraint constraint = new Constraint(tempList);
        tempList = new ArrayList<>();
        problem.addConstraint(constraint);
    };
  break;
    

  case 12:
  if (yyn == 12)
    /* "Choco.y":86  */
                                          {
		tempList.add((String) yystack.valueAt (2));
	};
  break;
    

  case 13:
  if (yyn == 13)
    /* "Choco.y":89  */
           {
		tempList.add((String) yystack.valueAt (0));
	};
  break;
    

  case 14:
  if (yyn == 14)
    /* "Choco.y":96  */
                                                       {
        yyval = new Pair((Integer) yystack.valueAt (3), (Integer) yystack.valueAt (1));
    };
  break;
    

  case 15:
  if (yyn == 15)
    /* "Choco.y":102  */
        {
    	yyval = Relation.INFERIOR;
    };
  break;
    

  case 16:
  if (yyn == 16)
    /* "Choco.y":105  */
        {
    	yyval = Relation.SUPERIOR;
    };
  break;
    

  case 17:
  if (yyn == 17)
    /* "Choco.y":108  */
           {
    	yyval = Relation.EQUALS;
    };
  break;
    

  case 18:
  if (yyn == 18)
    /* "Choco.y":111  */
                  {
        yyval = Relation.INFERIORorEQUAL;
    };
  break;
    

  case 19:
  if (yyn == 19)
    /* "Choco.y":114  */
                  {
        yyval = Relation.SUPERIORorEQUAL;
    };
  break;
    

  case 20:
  if (yyn == 20)
    /* "Choco.y":117  */
               {
        yyval = Relation.DIFFERENT;
    };
  break;
    

  case 23:
  if (yyn == 23)
    /* "Choco.y":131  */
                                          {
        set.add((Integer) yystack.valueAt (2));
    };
  break;
    

  case 24:
  if (yyn == 24)
    /* "Choco.y":137  */
                     {
    	set.add((Integer) yystack.valueAt (0));
    };
  break;
    

  case 25:
  if (yyn == 25)
    /* "Choco.y":140  */
                                   {
        set.add((Integer) yystack.valueAt (1));
    };
  break;
    

  case 26:
  if (yyn == 26)
    /* "Choco.y":146  */
                     {
        yyval = new Term((Term) yystack.valueAt (2), Operator.ADD, (Term) yystack.valueAt (0));
    };
  break;
    

  case 27:
  if (yyn == 27)
    /* "Choco.y":150  */
                      {
        yyval = new Term((Term) yystack.valueAt (2), Operator.SUBTRACT, (Term) yystack.valueAt (0));
    };
  break;
    

  case 28:
  if (yyn == 28)
    /* "Choco.y":154  */
           {
    	yyval = (Term) yystack.valueAt (0);
    };
  break;
    

  case 29:
  if (yyn == 29)
    /* "Choco.y":160  */
                          {
        	yyval = new Term((Term) yystack.valueAt (2), Operator.MULTIPLY, (Term) yystack.valueAt (0));
    	};
  break;
    

  case 30:
  if (yyn == 30)
    /* "Choco.y":163  */
                          {
        	yyval = new Term((Term) yystack.valueAt (2), Operator.DIVIDE, (Term) yystack.valueAt (0));
    	};
  break;
    

  case 31:
  if (yyn == 31)
    /* "Choco.y":166  */
                              {
    		yyval = (Term) yystack.valueAt (1);
    	};
  break;
    

  case 32:
  if (yyn == 32)
    /* "Choco.y":169  */
               {
		yyval = new Term((Integer) yystack.valueAt (0));
	};
  break;
    

  case 33:
  if (yyn == 33)
    /* "Choco.y":172  */
           {
		 yyval = problem.addVariable(Yylex.id);
	};
  break;
    


/* "Choco.java":580  */

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

  private static final byte yypact_ninf_ = -33;
  private static final byte yytable_ninf_ = -1;

  /* YYPACT[STATE-NUM] -- Index in YYTABLE of the portion describing
   STATE-NUM.  */
  private static final byte yypact_[] = yypact_init();
  private static final byte[] yypact_init()
  {
    return new byte[]
    {
      23,    27,     0,    -5,    16,   -33,     1,   -33,   -33,   -33,
       5,     8,   -33,    34,    28,   -33,    15,   -33,    23,    36,
      37,   -33,    38,    27,   -33,   -33,    27,    27,    27,    27,
     -33,   -33,    29,    44,    -4,    -4,    39,    40,   -33,   -33,
     -33,    41,   -33,   -33,    -2,    -2,    28,    42,    31,    32,
     -33,   -33,   -33,   -33,   -33,    -4,    -4,    24,    43,    32,
     -33,   -33,   -33
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
       0,     0,     0,     0,    33,     6,     0,    32,     3,     4,
       0,    28,    33,     0,     0,     7,     0,     1,     2,    15,
      16,    17,     0,     0,    18,    19,     0,     0,     0,     0,
      31,     5,    13,     0,     0,     0,     0,     0,    21,    22,
      20,     0,    26,    27,    29,    30,     0,     0,     0,     0,
       8,     9,    10,    12,    11,     0,     0,     0,     0,    24,
      23,    14,    25
    };
  }

/* YYPGOTO[NTERM-NUM].  */
  private static final byte yypgoto_[] = yypgoto_init();
  private static final byte[] yypgoto_init()
  {
    return new byte[]
    {
     -33,    52,   -33,   -32,   -33,   -33,    11,   -33,   -33,   -33,
     -33,   -33,     2,    -1,     6
    };
  }

/* YYDEFGOTO[NTERM-NUM].  */
  private static final byte yydefgoto_[] = yydefgoto_init();
  private static final byte[] yydefgoto_init()
  {
    return new byte[]
    {
      -1,    18,    32,     7,     8,     9,    33,    36,    23,    24,
      25,    37,    57,    10,    11
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
      13,    17,    48,    49,    14,     1,     3,     2,    19,    28,
      29,     3,    20,    21,     4,    15,     5,    26,    27,    28,
      29,     5,    41,    58,    59,    42,    43,     1,    22,     2,
      34,     1,    35,     3,    44,    45,     4,     3,    16,    30,
      12,    31,    60,     5,    38,    39,    40,     5,    46,    47,
      55,    56,     6,    50,    51,    52,    54,    53,     0,    61,
       0,    62
    };
  }

private static final byte yycheck_[] = yycheck_init();
  private static final byte[] yycheck_init()
  {
    return new byte[]
    {
       1,     0,    34,    35,     4,     4,    10,     6,     3,    11,
      12,    10,     7,     8,    13,    20,    20,     9,    10,    11,
      12,    20,    23,    55,    56,    26,    27,     4,    23,     6,
      15,     4,    17,    10,    28,    29,    13,    10,    22,     5,
      13,    13,    18,    20,     8,     8,     8,    20,    19,     5,
      19,    19,     0,    14,    14,    14,    14,    46,    -1,    16,
      -1,    59
    };
  }

/* YYSTOS[STATE-NUM] -- The (internal number of the) accessing
   symbol of state STATE-NUM.  */
  private static final byte yystos_[] = yystos_init();
  private static final byte[] yystos_init()
  {
    return new byte[]
    {
       0,     4,     6,    10,    13,    20,    25,    27,    28,    29,
      37,    38,    13,    37,     4,    20,    22,     0,    25,     3,
       7,     8,    23,    32,    33,    34,     9,    10,    11,    12,
       5,    13,    26,    30,    15,    17,    31,    35,     8,     8,
       8,    37,    37,    37,    38,    38,    19,     5,    27,    27,
      14,    14,    14,    30,    14,    19,    19,    36,    27,    27,
      18,    16,    36
    };
  }

/* YYR1[YYN] -- Symbol number of symbol that rule YYN derives.  */
  private static final byte yyr1_[] = yyr1_init();
  private static final byte[] yyr1_init()
  {
    return new byte[]
    {
       0,    24,    25,    25,    25,    26,    27,    27,    28,    28,
      29,    29,    30,    30,    31,    32,    32,    32,    32,    32,
      32,    33,    34,    35,    36,    36,    37,    37,    37,    38,
      38,    38,    38,    38
    };
  }

/* YYR2[YYN] -- Number of symbols on the right hand side of rule YYN.  */
  private static final byte yyr2_[] = yyr2_init();
  private static final byte[] yyr2_init()
  {
    return new byte[]
    {
       0,     2,     2,     1,     1,     1,     1,     2,     4,     4,
       4,     5,     3,     1,     5,     1,     1,     1,     1,     1,
       2,     2,     2,     4,     2,     3,     3,     3,     1,     3,
       3,     3,     1,     1
    };
  }


  /* YYTNAME[SYMBOL-NUM] -- String name of the symbol SYMBOL-NUM.
     First, the terminals, then, starting at \a yyntokens_, nonterminals.  */
  private static final String yytname_[] = yytname_init();
  private static final String[] yytname_init()
  {
    return new String[]
    {
  "$end", "error", "$undefined", "INF", "OPENPAR", "CLOSEPAR", "ALLDIFF",
  "SUP", "EQUALS", "PLUS", "MOINS", "MUL", "DIV", "ID", "EOI",
  "OPENINTERVAL", "CLOSEINTERVAL", "OPENSET", "CLOSESET", "SEPARATOR",
  "NUMBER", "UNKNOWN_TOKEN", "DANS", "EXC", "$accept", "prog", "id",
  "number", "variable", "constraint", "variable_for_allDiff", "interval",
  "relation", "inf_or_equals", "sup_or_equals", "set", "sous_ensemble",
  "term", "factor", null
    };
  }



  /* YYTRANSLATE_(TOKEN-NUM) -- Symbol number corresponding to TOKEN-NUM
     as returned by yylex, with out-of-bounds checking.  */
  private static final byte yytranslate_ (int t)
  {
    int user_token_number_max_ = 278;
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
      15,    16,    17,    18,    19,    20,    21,    22,    23
    };
  }


  private static final byte yy_error_token_ = 1;

  private static final int yylast_ = 61;
  private static final int yynnts_ = 15;
  private static final int yyempty_ = -2;
  private static final int yyfinal_ = 17;
  private static final int yyntokens_ = 24;

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
	public static List<String> tempList = new ArrayList<>();

/* "Choco.java":1186  */

}

/* "Choco.y":177  */


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
        problem.setErrorMessage(s + "\nLine " + Yylex.line + ", Column " + Yylex.column );
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
