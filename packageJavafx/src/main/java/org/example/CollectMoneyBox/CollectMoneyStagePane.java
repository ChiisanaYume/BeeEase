package org.example.CollectMoneyBox;

import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.example.messagesbox.messageBoxContent;
import org.example.messagesbox.messageBoxVBox;

public class CollectMoneyStagePane {
    public Pane pane = new Pane();
    public void CollectMoneyStagePaneController(Stage stage){
        pane.setPrefWidth(500);
        pane.setPrefHeight(250);
        pane.prefWidthProperty().bind(stage.widthProperty());
        pane.prefHeightProperty().bind(stage.heightProperty());
        addModule(stage,pane);
    }
    public void addModule(Stage stage, Pane pane){
        CollectMoneyStagePaneImageView collectMoneyStagePaneImageView = new CollectMoneyStagePaneImageView();
        collectMoneyStagePaneImageView.CollectMoneyStagePaneImageViewController();
        pane.getChildren().addAll(collectMoneyStagePaneImageView.imageView);
    }
}
