package org.example.controller;

import javafx.geometry.Pos;
import javafx.scene.control.Label;

/**
 * @see tabFrameOptionalPaneIsInstallLabel
 */
public class tabFrameOptionalPaneIsInstallLabel {
    public static Label label = new Label();
    public static void tabFrameOptionalPaneIsInstallLabelController(){
        label.setId("tabFrameOptionalPaneIsInstallLabel");
        label.setText("是否安装包");
        label.setLayoutX(5);
        label.setLayoutY(115);
        label.setPrefWidth(150);
        label.setPrefHeight(50);
        label.setAlignment(Pos.CENTER);
    }
}
