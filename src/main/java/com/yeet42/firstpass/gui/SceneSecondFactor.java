package com.yeet42.firstpass.gui;


import com.yeet42.firstpass.guiinteraction.SecondFactor;
import javafx.geometry.Pos;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.Timer;
import java.util.TimerTask;

public class SceneSecondFactor extends ProgramScene {
    SceneSecondFactor() {
        super(Scenes.SECOND_FACTOR);
    }

    @Override
    protected void generateScene() {
        Text logo = new Text("\uf287");
        logo.setId("main-menu-logo");

        Text text = new Text("Please enter your USB");
        text.setId("enter-usb-text");

        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(logo, text);

        this.setPrimaryParent(vBox);
    }

    @Override
    protected void setSceneTitle() {
        setSceneTitle("Second Factor");
    }

    @Override
    void switchTo() {
        super.switchTo();
        Timer timer = new Timer();
        timer.schedule(new CheckUSB(), 1000, 500);
    }
}

class CheckUSB extends TimerTask {
    public void run() {
        if (SecondFactor.authenticate()) {
            ProgramManager.openScene(GUIConfig.AFTER_LOGIN_SCENE);
        }
    }
}
