package com.faintdream.gui.javafx.test;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.junit.Test;

/**
 * Java FX 测试
 * @author faintdream
 * @version 1.0
 * */
public class Demo03 extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        // 舞台(舞台设置标题)
        stage.setTitle("Drawing Text");

        // 创建一个名为 root 的 Group 容器
        Group root = new Group();

        // 创建一个场景(把Group容器(root)加入场景，并设置场景的宽度，高度，以及背景色);
        Scene scene = new Scene(root, 300, 250, Color.WHITE);

        int x = 120;
        int y = 120;

        int red = 30;
        int green = 40;
        int blue = 50;

        // 创建一个文本节点(Text)并赋值
        Text text = new Text(x,y,"JavaFx 2.0");

        // 设置文本节点的填充色
        text.setFill(Color.rgb(red,green,blue,0.99));

        // 设置文件节点的旋转角度(逆时针)
        text.setRotate(45);

        // 文本节点添加到根接单
        root.getChildren().add(text);

        // 场景添加到舞台
        stage.setScene(scene);

        // 显示舞台，将应用程序的图形界面展示给用户
        stage.show();
    }

    // (窗口长+组件长)/2 = 组件居中的X坐标
    @Test
    public void TextTest() {
        launch();
    }

}
