package com.faintdream.gui.javafx.test;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import org.junit.Test;

import java.awt.*;

public class Demo17 extends Application {

    @Test
    public void launchTest(){
        launch();
    }
    /**
     * @param stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        // 创建根节点
        HBox root = new HBox();

        // 创建其他UI元素
        Button button = new Button("按钮");

        // 为按钮绑定事件
        button.addEventFilter(ActionEvent.ACTION, event->{
            System.out.println("按钮被点击了");
        });

        // 将其他UI元素添加到根节点
        root.getChildren().add(button);

        // 创建场景并设置根节点
        Scene scene = new Scene(root,400,300);

        // 设置舞台标题和场景
        stage.setTitle("JavaFx Demo17");
        stage.setScene(scene);

        stage.show();
    }
}
