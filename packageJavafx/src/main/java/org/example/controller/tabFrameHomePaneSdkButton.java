package org.example.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import org.example.messagesbox.messageBox;

import java.io.File;

/**
 * @see tabFrameHomePaneSdkButton 这个是选择SDK路径
 */
public class tabFrameHomePaneSdkButton {
    public static Button button = new Button();
    public static void tabFrameHomePaneSdkButtonController() {
        button.setId("tabFrameHomePaneSdkButton");
        button.setText("选择SDK目录");
        button.setLayoutX(360);
        button.setLayoutY(5);
        button.setPrefWidth(150);
        button.setPrefHeight(50);
        addListenEvent();
    }
    public static void addListenEvent(){
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DirectoryChooser directoryChooser = new DirectoryChooser();
                directoryChooser.setTitle("选择SDK");
                File directory = directoryChooser.showDialog(new Stage());
                if (directory != null) {
                    File isBin = new File(directory.getAbsolutePath()+"/bin/jpackage.exe");
                    if(!isBin.isFile()){
                        tabFrameHomePaneSdkTextField.textField.setText("");
                        messageBox messageBox = new messageBox();
                        messageBox.messageController(run.window,"温馨提示","请选择正确的SDK路径",500);
                    }else {
                        messageBox messageBox = new messageBox();
                        messageBox.messageController(run.window,"温馨提示","路径正确请继续配置其他选项",500);
                        tabFrameHomePaneSdkTextField.textField.setText(directory.getAbsolutePath()+"\\bin\\");
                    }
                }
            }
        });
    }
}
