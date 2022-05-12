package _parser;

import domain.TodoTask;
import java_cup.runtime.Symbol;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class MyParser {
    private static ToDoTaskBuilder builder = null;
    private List<TodoTask> tasks = null;
    private final parser p;
    public MyParser(File file){
        Yylex l = null;
        try {
            l = new Yylex(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("File " + file.getName() + " not found!\n");
        }
        p = new parser(l);
    }
    public void parse() throws Exception {
        builder = new ToDoTaskBuilder();
        Symbol res = p.parse();
        tasks = builder.getTasks();
    }

    static ToDoTaskBuilder getBuilder(){
        return builder;
    }

    public List<TodoTask> getTasks(){
        return tasks;
    }
}
