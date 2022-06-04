package repo.database;

import domain.TodoTask;
import domain.validators.Validator;
import org.hibernate.SessionFactory;
import repo.ITodoTaskRepo;

public class TodoTaskRepo extends BaseDbRepo<Integer, TodoTask> implements ITodoTaskRepo {
    public TodoTaskRepo(SessionFactory sessionFactory, Validator<TodoTask> validator) {
        super(sessionFactory, validator);
    }

    @Override
    protected Class<TodoTask> getClassType() {
        return TodoTask.class;
    }
}
