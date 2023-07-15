package com.faintdream.bee.gui.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Demo41 extends Application {

    @Override
    public void start(Stage primaryStage) {
        // 创建文本输入框和按钮;
        Label label = new Label("请选择文件&文件夹：");
        TextField textField = new TextField();
        Button button = new Button("提交");

        // 注册按钮事件处理程序
        button.setOnAction(event -> {
            // 在这里执行提交操作
        });

        // 创建布局并将控件放入其中
        HBox hbox = new HBox(textField, button);

        VBox vbox = new VBox(label, hbox);

        // 创建场景并将布局放入其中
        Scene scene = new Scene(vbox, 300, 200);

        // 设置场景并显示舞台
        primaryStage.setTitle("JavaFX窗口示例");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

