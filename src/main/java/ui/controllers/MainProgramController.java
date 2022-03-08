package ui.controllers;

import domain.RecentFile;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import service.IService;
import ui.components.RecentFileItem;
import ui.components.ScenesHandler;

import java.io.File;

public class MainProgramController {

    @FXML
    private ListView<RecentFileItem> projectList;

    private Stage current;
    private IService service;

    public void init(IService service, Stage stage){
        current = stage;
        this.service = service;
        initList();
    }

    private void initList() {
        projectList.getItems().clear();
        service.getRecentFiles().forEach(file -> projectList.getItems().add(new RecentFileItem(file)));
    }

    @FXML
    private void newProjectPressed() {
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
        service.addRecentFile(file);
        //current.setScene(ScenesHandler.getEditorScene(file));
        initList();
    }

    @FXML
    private void deleteProjectPress() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION,"delete project pressed", ButtonType.OK);
        alert.setTitle("test");
        alert.show();
    }

}
