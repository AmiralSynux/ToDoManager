package repo;

import domain.RecentFile;
import domain.TaskList;

public interface ITaskListRepo extends IRepository<Integer, TaskList>{
    TaskList searchTaskList(Integer fileId);
}
