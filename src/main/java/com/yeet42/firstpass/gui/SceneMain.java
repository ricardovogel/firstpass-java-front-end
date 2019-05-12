package com.yeet42.firstpass.gui;

import com.yeet42.firstpass.data.DataEntries;
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

        DataEntries.data.addAll("dab","dab1","dab2");

        list.setOnMouseClicked(event -> {
            System.out.println(event.getTarget().toString().split("'")[1]);
        });

        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(list);
        this.setPrimaryParent(vBox);

//        table = new TableView();
//        table.setEditable(true);
//
//        TableColumn useCol = new TableColumn("Use");
//        useCol.setCellValueFactory(
//                new PropertyValueFactory<DataEntry, String>("use")
//        );
//        TableColumn usernameCol = new TableColumn("Username");
//        usernameCol.setCellValueFactory(
//                new PropertyValueFactory<DataEntry, String>("username")
//        );
//        TableColumn passCol = new TableColumn("Password");
//        passCol.setCellValueFactory(
//                new PropertyValueFactory<DataEntry, String>("password")
//        );
//        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
//        table.getColumns().addAll(useCol, usernameCol, passCol);
//        DataEntries.data.addAll(
//                new DataEntry("a", "b", "c"),
//                new DataEntry("a", "b", "c"),
//                new DataEntry("a", "b", "c"),
//                new DataEntry("a", "b", "c")
//        );
//        table.setItems(DataEntries.data);
//
//        final TextField addUse = new TextField();
//        addUse.setPromptText("Use");
//        addUse.setMaxWidth(useCol.getPrefWidth());
//        final TextField addUsername = new TextField();
//        addUsername.setMaxWidth(usernameCol.getPrefWidth());
//        addUsername.setPromptText("Username");
//        final TextField addPass = new TextField();
//        addPass.setMaxWidth(passCol.getPrefWidth());
//        addPass.setPromptText("Password");
//
//        final Button addButton = new Button("Add");
//        addButton.setOnAction(e -> {
//            DataEntry entryToAdd = new DataEntry(
//                    addUse.getText(),
//                    addUsername.getText(),
//                    addPass.getText()
//            );
//            GUIConfig.USB_INTERFACE.addItem(entryToAdd, Session.userKey);
//            DataEntries.data.add(entryToAdd);
//            addUse.clear();
//            addUsername.clear();
//            addPass.clear();
//        });
//
//        HBox addData = new HBox();
//        addData.getChildren().addAll(addUse, addUsername, addPass, addButton);
//
//
//        final VBox vbox = new VBox();
//        vbox.setSpacing(5);
//        vbox.setPadding(new Insets(10, 0, 0, 10));
//        vbox.getChildren().addAll(table, addData);
//
//        this.setPrimaryParent(vbox);
    }

    @Override
    protected void setSceneTitle() {
        this.setSceneTitle("Main Screen");
    }
}
