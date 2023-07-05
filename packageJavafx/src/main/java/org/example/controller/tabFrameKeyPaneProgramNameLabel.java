package org.example.controller;

import javafx.geometry.Pos;
import javafx.scene.control.Label;

/**
 * @see tabFrameKeyPaneProgramNameLabel
 */
public class tabFrameKeyPaneProgramNameLabel {
    public static Label label = new Label();
    public static void tabFrameKeyPaneProgramNameLabelController(){
        label.setId("tabFrameKeyPaneProgramNameLabel");
        label.setText("打包程序名");
        label.setLayoutX(5);
        label.setLayoutY(5);
        label.setPrefWidth(150);
        label.setPrefHeight(50);
        label.setAlignment(Pos.CENTER);
    }
}
