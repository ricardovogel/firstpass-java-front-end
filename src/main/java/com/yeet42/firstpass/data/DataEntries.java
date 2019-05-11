package com.yeet42.firstpass.data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DataEntries {
    public static ObservableList<DataEntry> data = FXCollections.observableArrayList();

    public void addItems(DataEntry... entries){
        data.addAll(entries);
    }
}
