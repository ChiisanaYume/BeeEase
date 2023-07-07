package com.faintdream.gui.javafx.test;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Demo02 extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        // 舞台(舞台可以设置标题)
        stage.setTitle("测试javaFX");

        // 布局
        HBox hBox = new HBox();

        // 场景(添加布局到场景)
        Scene scene = new Scene(hBox,400,200);

        // 控件
        Button button = new Button("登录");

        // 添加控件到布局
        hBox.getChildren().add(button); // 添加控件

        // 添加场景到舞台
        stage.setScene(scene);

        // 展示舞台
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
