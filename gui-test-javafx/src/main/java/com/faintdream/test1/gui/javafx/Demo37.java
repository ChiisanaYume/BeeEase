package com.faintdream.test1.gui.javafx;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class Demo37 extends Application {
    /**
     * @param primaryStage the primary stage for this application, onto which
     *                     the application scene can be set.
     *                     Applications may create other stages, if needed, but they will not be
     *                     primary stages.
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("信息提示对话框");
        alert.setHeaderText("头部内容");
        alert.setContentText("文本内容");
        alert.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
