package ui.controllers;

import domain.RecentFile;
import domain.TodoTask;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import service.IService;
import service.ServiceFactory;
import ui.components.ScenesHandler;

import java.util.List;

public class TaskListController {
    @FXML
    private ListView taskList;
    @FXML
    private  Button editorBtn;

    private RecentFile file;
    private IService service;
    private void init(List<TodoTask> tasks){
        service = ServiceFactory.getService();
    }
    @FXML
    private  void openEditor() {
        Stage stage = new Stage();
        stage.setScene(ScenesHandler.getEditorScene(file, stage));
        stage.show();
    }
}
