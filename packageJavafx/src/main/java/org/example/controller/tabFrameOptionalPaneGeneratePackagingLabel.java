package org.example.controller;

import javafx.geometry.Pos;
import javafx.scene.control.Label;

/**
 * @see tabFrameOptionalPaneGeneratePackagingLabel
 */
public class tabFrameOptionalPaneGeneratePackagingLabel {
    public static Label label = new Label();
    public static void tabFrameOptionalPaneGeneratePackagingLabelController(){
        label.setId("tabFrameOptionalPaneGeneratePackagingLabel");
        label.setText("最后一步");
        label.setLayoutX(5);
        label.setLayoutY(170);
        label.setPrefWidth(150);
        label.setPrefHeight(50);
        label.setAlignment(Pos.CENTER);
    }
}
