package com.yeet42.firstpass.gui;

import com.yeet42.firstpass.data.DataEntries;
import com.yeet42.firstpass.data.DataEntry;
import com.yeet42.firstpass.guiinteraction.Session;
import javafx.geometry.Pos;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

public class SceneMain extends ProgramScene {
    private ListView<String> list;

    SceneMain() {
        super(Scenes.MAIN_SCREEN);
    }

    @Override
    protected void generateScene() {
        list = new ListView<>();
        list.setEditable(false);
        list.setItems(DataEntries.data);

        DataEntries.data.addAll("dab", "dab1", "dab2");

        list.setOnMouseClicked(event -> {
            String platform = event.getTarget().toString().split("'")[1];
            DataEntry dataEntry = GUIConfig.USB_INTERFACE.requestItem(platform, Session.userKey);
            new SceneEntry(dataEntry).switchTo();
        });

        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(list);
        this.setPrimaryParent(vBox);
    }

    @Override
    protected void setSceneTitle() {
        this.setSceneTitle("Main Screen");
    }
}
