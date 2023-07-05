package org.example.messagesbox;

import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * @see messageBox 消息框
 */
public class messageBox{
    public Stage stage = new Stage();
    /**
     * @param window 父窗体位置
     * @param title  窗体标题
     * @param value  窗体显示信息内容
     * @param width  设置内容宽度
     */
    public void messageController(Stage window,String title,String value,Integer width){
        stage.initOwner(window);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setAlwaysOnTop(true);
        stage.setTitle(title);
        stage.setWidth(width);
        stage.setHeight(220);
        stage.setResizable(false);
        messageBoxPane messageBoxPane = new messageBoxPane();
        messageBoxPane.messageBoxPaneController(stage,value);
        stage.setScene(new Scene(messageBoxPane.pane));
        stage.show();
    }
}
