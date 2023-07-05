package org.example.messagesbox;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class messageBoxContent {
    public Label label = new Label();

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }
    public void messageBoxContentAddListenEvent( Pane pane){
        label.prefWidthProperty().bind(pane.widthProperty());//宽度绑定为Pane宽度
    }
    public void messageBoxContentController(String value){
        label.setAlignment(Pos.CENTER);
        label.setStyle("-fx-label-padding: 0 0 0 10;-fx-font-size: 18;");

        label.setPrefHeight(100);
        label.setText(value);
    }
}
