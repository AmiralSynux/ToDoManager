package ui.components;

import domain.RecentFile;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.time.format.DateTimeFormatter;


public class RecentFileItem extends VBox {
    RecentFile file;
    public RecentFileItem(RecentFile file){
        System.out.println("Building " + file.getName());
        this.file = file;
        build();
    }

    public RecentFile getRecentFile(){
        return file;
    }

    private void build() {
        HBox fileName = getFileNameItem();
        HBox filePath = getFilePathItem();
        HBox lastOpened = getLastOpenedItem();
        this.getChildren().addAll(fileName,filePath,lastOpened);
    }

    private HBox getLastOpenedItem() {
        HBox hbox = new HBox();
        Text path = new Text("Last opened: " + this.file.getLastOpened().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        path.setFont(Font.font(10));
        hbox.getChildren().add(path);
        return hbox;
    }

    private HBox getFilePathItem() {
        HBox hbox = new HBox();
        Text path = new Text(this.file.getPath());
        path.setFont(Font.font(15));
        hbox.getChildren().add(path);
        return hbox;
    }

    private HBox getFileNameItem() {
        HBox hbox = new HBox();
        Text name = new Text(this.file.getName());
        name.setFont(Font.font(20));
        hbox.getChildren().add(name);
        return hbox;
    }


}
