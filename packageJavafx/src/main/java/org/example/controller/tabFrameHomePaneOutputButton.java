package org.example.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;

/**
 * @see tabFrameHomePaneOutputButton 选择输出目录
 */
public class tabFrameHomePaneOutputButton {
    public static Button button = new Button();
    public static void tabFrameHomePaneOutputButtonController() {
        button.setId("tabFrameHomePaneOutputButton");
        button.setText("选择输出路径");
        button.setLayoutX(360);
        button.setLayoutY(60);
        button.setPrefWidth(150);
        button.setPrefHeight(50);
        addListenEvent();
    }
    public static void addListenEvent(){
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DirectoryChooser directoryChooser = new DirectoryChooser();
                directoryChooser.setTitle("选择输出目录");
                File directory = directoryChooser.showDialog(new Stage());
                if (directory != null) {
                    File isBin = new File(directory.getAbsolutePath()+"/output/");
                    if(!isBin.isDirectory()){
                        isBin.mkdirs();
                    }
                    tabFrameHomePaneOutputTextField.textField.setText(isBin.getPath());
                }
            }
        });
    }
}
