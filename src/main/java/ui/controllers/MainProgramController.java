package ui.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import ui.components.ScenesHandler;

import java.io.File;

public class MainProgramController {

    @FXML
    private ListView projectList;

    private Stage current;

    public void init(Stage stage){
        current = stage;
    }

    @FXML
    private void newProjectPressed() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION,"new project pressed", ButtonType.OK);
        alert.setTitle("test");
        alert.show();
    }

    @FXML
    private void openProjectPressed() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Todo File");
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Todo files","*.todo");
        FileChooser.ExtensionFilter any = new FileChooser.ExtensionFilter("Any File","*.*");
        fileChooser.getExtensionFilters().add(filter);
        fileChooser.getExtensionFilters().add(any);
        fileChooser.setSelectedExtensionFilter(filter);

        File file = fileChooser.showOpenDialog(current);
        if(file == null)
        {

            return;
        }

        current.setScene(ScenesHandler.getEditorScene(file));
    }

    @FXML
    private void deleteProjectPress() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION,"delete project pressed", ButtonType.OK);
        alert.setTitle("test");
        alert.show();
    }

}
