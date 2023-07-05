package org.example.messagesbox;

import javafx.geometry.Pos;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class messageBoxVBox {
    public VBox vBox = new VBox();
    public void  messageBoxVBoxController(Stage stage, Pane pane){
        vBox.prefWidthProperty().bind(pane.prefWidthProperty());
        vBox.setPrefHeight(50);
        vBox.setLayoutY(105);
        vBox.setAlignment(Pos.CENTER);
        addModule(stage,pane);
    }
    public void addModule(Stage stage, Pane pane){
        messageBoxButton messageBoxButton = new messageBoxButton();
        messageBoxButton.messageBoxButtonController(stage,pane);
        vBox.getChildren().add(messageBoxButton.button);
    }
}
