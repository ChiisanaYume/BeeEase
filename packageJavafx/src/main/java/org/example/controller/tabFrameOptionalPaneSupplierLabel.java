package org.example.controller;

import javafx.geometry.Pos;
import javafx.scene.control.Label;

/**
 * @see tabFrameOptionalPaneSupplierLabel
 */
public class tabFrameOptionalPaneSupplierLabel {
    public static Label label = new Label();
    public static void tabFrameOptionalPaneSupplierLabelController(){
        label.setId("tabFrameOptionalPaneSupplierLabel");
        label.setText("供应商");
        label.setLayoutX(5);
        label.setLayoutY(60);
        label.setPrefWidth(150);
        label.setPrefHeight(50);
        label.setAlignment(Pos.CENTER);
    }
}
