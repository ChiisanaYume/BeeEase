package com.faintdream.gui.javafx.test;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.junit.Test;

import java.awt.*;

public class Demo14 extends Application {

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
        // 创建文本和按钮
        Label label = new Label("请确认");
        Button button = new Button("确认");

        // 空白
        Region region = new Region();

        // 设置空白的最小宽高
        region.setMinWidth(50);
        region.setMinHeight(20);

        // 创建按钮点击事件的处理程序
        EventHandler<ActionEvent> eventHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("确认按钮被点击了");
            }

        };

        // 将事件处理程序绑定到按钮
        button.setOnAction(eventHandler);

        // 创建垂直布局并添加文本和按钮
        VBox root = new VBox();
        HBox labelContainer = new HBox();
        labelContainer.getChildren().add(label);
        root.getChildren().addAll(labelContainer,region, button);

        // 设置布局对齐属性为居中
        labelContainer.setAlignment(Pos.CENTER);
        root.setAlignment(Pos.CENTER);

        // 创建场景并设置根节点
        Scene scene = new Scene(root,200,100);

        // 设置舞台标题和场景
        stage.setTitle("JavaFX Test");
        stage.setScene(scene);

        // 设置舞台的大小不可改变
        stage.setResizable(false);
        // 显示窗口
        stage.show();

    }
}
