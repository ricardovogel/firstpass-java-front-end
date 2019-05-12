package com.yeet42.firstpass.gui;

import com.yeet42.firstpass.data.DataEntry;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
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
        Text platform = new Text(this.dataEntry.getPlatform());
        platform.setId("title-text");

        Text username = new Text(this.dataEntry.getUsername());
        Text password = new Text(this.dataEntry.getPassword());

        Button button = new Button("Back");
        button.setOnAction(e -> ProgramManager.openScene(Scenes.MAIN_SCREEN));

        VBox vBox = new VBox();
        vBox.getChildren().addAll(platform, username, password, new Text(""), button);
        vBox.setAlignment(Pos.CENTER);
        this.setPrimaryParent(vBox);
    }

    @Override
    protected void setSceneTitle() {
        this.setSceneTitle(dataEntry.getPlatform());
    }
}