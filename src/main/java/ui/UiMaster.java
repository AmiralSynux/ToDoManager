package ui;

import javafx.application.Application;
import javafx.stage.Stage;
import service.IService;
import service.Service;
import ui.components.ScenesHandler;

public class UiMaster extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        IService service = new Service();
        primaryStage.setScene(ScenesHandler.getMainProgramScene(service, primaryStage));
        primaryStage.setTitle("ToDo Manager");
        primaryStage.show();
    }
}
