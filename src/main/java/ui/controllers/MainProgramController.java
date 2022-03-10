package ui.controllers;

import domain.RecentFile;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseButton;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import service.IService;
import service.ServiceFactory;
import ui.components.AlertHelper;
import ui.components.RecentFileItem;
import ui.components.ScenesHandler;

import java.io.File;

public class MainProgramController {

    @FXML
    private ListView<RecentFileItem> projectList;

    private Stage current;
    private IService service;

    public void init(Stage stage){
        current = stage;
        this.service = ServiceFactory.getService();
        initList();
    }

    private void initList() {
        projectList.getItems().clear();
        service.getRecentFiles().forEach(file -> {
            RecentFileItem recentFileItem = new RecentFileItem(file);
            recentFileItem.setOnMouseClicked(event -> {
                if(event.getButton().equals(MouseButton.PRIMARY) && event.getClickCount() == 2){
                    current.setScene(ScenesHandler.getEditorScene(file.getFile(),current));
                    current.setTitle(ScenesHandler.getMainTitle() + " - " + file.getName());
                }
            });
            projectList.getItems().add(recentFileItem);
        });
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
        if(file == null) return;
        try {
            service.addRecentFile(file);
        }catch (Exception e){
            AlertHelper.showError(e);
            return;
        }
        current.setScene(ScenesHandler.getEditorScene(file, current));
        current.setTitle(ScenesHandler.getMainTitle() + " - " + file.getName());

    }

    @FXML
    private void removeProjectFromListPress() {
        var items = projectList.getSelectionModel().getSelectedItems();
        if(items.size()!=1){
            AlertHelper.showError("Please select one file!");
            return;
        }
        RecentFile file = items.get(0).getRecentFile();
        boolean shouldDelete = AlertHelper.confirmationDialog(
                "Are you sure you want to remove " + file.getName() + " from the list? " +
                        "\nPath: " + file.getPath() + "\nThis will not delete the file from disk!");
        if(!shouldDelete)return;
        try {
            service.removeRecentFile(file);
            AlertHelper.showNotify("File "+file.getName()+" removed from list!");
            initList();
        }catch (Exception e){
            AlertHelper.showError(e);
        }
    }

    @FXML
    private void deleteProjectPress() {
        var items = projectList.getSelectionModel().getSelectedItems();
        if(items.size()!=1){
            AlertHelper.showError("Please select one file!");
            return;
        }
        RecentFile file = items.get(0).getRecentFile();
        boolean shouldDelete = AlertHelper.confirmationDialog("Are you sure you want to permanently delete " + file.getName() + "?\nPath: " + file.getPath());
        if(!shouldDelete)return;
        try {
            service.removeRecentFile(file);
            if(file.getFile().delete())
                AlertHelper.showNotify("File "+file.getName()+" permanently deleted");
            else
                AlertHelper.showNotify("Couldn't delete the file from the disk. The file was only removed from the recent file list.");
            initList();
        }catch (Exception e){
            AlertHelper.showError(e);
        }

    }

}
