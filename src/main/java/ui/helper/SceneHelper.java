package ui.helper;

import domain.RecentFile;
import domain.TaskList;
import domain.TodoTask;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import ui.controllers.EditorController;
import ui.controllers.MainProgramController;
import ui.controllers.RenameFileController;
import ui.controllers.TaskListController;

import java.util.List;

public class SceneHelper {

    public static Scene getTaskListScene(TaskList taskList, Stage stage){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(SceneHelper.class.getResource("/views/TaskList.fxml"));
            Pane layout = loader.load();
            Scene scene = new Scene(layout);
            TaskListController controller = loader.getController();
            controller.init(taskList, stage);
            return scene;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            throw new RuntimeException("Error while loading scene!");
        }
    }


    public static Scene getMainProgramScene(Stage stage) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(SceneHelper.class.getResource("/views/MainProgramView.fxml"));
            Pane layout = loader.load();
            Scene scene = new Scene(layout);
            MainProgramController controller = loader.getController();
            controller.init(stage);
            return scene;
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new RuntimeException("Error while loading scene!");
        }
    }

    public static Scene getEditorScene(RecentFile file, Stage stage){
        return getEditorScene(null,file,stage);
    }
    public static Scene getEditorScene(TaskList taskList, Stage stage){
        return getEditorScene(taskList,null,stage);
    }
    private static Scene getEditorScene(TaskList taskList, RecentFile file, Stage stage){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(SceneHelper.class.getResource("/views/EditorView.fxml"));
            Pane layout = loader.load();
            Scene scene = new Scene(layout);
            EditorController controller = loader.getController();
            if(taskList == null)
                controller.init(file,stage);
            else
                controller.init(taskList,stage);
            return scene;
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new RuntimeException("Error while loading scene!");
        }
    }
    public static Scene getRenameScene(RecentFile file, Stage stage){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(SceneHelper.class.getResource("/views/RenameFileView.fxml"));
            Pane layout = loader.load();
            Scene scene = new Scene(layout);
            RenameFileController controller = loader.getController();
            controller.init(file,stage);
            return scene;
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new RuntimeException("Error while loading scene!");
        }
    }

    public static String getMainTitle(){
        return "ToDo Manager";
    }
}
