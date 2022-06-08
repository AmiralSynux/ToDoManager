package service;

import _parser.MyParser;
import domain.RecentFile;
import domain.TaskList;
import domain.TodoSubtask;
import domain.TodoTask;
import repository.IRecentFileRepo;
import repository.ITaskListRepo;
import repository.ITodoSubtaskRepo;
import repository.ITodoTaskRepo;

import java.io.File;
import java.time.LocalDateTime;
import java.util.List;

public class Service implements IService{

    IRecentFileRepo fileRepo;
    ITaskListRepo taskListRepo;
    ITodoTaskRepo todoTaskRepo;
    ITodoSubtaskRepo todoSubtaskRepo;
    public Service(IRecentFileRepo fileRepo,
                   ITaskListRepo taskListRepo,
                   ITodoTaskRepo todoTaskRepo,
                   ITodoSubtaskRepo todoSubtaskRepo){
        this.fileRepo = fileRepo;
        this.taskListRepo = taskListRepo;
        this.todoTaskRepo = todoTaskRepo;
        this.todoSubtaskRepo = todoSubtaskRepo;
    }

    @Override
    public RecentFile addRecentFile(File file) {
        RecentFile recentFile = new RecentFile(file);
        RecentFile searchFile = fileRepo.searchFile(recentFile);
        if(searchFile!=null)
            return searchFile;
        return fileRepo.save(recentFile);
    }

    @Override
    public void removeRecentFile(RecentFile file){
        TaskList taskList = getTaskList(file);
        if(taskList != null)
            taskListRepo.delete(taskList.getId());
        fileRepo.delete(file.getId());
    }

    @Override
    public void updateFile(RecentFile file) {
        fileRepo.update(file);
    }

    @Override
    public List<RecentFile> getFilteredRecentFiles(String text) {
        return fileRepo.getFilteredFilesOrderedByLastOpened(text);
    }

    @Override
    public List<TodoTask> interpret(File file) {
        MyParser parser = new MyParser(file);
        try {
            parser.parse();
        }catch (Exception e){
            throw new RuntimeException("Unable to interpret file!\n" + e.getMessage());
        }
        return parser.getTasks();
    }



    @Override
    public void complete(TodoTask task) {
        task.complete();
        todoTaskRepo.update(task);
    }

    @Override
    public TaskList saveTaskList(TaskList list) {
        return taskListRepo.save(list);
    }

    @Override
    public TaskList getTaskList(RecentFile file) {
        return taskListRepo.searchTaskList(file.getId());
    }

    @Override
    public void refreshTasks(List<TodoTask> tasks) {
        for(TodoTask task : tasks){
            if(task.getStartAt()!= null){
                if(task.getStartAt().isBefore(LocalDateTime.now()))
                    task.setActive(true);
                continue;
            }
            if(!task.shouldRefresh())continue;
            for(TodoSubtask subtask : task.getSubtasks()){
                if (subtask.isShouldRepeat()){
                    subtask.refresh();
                    todoSubtaskRepo.update(subtask);
                }
            }
            task.refresh();
            todoTaskRepo.update(task);
        }
    }

    @Override
    public void removeTasks(List<TodoTask> tasks) {
        for(TodoTask task : tasks)
        {
            for(TodoSubtask subtask : task.getSubtasks())
                todoSubtaskRepo.delete(subtask.getId());
            todoTaskRepo.delete(task.getId());
        }
    }

    @Override
    public void updateTaskList(TaskList taskList) {
        taskListRepo.update(taskList);
    }

    @Override
    public List<RecentFile> getRecentFiles() {
        return fileRepo.getFilesOrderedByLastOpened();
    }


}
