package org.example.controller;

import javafx.geometry.Pos;
import javafx.scene.control.Label;

/**
 * @see tabFrameKeyPaneMainClassLabel 选择入口
 */
public class tabFrameKeyPaneMainClassLabel {
    public static Label label = new Label();
    public static void tabFrameKeyPaneMainClassLabelController(){
        label.setId("tabFrameKeyPaneMainClassLabel");
        label.setText("入口函数");
        label.setLayoutX(5);
        label.setLayoutY(60);
        label.setPrefWidth(150);
        label.setPrefHeight(50);
        label.setAlignment(Pos.CENTER);
    }
}
