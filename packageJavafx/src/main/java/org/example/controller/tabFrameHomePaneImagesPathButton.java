package org.example.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class tabFrameHomePaneImagesPathButton {
    public static Button button = new Button();
    public static void tabFrameHomePaneImagesPathButtonController(){
        button.setId("tabFrameHomePaneImagesPathButton");
        button.setText("选择程序图标");
        button.setLayoutX(360);
        button.setLayoutY(170);
        button.setPrefWidth(150);
        button.setPrefHeight(50);
        addListenEvent();
    };
    public static void addListenEvent(){
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("选择ICO图标");
                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("ICO files (*.ico)", "*.ico");
                fileChooser.getExtensionFilters().add(extFilter);
                File directory = fileChooser.showOpenDialog(new Stage());
                if (directory != null) {
                    tabFrameHomePaneImagesPathTextFieId.textField.setText(directory.getAbsolutePath());
                }
            }
        });
    }
}
