package com.faintdream.gui.javafx.test;

import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.junit.Test;

public class Demo18 extends Application {

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

        Button button = new Button("按钮");

        VBox root = new VBox();
        root.getChildren().add(button);

        Scene scene = new Scene(root,400,400);

        // 测试设置鼠标样式
        // scene.setCursor(Cursor.OPEN_HAND); // 手掌展开
        // scene.setCursor(Cursor.CLOSED_HAND); // 手掌半握
        // scene.setCursor(Cursor.CROSSHAIR); // 十字
        scene.setCursor(Cursor.HAND); // 手指点击
        // scene.setCursor(Cursor.WAIT); // 转圈圈
        // scene.setCursor(Cursor.H_RESIZE); // 双向箭头水平
        // scene.setCursor(Cursor.H_RESIZE); // 双向箭头垂直
        stage.setScene(scene);
        stage.setTitle("Scene 测试");
        stage.show();
    }

}
