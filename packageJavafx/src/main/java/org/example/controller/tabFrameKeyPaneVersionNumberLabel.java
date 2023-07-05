package org.example.controller;

import javafx.geometry.Pos;
import javafx.scene.control.Label;

/**
 * @see tabFrameKeyPaneVersionNumberLabel
 */
public class tabFrameKeyPaneVersionNumberLabel {
    public static Label label = new Label();
    public static void tabFrameKeyPaneVersionNumberLabelController(){
        label.setId("tabFrameKeyPaneVersionNumberLabel");
        label.setText("版本号");
        label.setLayoutX(5);
        label.setLayoutY(170);
        label.setPrefWidth(150);
        label.setPrefHeight(50);
        label.setAlignment(Pos.CENTER);
    }
}
