package ui.components;

import domain.RecentFile;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import service.IService;
import ui.controllers.EditorController;
import ui.controllers.MainProgramController;
import ui.controllers.RenameFileController;

import java.io.File;

public class ScenesHandler {
    public static Scene getMainProgramScene(Stage stage) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ScenesHandler.class.getResource("/views/MainProgramView.fxml"));
            Pane layout = loader.load();
            Scene scene = new Scene(layout);
            MainProgramController controller = loader.getController();
            controller.init(stage);
            return scene;
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new RuntimeException("Error while loading scene!");
        }
    }

    public static Scene getEditorScene(RecentFile file, Stage stage){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ScenesHandler.class.getResource("/views/EditorView.fxml"));
            Pane layout = loader.load();
            Scene scene = new Scene(layout);
            EditorController controller = loader.getController();
            controller.init(file,stage);
            return scene;
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new RuntimeException("Error while loading scene!");
        }
    }

    public static Scene getRenameScene(RecentFile file, Stage stage){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ScenesHandler.class.getResource("/views/RenameFileView.fxml"));
            Pane layout = loader.load();
            Scene scene = new Scene(layout);
            RenameFileController controller = loader.getController();
            controller.init(file,stage);
            return scene;
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new RuntimeException("Error while loading scene!");
        }
    }

    public static String getMainTitle(){
        return "ToDo Manager";
    }
}
