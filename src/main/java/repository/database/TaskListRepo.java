package repository.database;

import domain.TaskList;
import domain.validators.Validator;
import org.hibernate.SessionFactory;
import repository.ITaskListRepo;

import java.util.List;

public class TaskListRepo extends BaseDbRepo<Integer, TaskList> implements ITaskListRepo {
    public TaskListRepo(SessionFactory sessionFactory, Validator<TaskList> validator) {
        super(sessionFactory, validator);
    }

    @Override
    protected Class<TaskList> getClassType() {
        return TaskList.class;
    }

    @Override
    public TaskList searchTaskList(Integer fileId) {
         List<TaskList> t = filterMany(session -> session.createQuery("from TaskList as tl where tl.file.id = :id", getClassType())
                 .setParameter("id",fileId)
                 .list());
        if(t.size() == 0)return null;
        return t.get(0);
    }
}
