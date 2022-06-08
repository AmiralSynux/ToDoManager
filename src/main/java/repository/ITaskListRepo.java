package repository;

import domain.TaskList;

public interface ITaskListRepo extends IRepository<Integer, TaskList>{
    TaskList searchTaskList(Integer fileId);
}
