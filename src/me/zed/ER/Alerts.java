package me.zed.ER;

import javafx.scene.control.Alert;

public class Alerts {

    public static Alert resultAlert(){
        Alert empty = new Alert(Alert.AlertType.WARNING);
        empty.setTitle("Report Box Error!");
        empty.setContentText("Fill the entire report before attempting to copy it!");
        empty.setHeaderText(null);
        empty.show();

        return empty;
    }

    public static Alert successfulAlert(){
        Alert sAlert = new Alert(Alert.AlertType.INFORMATION);
        sAlert.setContentText("Your report has been successfully copied!");
        sAlert.setHeaderText("Thanks for using Easy Report!");
        sAlert.setTitle("Easy Report Tool V3.0");
        sAlert.show();

        return sAlert;
    }

    public static Alert commentAlert(){
        Alert cAlert = new Alert(Alert.AlertType.WARNING);
        cAlert.setContentText("Don't forget to enter a comment!");
        cAlert.setHeaderText("No comment found!");
        cAlert.setTitle("Comment Alert");
        cAlert.show();

        return cAlert;
    }

    //complete other alerts.
}
