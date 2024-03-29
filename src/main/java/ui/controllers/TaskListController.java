package ui.controllers;

import domain.RecentFile;
import domain.TaskList;
import domain.TodoTask;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import service.IService;
import service.ServiceFactory;
import ui.helper.AlertHelper;
import ui.helper.SceneHelper;
import ui.components.ToDoTaskItem;


public class TaskListController {
    @FXML
    private ListView<ToDoTaskItem> taskList;

    private RecentFile file;
    private IService service;
    private TaskList tasks;
    private Stage stage;
    public void init(TaskList tasks, Stage stage){
        this.stage = stage;
        this.tasks = tasks;
        service = ServiceFactory.getService();
        service.refreshTasks(tasks.getTasks());
        initList();
    }


    private void initList() {
        taskList.getItems().clear();
        for (TodoTask task : tasks.getTasks()){
            if(task.isActive())
                taskList.getItems().add(new ToDoTaskItem(task));
        }
        for (TodoTask task : tasks.getTasks()){
            if(!task.isActive())
                taskList.getItems().add(new ToDoTaskItem(task));
        }
    }

    @FXML
    private  void openMainPage() {
        stage.setScene(SceneHelper.getMainProgramScene(stage));
    }

    public void completeTask() {
        if(taskList.getSelectionModel().getSelectedItems().size()==0){
            AlertHelper.showError("Please select a task to complete!");
            return;
        }
        if(taskList.getSelectionModel().getSelectedItems().size()>1){
            AlertHelper.showError("Please select only one task to complete!");
            return;
        }
        TodoTask task = taskList.getSelectionModel().getSelectedItems().get(0).getTask();
        if(!task.isActive()){
            AlertHelper.showError("The selected task is not active!");
            return;
        }
        try{
            service.complete(task);
            AlertHelper.showNotify("Task completed!");
            initList();
        }catch (Exception e){
            AlertHelper.showError(e);
        }
    }

    public void edit() {
        try{
            stage.setScene(SceneHelper.getEditorScene(tasks,stage));
        }catch (Exception e){
            AlertHelper.showError(e);
        }
    }
}
