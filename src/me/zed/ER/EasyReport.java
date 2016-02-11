package me.zed.ER;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class EasyReport extends Application {

    Alert alert;

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

        BorderPane border = new BorderPane();

        HBox hbox = addHBox();
        border.setTop(hbox);
        border.setBottom(addHBoxBtm());

        alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Your report has been successfully copied!");
        alert.setHeaderText("Thanks for using Easy Report!");
        alert.setTitle("Easy Report Tool V3.0");

        Scene scene = new Scene(border, 300 * 2.5, 250 * 2.5);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private HBox addHBox(){
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 15, 15, 15));
        hbox.setSpacing(520);
        hbox.setStyle("-fx-background-color: #C0C0C0;");

        Text info = new Text("Hypixel Report Tool \r\n Version 3.0");
        info.setFont(Font.font("Sant-Serif", FontWeight.BOLD, 14));

        ImageView logo = new ImageView(new Image(EasyReport.class.getResourceAsStream("Hypixel.png")));
        logo.setFitWidth(200);
        logo.setFitHeight(85);
        hbox.getChildren().addAll(info, logo);

        return hbox;
    }

    private HBox addHBoxBtm(){
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 15, 15, 15));
        hbox.setSpacing(80);
        hbox.setStyle("-fx-background-color: #C0C0C0;");

        Text credits = new Text("© Professor_Zed | All rights reserved.");
        credits.setFont(Font.font("Sofia-Pro", FontWeight.NORMAL, 12));

        Button btncopy = new Button("Copy Report");
        btncopy.setPrefWidth(120);
        btncopy.setAlignment(Pos.CENTER);
        btncopy.setOnAction(e -> {
            /*if report result isn't empty, show alert.
            but I already added the alert
            so fuck you
            jk im sorry
            i love you
            you love me
            WE'RE A HAPPY FAMILY
             */
            alert.show();
        });
        //add copy code
        hbox.getChildren().addAll(credits, btncopy);

        return hbox;
    }

    private VBox rprtinfo(){
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(15,15,15,15));
        //add rest of the info.
        return vbox;
    }

}
