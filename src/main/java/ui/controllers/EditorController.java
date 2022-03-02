package ui.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import ui.components.AlertHelper;

import java.io.*;
import java.nio.file.Files;
import java.util.Scanner;

public class EditorController {
    @FXML
    private TextArea textArea;

    private File file;
    public void init(File file){
        try {
            String text = Files.readString(file.toPath());
            textArea.setText(text);
            this.file = file;
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
            FileWriter writer = new FileWriter(file);
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
}
