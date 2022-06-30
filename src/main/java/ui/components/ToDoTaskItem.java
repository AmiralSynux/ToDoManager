package ui.components;

import domain.TodoSubtask;
import domain.TodoTask;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import ui.helper.ImageHelper;

public class ToDoTaskItem extends HBox {
    private TodoTask task;

    public ToDoTaskItem(TodoTask task) {
        this.task = task;
        this.getChildren().add(buildTask());
        if(task.get_interval() != null)
        {
            VBox container = new VBox();
            container.getChildren().add(ImageHelper.getImage(ImageHelper.Images.Redo));
            long hours = task.get_interval().toHours();
            Text text;
            if(hours % 24 == 0 && hours > 24)
                text = new Text(hours/24+" days");
            else
                text = new Text(hours + " hours");
            text.setFont(Font.font(10));
            container.getChildren().add(text);
            container.setAlignment(Pos.CENTER);
            this.getChildren().add(container);
        }
        this.setAlignment(Pos.CENTER_LEFT);
        if(!task.isActive()){
            this.setOpacity(0.3);
        }
    }

    private VBox buildTask(){
        VBox container = new VBox();
        Text main = new Text(task.getDescription());
        main.setFont(Font.font(20));
        container.getChildren().add(main);

        for (TodoSubtask subtask : task.getSubtasks())
        {
            Text sbt = new Text(subtask.getDescription());
            sbt.setFont(Font.font(15));
            container.getChildren().add(sbt);
        }
        return container;
    }

    public TodoTask getTask() {
        return task;
    }

    public void setTask(TodoTask task) {
        this.task = task;
    }


}
