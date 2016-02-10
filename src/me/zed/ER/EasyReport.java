package me.zed.ER;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Created by gol on 2/9/2016.
 */
public class EasyReport extends Application {

    Button button;
    Alert alert;
    TextArea txtarea;

    public static void main(String[] args) {
        launch(args);
    }


    /*
    These are bunch of test codes,
    do whatever you want as long as you make eit similar to the old one
     */

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Easy Report 3.0");

        alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Your report has been successfully copied!");
        alert.setHeaderText("Thanks for using Easy Report!");
        alert.setTitle("Easy Report Tool V3.0");

        button = new Button();
        button.setText("Click to copy.");
        button.setOnAction(e -> {
            alert.show();
            txtarea.copy();
        });

        Pane layout = new Pane();
        layout.getChildren().add(button);

        txtarea = new TextArea();
        txtarea.setEditable(false);
        txtarea.setText("Hi, this is me.");
        layout.getChildren().add(txtarea);

        Scene scene = new Scene(layout, 300 * 2.5, 250 * 2.5);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
