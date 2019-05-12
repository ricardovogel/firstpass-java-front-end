package com.yeet42.firstpass.gui;

import com.jfoenix.controls.JFXButton;
import com.yeet42.firstpass.data.DataEntry;
import com.yeet42.firstpass.guiinteraction.Session;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;


public class SceneAddEntry extends ProgramScene {
    public SceneAddEntry() {
        super(Scenes.ADD_ENTRY);
    }

    @Override
    protected void generateScene() {
        HBox platform = new HBox(5);
        platform.setAlignment(Pos.CENTER);
        Text platformLabel = new Text("Platform:");
        TextField platformText = new TextField();
        platformText.setId("title-text");
        platform.getChildren().addAll(platformLabel, platformText);


        HBox username = new HBox(5);
        username.setAlignment(Pos.CENTER);
        Text usernameLabel = new Text("Username:");
        TextField usernameText = new TextField();
        usernameText.setId("title-text");
        username.getChildren().addAll(usernameLabel, usernameText);

        HBox password = new HBox(5);
        password.setAlignment(Pos.CENTER);
        Text passwordLabel = new Text("Password:");
        TextField passwordText = new TextField();
        passwordText.setId("title-text");
        password.getChildren().addAll(passwordLabel, passwordText);

        JFXButton button0 = new JFXButton("Add");
        button0.setOnAction(e -> {
            DataEntry newEntry = new DataEntry(platformText.getText(), usernameText.getText(), passwordText.getText());
            if(platformText.getText().equals("")){
                return;
            }
            ProgramManager.openScene(Scenes.MAIN_SCREEN);
        });
        button0.setId("blue-button");

        JFXButton button1 = new JFXButton("Back");
        button1.setOnAction(e -> ProgramManager.openScene(Scenes.MAIN_SCREEN));
        button1.setId("blue-button");

        HBox buttons = new HBox(5);
        buttons.setAlignment(Pos.CENTER);
        buttons.getChildren().addAll(button0, button1);

        VBox vBox = new VBox(5);
        vBox.getChildren().addAll(platform, username, password, new Text(""), buttons);
        vBox.setAlignment(Pos.CENTER);
        this.setPrimaryParent(vBox);
    }

    @Override
    protected void setSceneTitle() {
        this.setSceneTitle("Add Entry");
    }
}