package com.yeet42.firstpass.gui;

import com.yeet42.firstpass.data.DataEntries;
import com.yeet42.firstpass.data.DataEntry;
import com.yeet42.firstpass.guiinteraction.Session;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
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
        useCol.setCellValueFactory(
                new PropertyValueFactory<DataEntry, String>("use")
        );
        TableColumn usernameCol = new TableColumn("Username");
        usernameCol.setCellValueFactory(
                new PropertyValueFactory<DataEntry, String>("username")
        );
        TableColumn passCol = new TableColumn("Password");
        passCol.setCellValueFactory(
                new PropertyValueFactory<DataEntry, String>("password")
        );
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        table.getColumns().addAll(useCol, usernameCol, passCol);
        DataEntries.data.addAll(
                new DataEntry("a", "b", "c"),
                new DataEntry("a", "b", "c"),
                new DataEntry("a", "b", "c"),
                new DataEntry("a", "b", "c")
        );
        table.setItems(DataEntries.data);

        final TextField addUse = new TextField();
        addUse.setPromptText("Use");
        addUse.setMaxWidth(useCol.getPrefWidth());
        final TextField addUsername = new TextField();
        addUsername.setMaxWidth(usernameCol.getPrefWidth());
        addUsername.setPromptText("Username");
        final TextField addPass = new TextField();
        addPass.setMaxWidth(passCol.getPrefWidth());
        addPass.setPromptText("Password");

        final Button addButton = new Button("Add");
        addButton.setOnAction(e -> {
            DataEntry entryToAdd = new DataEntry(
                    addUse.getText(),
                    addUsername.getText(),
                    addPass.getText()
            );
            GUIConfig.USB_INTERFACE.addItem(entryToAdd, Session.userKey);
            DataEntries.data.add(entryToAdd);
            addUse.clear();
            addUsername.clear();
            addPass.clear();
        });

        HBox addData = new HBox();
        addData.getChildren().addAll(addUse, addUsername, addPass, addButton);


        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(table, addData);

        this.setPrimaryParent(vbox);
    }

    @Override
    protected void setSceneTitle() {
        this.setSceneTitle("Main Screen");
    }
}
