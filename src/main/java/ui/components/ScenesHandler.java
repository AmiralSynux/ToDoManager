package ui.components;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import service.IService;
import ui.controllers.EditorController;
import ui.controllers.MainProgramController;

import java.io.File;

public class ScenesHandler {
    public static Scene getMainProgramScene(IService service, Stage stage) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ScenesHandler.class.getResource("/views/MainProgramView.fxml"));
            Pane layout = loader.load();
            Scene scene = new Scene(layout);
            MainProgramController controller = loader.getController();
            controller.init(service, stage);
            return scene;
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new RuntimeException("Error while loading scene!");
        }
    }

    public static Scene getEditorScene(File file){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ScenesHandler.class.getResource("/views/EditorView.fxml"));
            Pane layout = loader.load();
            Scene scene = new Scene(layout);
            EditorController controller = loader.getController();
            controller.init(file);
            return scene;
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new RuntimeException("Error while loading scene!");
        }
    }
}
