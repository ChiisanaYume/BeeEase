package org.example.messagesbox;

import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class messageBoxPane {
    public Pane pane = new Pane();
    public void messageBoxPaneController(Stage stage,String value){
        pane.setPrefWidth(500);
        pane.setPrefHeight(250);
        pane.prefWidthProperty().bind(stage.widthProperty());
        pane.prefHeightProperty().bind(stage.heightProperty());
        addModule(stage,pane,value);
    }
    public void addModule(Stage stage, Pane pane,String value){
        messageBoxVBox messageBoxVBox = new messageBoxVBox();
        messageBoxVBox.messageBoxVBoxController(stage,pane);
        messageBoxContent messageBoxContent = new messageBoxContent();
        messageBoxContent.messageBoxContentAddListenEvent(pane);
        messageBoxContent.messageBoxContentController(value);
        pane.getChildren().addAll(messageBoxContent.label,messageBoxVBox.vBox);
    }
}
