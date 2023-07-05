package org.example.controller;

import javafx.geometry.Pos;
import javafx.scene.control.Label;

/**
 * @see tabFrameOptionalInstructionsLabel
 */
public class tabFrameOptionalInstructionsLabel {
    public static Label label = new Label();
    public static void tabFrameOptionalInstructionsLabelController(){
        label.setId("tabFrameOptionalInstructionsLabel");
        label.setText("应用说明");
        label.setLayoutX(5);
        label.setLayoutY(5);
        label.setPrefWidth(150);
        label.setPrefHeight(50);
        label.setAlignment(Pos.CENTER);
    }
}
