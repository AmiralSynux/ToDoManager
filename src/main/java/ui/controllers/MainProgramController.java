package ui.controllers;

import domain.RecentFile;
import domain.TaskList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import service.IService;
import service.ServiceFactory;
import ui.helper.AlertHelper;
import ui.components.RecentFileItem;
import ui.helper.SceneHelper;

import java.io.File;
import java.io.IOException;

public class MainProgramController {

    @FXML
    private TextField searchField;
    @FXML
    private ListView<RecentFileItem> projectList;

    private Stage current;
    private IService service;

    public void init(Stage stage){
        current = stage;
        stage.setTitle(SceneHelper.getMainTitle());
        this.service = ServiceFactory.getService();
        initList();
        setSearchField();
    }

    private void setSearchField() {
        searchField.setOnKeyTyped(event -> {
            initList();
        });
    }

    private void initList() {
        projectList.getItems().clear();
        String text = searchField.getText();
        if(text.isEmpty())
            service.getRecentFiles().forEach(this::addFile);
        else
            service.getFilteredRecentFiles(text).forEach(this::addFile);
    }

    private void addFile(RecentFile file) {
        RecentFileItem recentFileItem = new RecentFileItem(file);
        recentFileItem.setOnMouseClicked(event -> {
            try{
                if(event.getButton().equals(MouseButton.PRIMARY) && event.getClickCount() == 2){
                    TaskList taskList = service.getTaskList(file);
                    if(taskList == null){
                        current.setScene(SceneHelper.getEditorScene(file,current));
                    }
                    else{
                        current.setScene(SceneHelper.getTaskListScene(taskList,current));
                    }
                    current.setTitle(SceneHelper.getMainTitle() + " - " + file.getName());
                }
            }catch (Exception e){
                AlertHelper.showError(e);
            }
        });
        projectList.getItems().add(recentFileItem);
    }

    @FXML
    private void newProjectPressed() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Create Todo File");
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Todo files","*.todo");
        fileChooser.getExtensionFilters().add(filter);
        fileChooser.setSelectedExtensionFilter(filter);
        File file = fileChooser.showSaveDialog(current);
        try {
            if(file.createNewFile())
                openEditor(file);
            else
                AlertHelper.showError("File already exists!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void openEditor(File file){
        if(file == null) return;
        RecentFile savedFile;
        try {
            savedFile = service.addRecentFile(file);
        }catch (Exception e){
            AlertHelper.showError(e);
            return;
        }
        current.setScene(SceneHelper.getEditorScene(savedFile, current));
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
        openEditor(file);
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

    @FXML
    private void renameProject() {
        var items = projectList.getSelectionModel().getSelectedItems();
        if(items.size()!=1){
            AlertHelper.showError("Please select one file!");
            return;
        }
        RecentFile file = items.get(0).getRecentFile();
        Stage stage = new Stage();
        stage.setScene(SceneHelper.getRenameScene(file,stage));
        stage.setTitle("Renaming - " + file.getName());
        stage.showAndWait();
        initList();
    }
}
