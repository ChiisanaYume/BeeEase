package org.example.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;

/**
 * @see tabFrameKeyPaneTypeChoiceBox
 */
public class tabFrameKeyPaneTypeChoiceBox {
    public static ChoiceBox choiceBox = new ChoiceBox();
    public static void tabFrameKeyPaneTypeChoiceBoxController(){
        choiceBox.setId("tabFrameKeyPaneTypeChoiceBox");
        ObservableList<String> observableListItems = FXCollections.observableArrayList();
        observableListItems.addAll("app-image","exe","msi");
        choiceBox.setItems(observableListItems);
        choiceBox.setValue(observableListItems.get(1));
        choiceBox.setLayoutX(160);
        choiceBox.setLayoutY(115);
        choiceBox.setPrefWidth(350);
        choiceBox.setPrefHeight(50);
    }
}
