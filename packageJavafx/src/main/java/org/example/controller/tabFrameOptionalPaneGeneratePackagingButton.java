package org.example.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

import java.io.File;

/**
 * @see tabFrameOptionalPaneGeneratePackagingButton
 */
public class tabFrameOptionalPaneGeneratePackagingButton {
    public static Button button = new Button();
    public static void tabFrameOptionalPaneGeneratePackagingButtonController(){
        button.setId("tabFrameOptionalPaneGeneratePackagingButton");
        button.setText("生成配置");
        button.setLayoutX(160);
        button.setLayoutY(170);
        button.setPrefWidth(350);
        button.setPrefHeight(50);
        addListenEvent();
    }
    public static void addListenEvent(){
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String val ="";
                File file = new File(tabFrameHomePaneJarPackageTextField.textField.getText().trim());
                val = "jpackage.exe";
                val += " --type " + tabFrameKeyPaneTypeChoiceBox.choiceBox.getValue().toString().trim();
                val +=" --app-version " + tabFrameKeyPaneVersionNumberTextFieId.textField.getText().trim();
                val +=" --copyright " + tabFrameKeyPaneCopyrightTextFieId.textField.getText().trim();
                val +=" --description " +tabFrameOptionalInstructionsTextFieId.textField.getText().trim();
                val +=" --name " + tabFrameKeyPaneProgramNameTextFieId.textField.getText().trim();
                val +=" --dest " + tabFrameHomePaneOutputTextField.textField.getText().trim();
                val +=" --temp " + tabFrameHomePaneOutputTextField.textField.getText().trim();
                val +=" --vendor " + tabFrameOptionalPaneSupplierTextFieId.textField.getText().trim();
                val +=" --icon " + tabFrameHomePaneImagesPathTextFieId.textField.getText().trim();
                val +=" --input " +file.getParentFile()+"\\";
                val +=" --main-class " + tabFrameKeyPaneMainClassTextFieId.textField.getText().trim();
                val +=" --main-jar " + tabFrameHomePaneJarPackageTextField.textField.getText().trim();
                Boolean isInstall = tabFrameOptionalPaneIsInstallCheckBox.checkBox.isSelected();
                System.out.println(isInstall);
                if(isInstall){
                    val +=" --win-dir-chooser --win-menu --win-per-user-install --win-shortcut";
                }
                tabFrameCommandPaneCodeTextArea.textArea.setText(val);
            }
        });
    }
}
