package me.zed.ER;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;
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
import java.util.Optional;


public class EasyReport extends Application {


    ObservableList<String> ranks = FXCollections.observableArrayList("Multiple Ranks/Offenders",
            "Default",
            "VIP",
            "VIP+",
            "MVP",
            "MVP+");

    ObservableList<String> perms = FXCollections.observableArrayList("Yes",
            "No");

    ObservableList<String> rsn = FXCollections.observableArrayList("Hacking",
            "Teaming",
            "Inappropriate Content",
            "Abuse",
            "Spam");

    String commentString;
    Clipboard clipboard = Clipboard.getSystemClipboard();
    ClipboardContent content = new ClipboardContent();
    TextArea textArea;
    TextInputDialog commentDia;

    Text lname;
    Text lproof;
    Text lrank;
    Text lperm;
    Text lreason;

    static TextArea name;
    static TextArea proof;

    static ComboBox reason;
    static ComboBox rank;
    static ComboBox sharePerm;

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

        Scene scene = new Scene(border, 360 * 2.5, 250 * 2.5);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    //top
    private HBox addHBox() {
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 15, 15, 15));
        hbox.setSpacing(640);
        hbox.setStyle("-fx-background-color: #C0C0C0;");

        Text info = new Text("Hypixel Report Tool \r\n Version 3.0");
        info.setFont(Font.font("Sant-Serif", FontWeight.BOLD, 14));

        ImageView logo = new ImageView(new Image(EasyReport.class.getResourceAsStream("smallerlogo.png")));
        logo.setFitWidth(110);
        logo.setFitHeight(110);
        hbox.getChildren().addAll(info, logo);

        return hbox;
    }

    //bottom
    private HBox addHBoxBtm() {
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 15, 15, 15));
        hbox.setSpacing(160);
        hbox.setStyle("-fx-background-color: #C0C0C0;");

        Text credits = new Text("© Professor_Zed | All rights reserved.");
        credits.setFont(Font.font("Sofia-Pro", FontWeight.NORMAL, 12));

        Button commentBtn = new Button("Comment");
        commentBtn.setPrefSize(140, 40);
        commentBtn.setFont(Font.font("Sant-Serif", FontWeight.BOLD, 14));
        commentBtn.setAlignment(Pos.CENTER);
        commentBtn.setOnAction(event -> {
            commentDia = new TextInputDialog();
            commentDia.setHeaderText("Comment for the offense");
            commentDia.setTitle("Comment");
            commentDia.setContentText("Enter your comment");

            Optional<String> comment = commentDia.showAndWait();
            if (comment.isPresent()) {
                commentString = comment.toString();
            }
        });

        Button btncopy = new Button("Copy Report");
        btncopy.setPrefWidth(140);
        btncopy.setPrefHeight(40);
        btncopy.setFont(Font.font("Sant-Serif", FontWeight.BOLD, 14));
        btncopy.setAlignment(Pos.CENTER);
        btncopy.setOnAction(e -> {
            if (name.getText().isEmpty() || proof.getText().isEmpty() || rank.getValue() == null || reason.getValue() == null ||
                    sharePerm.getValue() == null) {
                Alerts.resultAlert();
            } else {
                textArea.setText(String.format(
                        "[LIST][*][B][COLOR=#0000ff]In-Game Name: \r\n [/COLOR][/B]%s %s[/COLOR][/LIST]%n"
                                + "[LIST][*][B][COLOR=#0000ff]Reason: \r\n [/COLOR][/B]%s[/LIST]%n"
                                + "[LIST][*][B][COLOR=#0000ff]Evidence: \r\n [/COLOR][/B][URL]%s[/URL][/LIST]%n"
                                + "[LIST][*][B][COLOR=#0000ff]Do you give us permission to share your proof: \r\n [/COLOR][/B]%s[/LIST]%n",
                        getFormattedRank(rank.getValue().toString()), name.getText(), reason.getValue().toString() + " " +
                                commentString, proof.getText(), sharePerm.getValue().toString()));

                content.putString(textArea.getText());
                clipboard.setContent(content);
                Alerts.successfulAlert();
                textArea.setText("");//fix this to show after clicking Done/OK in alert
                //probably fixed, I hope : ye fixed
            }
        });
        hbox.getChildren().addAll(credits, btncopy, commentBtn);

        return hbox;
    }

    //right
    private VBox buttons() {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(15, 15, 15, 120));
        vbox.setSpacing(7);

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

        vbox.getChildren().addAll(forum, yt, imgr);
        return vbox;
    }

    //left
    private VBox rprtinfo2() {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(15, 50, 15, 15));
        vbox.setSpacing(17);

        lname = new Text("Offender's Name");
        name = new TextArea();
        name.setPrefSize(15, 25);

        lrank = new Text("Offender's Rank");
        rank = new ComboBox(ranks);
        rank.setPromptText("Select A Rank");

        lreason = new Text("Reason Of The Report");
        reason = new ComboBox(rsn);
        reason.setPromptText("Reason Of The Report");

        lproof = new Text("Evidence");
        proof = new TextArea();
        proof.setPrefSize(15, 15);

        lperm = new Text("Do you give the staff permissions \r\n to share your evidence?");
        sharePerm = new ComboBox(perms);
        sharePerm.setPromptText("Yes/No");

        vbox.getChildren().addAll(lname, name, lrank, rank, lreason, reason, lproof, proof, lperm, sharePerm);
        return vbox;
    }

    //center
    private TextArea textArea() {
        textArea = new TextArea();
        textArea.setPrefWidth(240);
        textArea.setEditable(false);
        return textArea;
    }

    //Thanks to LEGENDFF
    private String getFormattedRank(String rank) {
        switch (rank.toLowerCase()) {
            case "default":
                return "[COLOR=#AAAAAA][Default]";
            case "vip":
                return "[COLOR=#55FF55][VIP]";
            case "vip+":
                return "[COLOR=#55FF55][VIP[/COLOR][COLOR=#FFAA00]+[/COLOR][COLOR=#55FF55]]";
            case "mvp":
                return "[COLOR=#55FFFF][MVP]";
            case "mvp+":
                return "[COLOR=#55FFFF][MVP[/COLOR][COLOR=#FF5555]+[/COLOR][COLOR=#55FFFF]]";
            case "mutliple ranks":
                return "[COLOR=#404040]";
            default:
                return rank;
        }
    }

}
