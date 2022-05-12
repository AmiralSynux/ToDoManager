
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20140611 (SVN rev 31)
// Thu May 12 09:16:45 EEST 2022
//----------------------------------------------------

package _parser;

import java_cup.runtime.*;

/** CUP v0.11b 20140611 (SVN rev 31) generated parser.
  * @version Thu May 12 09:16:45 EEST 2022
  */
public class parser extends java_cup.runtime.lr_parser {

  /** Default constructor. */
  public parser() {super();}

  /** Constructor which sets the default scanner. */
  public parser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public parser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\026\000\002\002\004\000\002\002\004\000\002\002" +
    "\003\000\002\005\004\000\002\005\005\000\002\003\004" +
    "\000\002\003\003\000\002\011\003\000\002\011\003\000" +
    "\002\012\004\000\002\012\004\000\002\012\003\000\002" +
    "\012\003\000\002\014\002\000\002\006\006\000\002\007" +
    "\004\000\002\007\003\000\002\010\004\000\002\004\004" +
    "\000\002\004\003\000\002\013\003\000\002\013\003" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\035\000\004\004\006\001\002\000\006\002\uffff\004" +
    "\uffff\001\002\000\006\002\037\004\006\001\002\000\012" +
    "\007\007\011\010\014\013\015\012\001\002\000\006\012" +
    "\034\013\035\001\002\000\020\002\ufffa\004\ufffa\005\ufffa" +
    "\007\ufffa\011\ufffa\014\ufffa\015\ufffa\001\002\000\020\002" +
    "\ufffe\004\ufffe\005\016\007\007\011\010\014\013\015\012" +
    "\001\002\000\020\002\ufff5\004\ufff5\005\ufff5\007\ufff5\011" +
    "\ufff5\014\ufff5\015\ufff5\001\002\000\020\002\ufff6\004\ufff6" +
    "\005\ufff6\007\ufff6\011\ufff6\014\ufff6\015\ufff6\001\002\000" +
    "\020\002\ufffb\004\ufffb\005\ufffb\007\ufffb\011\ufffb\014\ufffb" +
    "\015\ufffb\001\002\000\020\002\ufff9\004\ufff9\005\ufff9\007" +
    "\ufff9\011\ufff9\014\ufff9\015\ufff9\001\002\000\004\004\ufff4" +
    "\001\002\000\006\002\ufffd\004\ufffd\001\002\000\020\002" +
    "\ufffc\004\ufffc\005\ufffc\007\ufffc\011\ufffc\014\ufffc\015\ufffc" +
    "\001\002\000\004\004\023\001\002\000\006\004\023\006" +
    "\032\001\002\000\006\010\026\011\027\001\002\000\006" +
    "\004\ufff1\006\ufff1\001\002\000\012\004\ufff0\006\ufff0\010" +
    "\026\011\027\001\002\000\012\004\uffec\006\uffec\010\uffec" +
    "\011\uffec\001\002\000\012\004\uffed\006\uffed\010\uffed\011" +
    "\uffed\001\002\000\012\004\uffee\006\uffee\010\uffee\011\uffee" +
    "\001\002\000\012\004\uffef\006\uffef\010\uffef\011\uffef\001" +
    "\002\000\006\002\ufff3\004\ufff3\001\002\000\006\004\ufff2" +
    "\006\ufff2\001\002\000\020\002\ufff8\004\ufff8\005\ufff8\007" +
    "\ufff8\011\ufff8\014\ufff8\015\ufff8\001\002\000\020\002\ufff7" +
    "\004\ufff7\005\ufff7\007\ufff7\011\ufff7\014\ufff7\015\ufff7\001" +
    "\002\000\006\002\000\004\000\001\002\000\004\002\001" +
    "\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\035\000\006\002\004\005\003\001\001\000\002\001" +
    "\001\000\004\005\035\001\001\000\010\003\010\011\013" +
    "\012\014\001\001\000\002\001\001\000\002\001\001\000" +
    "\010\006\016\011\017\012\014\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\004\014\020\001\001\000\002\001\001\000\002\001\001" +
    "\000\006\007\021\010\023\001\001\000\004\010\032\001" +
    "\001\000\006\004\024\013\027\001\001\000\002\001\001" +
    "\000\004\013\030\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$parser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$parser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$parser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}

}

/** Cup generated class to encapsulate user supplied action code.*/
class CUP$parser$actions {
  private final parser parser;

  /** Constructor */
  CUP$parser$actions(parser parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$parser$do_action_part00000000(
    int                        CUP$parser$act_num,
    java_cup.runtime.lr_parser CUP$parser$parser,
    java.util.Stack            CUP$parser$stack,
    int                        CUP$parser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$parser$result;

      /* select the action based on the action number */
      switch (CUP$parser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= taskList EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		RESULT = start_val;
              CUP$parser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$parser$parser.done_parsing();
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // taskList ::= taskList task 
            {
              Object RESULT =null;
		MyParser.getBuilder().startBuilding();
              CUP$parser$result = parser.getSymbolFactory().newSymbol("taskList",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // taskList ::= task 
            {
              Object RESULT =null;
		MyParser.getBuilder().startBuilding();
              CUP$parser$result = parser.getSymbolFactory().newSymbol("taskList",0, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // task ::= StartTask description 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("task",3, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // task ::= StartTask description subtaskList 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("task",3, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // description ::= description words 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("description",1, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // description ::= words 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("description",1, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // words ::= Word 
            {
              Object RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int eright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String e = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		MyParser.getBuilder().addDescription(e);
              CUP$parser$result = parser.getSymbolFactory().newSymbol("words",7, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // words ::= repeating 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("words",7, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // repeating ::= RepeatKeyword OneWordRepeat 
            {
              Object RESULT =null;
		int rleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int rright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String r = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		MyParser.getBuilder().repeat(r);
              CUP$parser$result = parser.getSymbolFactory().newSymbol("repeating",8, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // repeating ::= RepeatKeyword RepeatEvery 
            {
              Object RESULT =null;
		int rleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int rright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String r = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		System.out.println("repeat " + r);
              CUP$parser$result = parser.getSymbolFactory().newSymbol("repeating",8, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // repeating ::= StartAt 
            {
              Object RESULT =null;
		int rleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int rright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String r = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		System.out.println(r);
              CUP$parser$result = parser.getSymbolFactory().newSymbol("repeating",8, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // repeating ::= Postpone 
            {
              Object RESULT =null;
		int rleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int rright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String r = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		System.out.println(r);
              CUP$parser$result = parser.getSymbolFactory().newSymbol("repeating",8, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // NT$0 ::= 
            {
              Object RESULT =null;
MyParser.getBuilder().startSubtasks();
              CUP$parser$result = parser.getSymbolFactory().newSymbol("NT$0",10, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // subtaskList ::= StartSubtasks NT$0 subtasks EndSubtasks 
            {
              Object RESULT =null;
              // propagate RESULT from NT$0
                RESULT = (Object) ((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("subtaskList",4, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // subtasks ::= subtasks subtask 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("subtasks",5, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // subtasks ::= subtask 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("subtasks",5, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // subtask ::= StartTask descriptionSubtask 
            {
              Object RESULT =null;
		MyParser.getBuilder().buildSubtask();
              CUP$parser$result = parser.getSymbolFactory().newSymbol("subtask",6, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // descriptionSubtask ::= descriptionSubtask wordsSubtask 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("descriptionSubtask",2, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // descriptionSubtask ::= wordsSubtask 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("descriptionSubtask",2, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // wordsSubtask ::= Word 
            {
              Object RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int eright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String e = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		MyParser.getBuilder().addSubtaskDescription(e);
              CUP$parser$result = parser.getSymbolFactory().newSymbol("wordsSubtask",9, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // wordsSubtask ::= OnlyOnce 
            {
              Object RESULT =null;
		MyParser.getBuilder().onlyOnce();
              CUP$parser$result = parser.getSymbolFactory().newSymbol("wordsSubtask",9, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$parser$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$parser$do_action(
    int                        CUP$parser$act_num,
    java_cup.runtime.lr_parser CUP$parser$parser,
    java.util.Stack            CUP$parser$stack,
    int                        CUP$parser$top)
    throws java.lang.Exception
    {
              return CUP$parser$do_action_part00000000(
                               CUP$parser$act_num,
                               CUP$parser$parser,
                               CUP$parser$stack,
                               CUP$parser$top);
    }
}

