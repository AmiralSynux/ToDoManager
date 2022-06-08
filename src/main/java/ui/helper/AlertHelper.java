package ui.helper;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Region;

import java.util.Optional;

public class AlertHelper {
    /**
     * shows an error
     * @param error - the error shown
     */
    public static void showError(String error){
        System.out.println(error);
        Alert alert = new Alert(Alert.AlertType.ERROR,error, ButtonType.OK);
        alert.setHeaderText(null);
        alert.show();
    }

    /**
     * shows an error
     * @param error - the error shown
     */
    public static void showError(Exception error){
        System.out.println(error.getMessage());
        error.printStackTrace();
        Alert alert = new Alert(Alert.AlertType.ERROR,error.getMessage(),ButtonType.OK);
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        alert.setHeaderText(null);
        alert.show();
    }

    /**
     * shows an alert with the message
     * @param message - the message shown
     */
    public static void showNotify(String message){
        Alert alert = new Alert(Alert.AlertType.INFORMATION,message,ButtonType.OK);
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        alert.setHeaderText(null);
        alert.show();
    }

    /**
     * shows an alert with the message and waits to be clicked or closed
     * @param message - the message shown
     */
    public static void stubbornNotify(String message){
        Alert alert = new Alert(Alert.AlertType.INFORMATION,message,ButtonType.OK);
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        alert.setHeaderText(null);
        alert.showAndWait();
    }

    /**
     * shows a confirmation dialog
     * @param message - the message shown
     * @return true, if the user pressed "Ok"
     *         false otherwise
     */
    public static boolean confirmationDialog(String message){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,message,ButtonType.OK,ButtonType.CANCEL);
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        alert.setHeaderText(null);
        Optional<ButtonType> btn = alert.showAndWait();
        if(btn.isPresent())
            return btn.get() == ButtonType.OK;
        return false;
    }
}
