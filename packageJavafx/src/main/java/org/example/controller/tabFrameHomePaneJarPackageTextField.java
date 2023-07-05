package org.example.controller;

import javafx.scene.control.TextField;

public class tabFrameHomePaneJarPackageTextField {
    public static TextField textField = new TextField();
    public static void tabFrameHomePaneJarPackageTextFieldController() {
        textField.setId("tabFrameHomePaneJarPackageTextField");
        textField.setLayoutX(5);
        textField.setLayoutY(115);
        textField.setPrefWidth(350);
        textField.setPrefHeight(50);
        textField.setEditable(false);
        textField.setPromptText("选择需要打包的jar文件");
    }
}
