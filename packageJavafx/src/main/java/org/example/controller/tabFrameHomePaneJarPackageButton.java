package org.example.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

/**
 * @see tabFrameHomePaneJarPackageButton 选择器 选择jar地址
 */
public class tabFrameHomePaneJarPackageButton {
    public static Button button = new Button();
    public static void tabFrameHomePaneJarPackageButtonController(){
        button.setId("tabFrameHomePaneJarPackageButton");
        button.setText("选择要打包的JAR文件");
        button.setLayoutX(360);
        button.setLayoutY(115);
        button.setPrefWidth(150);
        button.setPrefHeight(50);
        addListenEvent();
    }
    public static void addListenEvent(){
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("选择jar包位置");
                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("JAR files (*.jar)", "*.jar");
                fileChooser.getExtensionFilters().add(extFilter);
                File directory = fileChooser.showOpenDialog(new Stage());
                if (directory != null) {
                    tabFrameHomePaneJarPackageTextField.textField.setText(directory.getAbsolutePath());
                }
            }
        });
    }
}
