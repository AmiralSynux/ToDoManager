package ui.controllers;

import domain.RecentFile;
import domain.TaskList;
import domain.TodoTask;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import service.IService;
import service.ServiceFactory;
import ui.helper.AlertHelper;
import ui.helper.ImageHelper;
import ui.helper.SceneHelper;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class EditorController {
    @FXML
    private TextArea textArea;
    private String recentText;
    private Stage current;
    private RecentFile file;
    private IService service;
    private TaskList taskList;
    public void init(RecentFile file, Stage stage){
        try {
            recentText = Files.readString(file.getFile().toPath());
            textArea.setText(recentText);
            file.setLastOpened(LocalDateTime.now());
            service = ServiceFactory.getService();
            service.updateFile(file);
            this.file = file;
            this.current = stage;
            current.setTitle(SceneHelper.getMainTitle() + " - " + file.getName());
        }catch (NoSuchFileException e){
            throw new RuntimeException("Missing file!\nThis file is missing or has been renamed: " + e.getMessage());
        }
        catch (IOException e) {
            e.printStackTrace();
            AlertHelper.showError(e);
            throw new RuntimeException(e.getMessage());
        }
    }

    public void init(TaskList taskList, Stage stage){
        this.taskList = taskList;
        init(taskList.getFile(),stage);
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
        try{
            Scanner scanner = new Scanner(EditorController.class.getResource("/helpbtn.txt").openStream());
            StringBuilder rules = new StringBuilder();
            while (scanner.hasNext())
                rules.append(scanner.nextLine() + "\n");
            AlertHelper.showNotify(rules.toString());
        }catch (Exception e){
            e.printStackTrace();
            AlertHelper.showError("Missing dsl-rules!");
        }
    }

    public void openMainScreen() {
        this.current.setScene(SceneHelper.getMainProgramScene(current));
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
            List<TodoTask> taskList = service.interpret(file.getFile());
            TaskList list;
            if(this.taskList != null){
                List<TodoTask> aux = this.taskList.getTasks();
                this.taskList.setTasks(taskList);
                service.updateTaskList(this.taskList);
                service.removeTasks(aux);
                list = this.taskList;
            }
            else{
                list = new TaskList(file,taskList);
                list = service.saveTaskList(list);
            }
            current.setScene(SceneHelper.getTaskListScene(list, current));
        }catch (Exception e){
            AlertHelper.showError(e);
        }
    }
}
