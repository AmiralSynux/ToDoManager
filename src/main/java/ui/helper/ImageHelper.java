package ui.helper;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ImageHelper {
    private static ImageView loadImage(String fileName) throws FileNotFoundException {
        String path = ImageHelper.class.getResource("/images/" + fileName).getPath();
        Image image = new Image(new FileInputStream(path));
        return new ImageView(image);
    }

    public enum Images{
        Check,
        Redo
    }

    public static ImageView getImage(Images image){
        try {
            switch (image){
                case Redo -> {
                    ImageView img = loadImage("redo.png");
                    img.setFitHeight(30);
                    img.setFitWidth(35);
                    return img;
                }
                case Check -> {
                    return loadImage("check.png");
                }
                default -> {
                    throw new RuntimeException("Missing image!");
                }
            }
        }catch (FileNotFoundException e){
            throw new RuntimeException("Image file not found! Missing image file: " + image.toString());
        }
    }
}
