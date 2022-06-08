package repository.database;

import domain.TodoSubtask;
import domain.validators.Validator;
import org.hibernate.SessionFactory;
import repository.ITodoSubtaskRepo;

public class TodoSubtaskRepo extends BaseDbRepo<Integer, TodoSubtask> implements ITodoSubtaskRepo {
    public TodoSubtaskRepo(SessionFactory sessionFactory, Validator<TodoSubtask> validator) {
        super(sessionFactory, validator);
    }

    @Override
    protected Class<TodoSubtask> getClassType() {
        return TodoSubtask.class;
    }

}
