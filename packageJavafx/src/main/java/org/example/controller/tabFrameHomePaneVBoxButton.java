package org.example.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import org.example.messagesbox.messageBox;
import org.example.tools.consoleHander;

/**
 * @see tabFrameHomePaneVBoxButton
 */
public class tabFrameHomePaneVBoxButton {
    public static Button button = new Button();
    public static void tabFrameHomePaneVBoxButtonController(){
        button.setId("tabFrameHomePaneVBoxButton");
        button.setText("开始打包");
        button.prefWidthProperty().bind(paneFramework.pane.prefWidthProperty());
        button.setPrefHeight(50);
        addModule();
    }
    public static void addModule(){
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if("".equals(tabFrameCommandPaneCodeTextArea.textArea.getText())){
                    messageBox messageBox = new messageBox();
                    messageBox.messageController(run.window,"温馨提示","请【生成配置】，配置过程中【不允许有空格】，所有信息必须填满",700);
                   return;
                }
                consoleHander.consoleHanderController();
            }
        });

    }
}
