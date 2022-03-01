package ui.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
        Alert alert = new Alert(Alert.AlertType.INFORMATION,"new project pressed", ButtonType.OK);
        alert.setTitle("test");
        alert.show();
    }

    @FXML
    private void helpPressed() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION,"new project pressed", ButtonType.OK);
        alert.setTitle("test");
        alert.show();
    }
}
