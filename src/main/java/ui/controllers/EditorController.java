package ui.controllers;

import domain.RecentFile;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import service.IService;
import service.ServiceFactory;
import ui.components.AlertHelper;
import ui.components.ScenesHandler;

import java.io.*;
import java.nio.file.Files;
import java.time.LocalDateTime;

public class EditorController {
    @FXML
    private TextArea textArea;

    private Stage current;
    private RecentFile file;
    private IService service;
    public void init(RecentFile file, Stage stage){
        try {
            String text = Files.readString(file.getFile().toPath());
            textArea.setText(text);
            file.setLastOpened(LocalDateTime.now());
            service = ServiceFactory.getService();
            service.updateFile(file);
            this.file = file;
            this.current = stage;
            current.setTitle(ScenesHandler.getMainTitle() + " - " + file.getName());
        } catch (IOException e) {
            e.printStackTrace();
            AlertHelper.showError(e);
        }

    }

    @FXML
    private void createPressed() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION,"new project pressed", ButtonType.OK);
        alert.setTitle("test");
        alert.show();
    }

    @FXML
    private void savePressed() {
        try{
            String currentText = textArea.getText();
            FileWriter writer = new FileWriter(file.getFile());
            writer.write(currentText);
            writer.close();
            AlertHelper.showNotify("Document Saved");
        }catch (Exception e){
            System.out.println(e.getMessage());
            AlertHelper.showError(e);
        }
    }

    @FXML
    private void helpPressed() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION,"new project pressed", ButtonType.OK);
        alert.setTitle("test");
        alert.show();
    }

    public void openMainScreen() {
        this.current.setScene(ScenesHandler.getMainProgramScene(current));
    }
}
