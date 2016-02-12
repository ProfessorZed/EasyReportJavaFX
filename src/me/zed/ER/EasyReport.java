package me.zed.ER;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


public class EasyReport extends Application {

    Clipboard clipboard = Clipboard.getSystemClipboard();
    ClipboardContent content = new ClipboardContent();
    Alert alert;
    TextArea textArea;
    Alert empty;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Easy Report 3.0");
        primaryStage.setResizable(false);

        BorderPane border = new BorderPane();

        HBox hbox = addHBox();
        border.setTop(hbox);
        border.setBottom(addHBoxBtm());
        border.setRight(buttons());
        border.setLeft(rprtinfo2());

        border.setCenter(textArea());


        alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Your report has been successfully copied!");
        alert.setHeaderText("Thanks for using Easy Report!");
        alert.setTitle("Easy Report Tool V3.0");

        empty = new Alert(Alert.AlertType.WARNING);
        empty.setTitle("Report Box Error!");
        empty.setContentText("The Report Box is empty, fill it with a report!");
        empty.setHeaderText(null);

        Scene scene = new Scene(border, 350 * 2.5, 250 * 2.5);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private HBox addHBox() {
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 15, 15, 15));
        hbox.setSpacing(520);
        hbox.setStyle("-fx-background-color: #C0C0C0;");

        Text info = new Text("Hypixel Report Tool \r\n Version 3.0");
        info.setFont(Font.font("Sant-Serif", FontWeight.BOLD, 14));

        ImageView logo = new ImageView(new Image(EasyReport.class.getResourceAsStream("smallerlogo.png")));
        logo.setFitWidth(110);
        logo.setFitHeight(110);
        hbox.getChildren().addAll(info, logo);

        return hbox;
    }

    private HBox addHBoxBtm() {
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 15, 15, 15));
        hbox.setSpacing(140);
        hbox.setStyle("-fx-background-color: #C0C0C0;");

        Text credits = new Text("© Professor_Zed | All rights reserved.");
        credits.setFont(Font.font("Sofia-Pro", FontWeight.NORMAL, 12));

        Button btncopy = new Button("Copy Report");
        btncopy.setPrefWidth(140);
        btncopy.setPrefHeight(40);
        btncopy.setFont(Font.font("Sant-Serif", FontWeight.BOLD, 14));
        btncopy.setAlignment(Pos.CENTER);
        btncopy.setOnAction(e -> {
            alert.show();
            if (textArea.getText().isEmpty()) {
                empty.show();
            } else {
                content.putString(textArea.getText());
                clipboard.setContent(content);
                //fix this..
            }
        });
        hbox.getChildren().addAll(credits, btncopy);

        return hbox;
    }

    private VBox buttons() {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(15,15,15,85));
//        vbox.setStyle("-fx-background-color: #000000;");
        vbox.setSpacing(5);

        //buttons
        Image logo = new Image(EasyReport.class.getResourceAsStream("smallerlogo.png"));
        Button forum = new Button();
        forum.setGraphic(new ImageView(logo));
        forum.setPrefWidth(50);
        forum.setPrefHeight(50);
        forum.setOnAction(e -> {
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                try {
                    URI uri = new URI("https://hypixel.net/forums/report-abuse-hackers.37/create-thread");
                    desktop.browse(uri);
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (URISyntaxException ex) {
                    ex.printStackTrace();
                }
            }
        });

        Image youtube = new Image(EasyReport.class.getResourceAsStream("youtube.png"));
        Button yt = new Button();
        yt.setGraphic(new ImageView(youtube));
        yt.setPrefWidth(50);
        yt.setPrefHeight(50);
        yt.setOnAction(e -> {
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                try {
                    URI uri = new URI("https://youtube.com/upload");
                    desktop.browse(uri);
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (URISyntaxException ex) {
                    ex.printStackTrace();
                }
            }
        });

        Image imgur = new Image(EasyReport.class.getResourceAsStream("imgur.png"));
        Button imgr = new Button();
        imgr.setGraphic(new ImageView(imgur));
        imgr.setPrefWidth(50);
        imgr.setPrefHeight(50);
        imgr.setOnAction(e -> {
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                try {
                    URI uri = new URI("http://imgur.com/");
                    desktop.browse(uri);
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (URISyntaxException ex) {
                    ex.printStackTrace();
                }
            }
        });

        vbox.getChildren().addAll(forum, yt,imgr);
        return vbox;
    }

    private VBox rprtinfo2() {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(15, 200, 15, 15));
        vbox.setSpacing(20);
        //add info
        return vbox;
    }

    private TextArea textArea(){
        textArea = new TextArea();
        textArea.setPrefWidth(300);
        textArea.setEditable(false);
        return textArea;
    }

}
