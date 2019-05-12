package com.yeet42.firstpass.gui;

import com.jfoenix.controls.JFXButton;
import com.sun.javafx.scene.control.InputField;
import com.yeet42.firstpass.data.DataEntry;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;


public class SceneEntry extends ProgramScene {
    private DataEntry dataEntry;

    SceneEntry(DataEntry dataEntry) {
        super();
        this.dataEntry = dataEntry;
        generateScene();
        setSceneTitle();
    }

    @Override
    protected void generateScene() {
        HBox platform = new HBox(5);
        platform.setAlignment(Pos.CENTER);
        Text platformLabel = new Text("Platform:");
        TextField platformText = new TextField(this.dataEntry.getPlatform());
        platformText.setId("title-text");
        JFXButton platformButton = new JFXButton("update");
        platformButton.setId("blue-button");
        platform.getChildren().addAll(platformLabel, platformText, platformButton);


        HBox username = new HBox(5);
        username.setAlignment(Pos.CENTER);
        Text usernameLabel = new Text("Username:");
        TextField usernameText = new TextField(this.dataEntry.getUsername());
        usernameText.setId("title-text");
        JFXButton usernameButton = new JFXButton("update");
        usernameButton.setId("blue-button");
        username.getChildren().addAll(usernameLabel, usernameText, usernameButton);

        HBox password = new HBox(5);
        password.setAlignment(Pos.CENTER);
        Text passwordLabel = new Text("Password:");
        TextField passwordText = new TextField(this.dataEntry.getPassword());
        passwordText.setId("title-text");
        JFXButton passwordButton = new JFXButton("update");
        passwordButton.setId("blue-button");
        password.getChildren().addAll(passwordLabel, passwordText, passwordButton);

        Button button = new Button("Back");
        button.setOnAction(e -> ProgramManager.openScene(Scenes.MAIN_SCREEN));

        VBox vBox = new VBox(5);
        vBox.getChildren().addAll(platform, username, password, new Text(""), button);
        vBox.setAlignment(Pos.CENTER);
        this.setPrimaryParent(vBox);
    }

    @Override
    protected void setSceneTitle() {
        this.setSceneTitle(dataEntry.getPlatform());
    }
}