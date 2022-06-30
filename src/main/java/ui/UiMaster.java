package ui;

import domain.validators.TestValidator;
import javafx.application.Application;
import javafx.stage.Stage;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import repository.IRecentFileRepo;
import repository.ITaskListRepo;
import repository.ITodoSubtaskRepo;
import repository.ITodoTaskRepo;
import repository.database.RecentFileRepo;
import repository.database.TaskListRepo;
import repository.database.TodoSubtaskRepo;
import repository.database.TodoTaskRepo;
import service.IService;
import service.Service;
import service.ServiceFactory;
import ui.helper.SceneHelper;

public class UiMaster extends Application {

    private SessionFactory setUp(){
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try {
            return new MetadataSources( registry ).buildMetadata().buildSessionFactory();
        }
        catch (Exception e) {
            // The registry would be destroyed by the SessionFactory, but we had troubles building the SessionFactory
            // so destroy it manually.
            e.printStackTrace();
            System.out.println(e.getMessage());
            StandardServiceRegistryBuilder.destroy( registry );
        }
        throw new RuntimeException("Application couldn't start!");
    }
    @Override
    public void start(Stage primaryStage) {
        System.out.println("Application starting");
        SessionFactory sessionFactory = setUp();
        IRecentFileRepo fileRepo = new RecentFileRepo(sessionFactory,new TestValidator<>());
        ITaskListRepo taskListRepo = new TaskListRepo(sessionFactory,new TestValidator<>());
        ITodoTaskRepo todoTaskRepo = new TodoTaskRepo(sessionFactory,new TestValidator<>());
        ITodoSubtaskRepo todoSubtaskRepo = new TodoSubtaskRepo(sessionFactory,new TestValidator<>());
        IService service = new Service(fileRepo, taskListRepo, todoTaskRepo, todoSubtaskRepo);
        ServiceFactory.setService(service);
        primaryStage.setScene(SceneHelper.getMainProgramScene(primaryStage));
        primaryStage.show();
    }
}
