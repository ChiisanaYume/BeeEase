package org.example.controller;

import javafx.scene.control.TextField;

/**
 * @see tabFrameHomePaneSdkTextField 选择SDK路径后存放的编辑框
 */
public class tabFrameHomePaneSdkTextField {
    public static TextField textField = new TextField();
    public static void tabFrameHomePaneSdkTextFieldController() {
        textField.setId("tabFrameHomePaneSdkTextField");
        textField.setLayoutX(5);
        textField.setLayoutY(5);
        textField.setPrefWidth(350);
        textField.setPrefHeight(50);
        textField.setEditable(false);
        textField.setPromptText("选择 JAVA SE 16的路径");
    }
}
