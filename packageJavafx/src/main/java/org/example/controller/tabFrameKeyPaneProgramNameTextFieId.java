package org.example.controller;

import javafx.scene.control.TextField;

/**
 * @see tabFrameKeyPaneProgramNameTextFieId 程序打包名
 */
public class tabFrameKeyPaneProgramNameTextFieId {
    public static TextField textField = new TextField();
    public static void tabFrameKeyPaneProgramNameTextFieIdController(){
        textField.setId("tabFrameKeyPaneProgramNameTextFieId");
        textField.setPromptText("打包后的程序名建议英文");
        textField.setText("SnailCatMall");
        textField.setLayoutX(160);
        textField.setLayoutY(5);
        textField.setPrefWidth(350);
        textField.setPrefHeight(50);
    }
}
