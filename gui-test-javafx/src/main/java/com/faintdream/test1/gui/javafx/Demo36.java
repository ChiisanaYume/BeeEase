package com.faintdream.test1.gui.javafx;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;

public class Demo36 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * @param stage the primary stage for this application, onto which
     *                     the application scene can be set.
     *                     Applications may create other stages, if needed, but they will not be
     *                     primary stages.
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("信息提示对话框");
        alert.setHeaderText("头部内容");
        alert.setContentText("文本内容");
        alert.show();
    }
}