package org.example.controller;

import javafx.scene.control.TextField;

/**
 * @see tabFrameKeyPaneVersionNumberTextFieId
 */
public class tabFrameKeyPaneVersionNumberTextFieId {
    public static TextField textField = new TextField();

    public static void tabFrameKeyPaneVersionNumberTextFieIdController(){
        textField.setId("tabFrameKeyPaneVersionNumberTextFieId");
        textField.setPromptText("例如：1.0.0");
        textField.setText("1.0.0");
        textField.setLayoutX(160);
        textField.setLayoutY(170);
        textField.setPrefWidth(350);
        textField.setPrefHeight(50);
    }
}
