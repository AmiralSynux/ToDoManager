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
    private String recentText;
    private Stage current;
    private RecentFile file;
    private IService service;
    public void init(RecentFile file, Stage stage){
        try {
            recentText = Files.readString(file.getFile().toPath());
            textArea.setText(recentText);
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
            saveFile();
            AlertHelper.showNotify("Document Saved");
        }catch (Exception e){
            System.out.println(e.getMessage());
            AlertHelper.showError(e);
        }
    }

    private void saveFile() throws IOException {
        String currentText = textArea.getText();
        FileWriter writer = new FileWriter(file.getFile());
        writer.write(currentText);
        writer.close();
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

    public void buildPressed() {
        String text = textArea.getText();
        if(!text.equals(recentText)){
            try{
                saveFile();
                recentText = text;
            }catch (Exception e){
                System.out.println(e.getMessage());
                AlertHelper.showError(e);
            }
        }
        try{
            service.parse(recentText);
        }catch (Exception e){
            System.out.println(e.getMessage());
            AlertHelper.showError(e);
        }
    }
}
