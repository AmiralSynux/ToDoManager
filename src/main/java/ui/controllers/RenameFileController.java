package ui.controllers;

import domain.RecentFile;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import service.IService;
import service.ServiceFactory;
import ui.helper.AlertHelper;

import java.io.IOException;
import java.nio.file.*;

public class RenameFileController {
    @FXML private TextField newFileTextField;
    private RecentFile file;
    private IService service;
    private Stage current;
    public void init(RecentFile file, Stage current){
        this.service = ServiceFactory.getService();
        this.file = file;
        this.current = current;
    }

    @FXML private void RenamePressed() {
        String newName = newFileTextField.getText();
        if(!newName.endsWith(".todo"))
            newName+=".todo";
        Path path =file.getFile().toPath();
        try {
            Path newPath = Files.move(path, path.resolveSibling(newName));
            file.setFile(newPath.toFile());
            file.setName(newName);
            file.setPath(newPath.toFile().getAbsolutePath());
            service.updateFile(file);
            current.close();
        }catch (FileAlreadyExistsException e){
            boolean shouldOverride = AlertHelper.confirmationDialog("A file with the name " + newName + " already exists!\n" +
                    "Do you want to override it?");
            if(shouldOverride){
                try {
                    Path newPath = Files.move(path, path.resolveSibling(newName), StandardCopyOption.REPLACE_EXISTING);
                    file.setFile(newPath.toFile());
                    file.setName(newName);
                    file.setPath(newPath.toFile().getAbsolutePath());
                    service.updateFile(file);
                    current.close();
                } catch (IOException ex) {
                    AlertHelper.showError(e);
                }
            }
        } catch (Exception e) {
            AlertHelper.showError(e);
        }
    }
}
