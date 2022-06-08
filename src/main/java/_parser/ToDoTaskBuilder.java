package _parser;

import domain.TodoSubtask;
import domain.TodoTask;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

class ToDoTaskBuilder {
    private final List<TodoTask> tasks;

    private TodoTask currentTask;
    private TodoSubtask currentSubtask;

    public ToDoTaskBuilder(){
        tasks = new ArrayList<>();
        currentTask = new TodoTask();
        currentTask.setSubtasks(new ArrayList<>());
    }

    public List<TodoTask> getTasks() {
        return tasks;
    }

    public void startBuilding(){
        if (currentTask != null) {
            tasks.add(currentTask);
        }
        currentTask = new TodoTask();
        currentTask.setSubtasks(new ArrayList<>());
        currentSubtask = null;
    }

    public void addDescription(String str){
        String description = currentTask.getDescription();
        if(description == null || description.equals(""))
            currentTask.setDescription(str);
        else
            currentTask.setDescription(description + " " + str);
    }

    public void startSubtasks(){
        currentSubtask = new TodoSubtask();
    }

    public void buildSubtask(){
        if (currentSubtask != null) {
            currentTask.getSubtasks().add(currentSubtask);
        }
        currentSubtask = new TodoSubtask();
    }

    public void addSubtaskDescription(String str){
        String description = currentSubtask.getDescription();
        if(description == null || description.equals(""))
            currentSubtask.setDescription(str);
        else
            currentSubtask.setDescription(description + " " + str);
    }

    public void onlyOnce(){
        currentSubtask.setShouldRepeat(false);
    }

    public void repeat(String str){
        switch (str) {
            case "daily" -> currentTask.set_interval(Duration.ofDays(1));
            case "weekly" -> currentTask.set_interval(Duration.ofDays(7));
            case "monthly" -> currentTask.set_interval(Duration.ofDays(30));
            case "yearly" -> currentTask.set_interval(Duration.ofDays(364));
        }
    }

    public void repeatEvery(String str){
        String[] words = str.split(" ");
        String number = words[1];
        String timestamp = words[2];
        try{
            long nr = Integer.parseInt(number);
            switch (timestamp) {
                //"hours" | "days" | "weeks" | "months" | "years"
                case "hours" -> currentTask.set_interval(Duration.ofHours(nr));
                case "days" -> currentTask.set_interval(Duration.ofDays(nr));
                case "weeks" -> currentTask.set_interval(Duration.ofDays(nr*7));
                case "months" -> currentTask.set_interval(Duration.ofDays(nr*30));
                case "years" -> currentTask.set_interval(Duration.ofDays(nr*364));
            }
        }catch (Exception e){
            throw new RuntimeException("Can't parse '" + number + "'! Construction: " + str);
        }

    }
}
