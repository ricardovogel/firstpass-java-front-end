package com.yeet42.firstpass.gui;

import javafx.geometry.Insets;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;

public class SceneMain extends ProgramScene {
    private TableView table;

    SceneMain() {
        super(Scenes.MAIN_SCREEN);
    }

    @Override
    protected void generateScene() {
        table = new TableView();
        table.setEditable(true);

        TableColumn useCol = new TableColumn("Use");
        TableColumn usernameCol = new TableColumn("Username");
        TableColumn passCol = new TableColumn("Password");
        System.out.println("DAB");

        table.getColumns().addAll(useCol, usernameCol, passCol);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(table);

        this.setPrimaryParent(vbox);
    }

    @Override
    protected void setSceneTitle() {
        this.setSceneTitle("Main Screen");
    }
}
