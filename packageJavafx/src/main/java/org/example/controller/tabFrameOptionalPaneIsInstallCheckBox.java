package org.example.controller;

import javafx.scene.control.CheckBox;

/**
 * @see tabFrameOptionalPaneIsInstallCheckBox
 */
public class tabFrameOptionalPaneIsInstallCheckBox {
    public static CheckBox checkBox = new CheckBox();
    public static void tabFrameOptionalPaneIsInstallCheckBoxController(){
        checkBox.setId("tabFrameOptionalPaneIsInstallCheckBox");
        checkBox.setText("是否为安装包");
        checkBox.setLayoutX(160);
        checkBox.setLayoutY(115);
        checkBox.setPrefWidth(350);
        checkBox.setPrefHeight(50);
        checkBox.setSelected(true);
    };
}
