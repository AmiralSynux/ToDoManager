package ui;

import javafx.application.Application;
import javafx.stage.Stage;
import ui.components.ScenesHandler;

public class UiMaster extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setScene(ScenesHandler.getMainProgramScene(primaryStage));
        primaryStage.setTitle("ToDo Manager");
        primaryStage.show();
    }
}
