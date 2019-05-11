package com.yeet42.firstpass.gui;

import com.yeet42.firstpass.guiinteraction.SecondFactor;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.Timer;
import java.util.TimerTask;

public class SceneRegistrationTwoFactor extends ProgramScene{
    SceneRegistrationTwoFactor() {
        super(Scenes.REGISTRATION_SECOND_FACTOR);
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
        setSceneTitle("Register USB");
    }

    @Override
    void switchTo() {
        super.switchTo();
        System.out.println("dab");

        Timer timer = new Timer();
        timer.schedule(new CheckUSBRegister(), 1000, 500);
    }
}

class CheckUSBRegister extends TimerTask {
    public void run() {
        System.out.println("dab");
        if (SecondFactor.create()) {
            ProgramManager.openScene(GUIConfig.FIRSTSCENE);
        }
    }
}