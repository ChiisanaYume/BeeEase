package org.example.controller;

import javafx.scene.control.TextField;

/**
 * @see tabFrameKeyPaneMainClassTextFieId
 */
public class tabFrameKeyPaneMainClassTextFieId {
    public static TextField textField = new TextField();
    public static void tabFrameKeyPaneMainClassTextFieIdController(){
        textField.setId("tabFrameKeyPaneMainClassTextFieId");
        textField.setPromptText("Main 入口函数");
        textField.setText("org.example.App");
        textField.setLayoutX(160);
        textField.setLayoutY(60);
        textField.setPrefWidth(350);
        textField.setPrefHeight(50);
    }
}
