package org.example.controller;

import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

/**
 * @see tabFrameHomePaneVBox 模板
 */
public class tabFrameHomePaneVBox {
    public static VBox vBox = new VBox();
    public static void tabFrameHomePaneVBoxController(){
        vBox.prefWidthProperty().bind(paneFramework.pane.prefWidthProperty());
        vBox.setPrefHeight(50);
        vBox.setLayoutY(260);
        vBox.setAlignment(Pos.CENTER);
        addModule();
    }
    public static void addModule(){
        tabFrameHomePaneVBoxButton.tabFrameHomePaneVBoxButtonController();
        vBox.getChildren().add(tabFrameHomePaneVBoxButton.button);
    }
}
