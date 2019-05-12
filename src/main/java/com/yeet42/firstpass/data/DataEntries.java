package com.yeet42.firstpass.data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DataEntries {
    /**
     * Only stores the uses, actual requests get sent.
     */
    public static ObservableList<String> data = FXCollections.observableArrayList();
}
