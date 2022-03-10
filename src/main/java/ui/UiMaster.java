package ui;

import domain.validators.TestValidator;
import javafx.application.Application;
import javafx.stage.Stage;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import repo.IRecentFileRepo;
import repo.IRepository;
import repo.database.RecentFileRepo;
import service.IService;
import service.Service;
import service.ServiceFactory;
import ui.components.ScenesHandler;

public class UiMaster extends Application {
    public static void main(String[] args) {
        launch(args);
    }
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
        IService service = new Service(fileRepo);
        ServiceFactory serviceFactory = new ServiceFactory();
        serviceFactory.setService(service);
        primaryStage.setScene(ScenesHandler.getMainProgramScene(primaryStage));
        primaryStage.setTitle(ScenesHandler.getMainTitle());
        primaryStage.show();
    }
}
