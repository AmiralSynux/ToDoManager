package _parser;
import java_cup.runtime.*;

%%

%unicode
%cup

nl		=" "|\n|\r|\r\n
startTask = "-"
startSubtasks = "{"
endSubtasks = "}"
repeatKeyword = "#repeat"
oneWordRepeat = "daily" | "weekly" | "monthly" | "yearly"
timestamps = "hours" | "days" | "weeks" | "months" | "years"
number = [0-9]+
repeatEvery = "every "{number}" "{timestamps}
onlyOnce = "#once"
date = [0-9]+"/"[0-9]+"/"[0-9]+ | [0-9]+\\[0-9]+\\[0-9]+ | [0-9]+-[0-9]+-[0-9]+
startAt = "#start at "{date}
postpone = "#postpone "{number}" "{timestamps}
word = [^ \s\n\r]+

%%

{startTask} {return new Symbol(sym.StartTask, yytext());}
{startSubtasks} {return new Symbol(sym.StartSubtasks, yytext());}
{endSubtasks} {return new Symbol(sym.EndSubtasks, yytext());}
{repeatKeyword} {return new Symbol(sym.RepeatKeyword, yytext());}
{oneWordRepeat} {return new Symbol(sym.OneWordRepeat, yytext());}
{repeatEvery} {return new Symbol(sym.RepeatEvery, yytext());}
{onlyOnce} {return new Symbol(sym.OnlyOnce, yytext());}
{startAt} {return new Symbol(sym.StartAt, yytext());}
{postpone} {return new Symbol(sym.Postpone, yytext());}
{word} {return new Symbol(sym.Word, yytext());}
{nl} {;}
. {System.out.println("Error: " + yytext());}
