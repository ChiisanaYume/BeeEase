package org.example.messagesbox;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class messageBoxButton {
    public Button button = new Button();

    public void messageBoxButtonController(Stage stage, Pane pane) {
        button.setPrefWidth(100);
        button.setPrefHeight(50);
        button.setText("我了解");
        button.setStyle("-fx-font-size: 18");
        addListenEvent(stage,pane);
    }
    public void addListenEvent(Stage stage, Pane pane){
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.close();
            }
        });
    }
}
