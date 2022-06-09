package _parser;
import java_cup.runtime.*;

%%

%unicode
%cup

nl = " " | \n | \r | \r\n
startTask = "-"
startSubtasks = "{"
endSubtasks = "}"
repeatKeyword = "#repeat"
repeatWord = "daily" | "weekly" | "monthly" | "yearly"
oneWordRepeat = {repeatKeyword}" "{repeatWord}
timestamps = "hours" | "days" | "weeks" | "months" | "years"
number = [0-9]+
repeatEvery = {repeatKeyword}" every "{number}" "{timestamps}
onlyOnce = "#once"
date = [0-9]+"/"[0-9]+"/"[0-9]+ | [0-9]+\\[0-9]+\\[0-9]+ |
[0-9]+-[0-9]+-[0-9]+ | [0-9]+\.[0-9]+\.[0-9]+
startAt = "#start at "{date}
word = [^ \s\n\r]+

%%

{startTask}
    {return new Symbol(sym.StartTask, yytext());}
{startSubtasks}
    {return new Symbol(sym.StartSubtasks, yytext());}
{endSubtasks}
    {return new Symbol(sym.EndSubtasks, yytext());}
{oneWordRepeat}
    {return new Symbol(sym.OneWordRepeat, yytext());}
{repeatEvery}
    {return new Symbol(sym.RepeatEvery, yytext());}
{onlyOnce}
    {return new Symbol(sym.OnlyOnce, yytext());}
{startAt}
    {return new Symbol(sym.StartAt, yytext());}
{word}
    {return new Symbol(sym.Word, yytext());}
{nl}
    {;}
.
    {;}
