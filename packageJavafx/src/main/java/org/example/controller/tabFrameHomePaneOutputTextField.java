package org.example.controller;

import javafx.scene.control.TextField;

/**
 * @see tabFrameHomePaneOutputTextField 输出目录存放地址
 */
public class tabFrameHomePaneOutputTextField {
    public static TextField textField = new TextField();
    public static void tabFrameHomePaneOutputTextFieldController() {
        textField.setId("tabFrameHomePaneOutputTextField");
        textField.setLayoutX(5);
        textField.setLayoutY(60);
        textField.setPrefWidth(350);
        textField.setPrefHeight(50);
        textField.setEditable(false);
        textField.setPromptText("选择打包存放位置");
    }
}
