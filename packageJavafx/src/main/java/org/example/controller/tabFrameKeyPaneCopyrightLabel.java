package org.example.controller;

import javafx.geometry.Pos;
import javafx.scene.control.Label;

/**
 * @see tabFrameKeyPaneCopyrightLabel
 */
public class tabFrameKeyPaneCopyrightLabel {
    public static Label label = new Label();
    public static void tabFrameKeyPaneCopyrightLabelController(){
        label.setId("tabFrameKeyPaneCopyrightLabel");
        label.setText("版权归属");
        label.setLayoutX(5);
        label.setLayoutY(225);
        label.setPrefWidth(150);
        label.setPrefHeight(50);
        label.setAlignment(Pos.CENTER);
    }
}
