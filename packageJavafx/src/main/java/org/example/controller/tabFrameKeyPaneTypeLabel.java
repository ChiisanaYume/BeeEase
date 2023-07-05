package org.example.controller;

import javafx.geometry.Pos;
import javafx.scene.control.Label;

/**
 * @see tabFrameKeyPaneTypeLabel
 */
public class tabFrameKeyPaneTypeLabel {
    public static Label label = new Label();
    public static void tabFrameKeyPaneTypeLabelController(){
        label.setId("tabFrameKeyPaneTypeLabel");
        label.setText("打包类型");
        label.setLayoutX(5);
        label.setLayoutY(115);
        label.setPrefWidth(150);
        label.setPrefHeight(50);
        label.setAlignment(Pos.CENTER);
    }
}
