package service;

import domain.RecentFile;
import domain.TaskList;
import domain.TodoTask;

import java.io.File;
import java.util.List;

public interface IService {
    RecentFile addRecentFile(File file);
    List<RecentFile> getRecentFiles();
    void removeRecentFile(RecentFile file);
    void updateFile(RecentFile file);
    List<RecentFile> getFilteredRecentFiles(String text);

    List<TodoTask> interpret(File file);

    void complete(TaskList taskList);

    TaskList saveTaskList(TaskList list);

    TaskList getTaskList(RecentFile file);
}
