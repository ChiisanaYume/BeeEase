package com.faintdream.bee.test1.gui.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;

public class Demo35 extends Application {

    @Override
    public void start(Stage primaryStage) {
        // 创建路径对象
        Path path = new Path();

        // 创建路径的起始点
        MoveTo moveTo = new MoveTo();
        moveTo.setX(50);
        moveTo.setY(50);

        // 创建线段1
        LineTo lineTo1 = new LineTo();
        lineTo1.setX(200);
        lineTo1.setY(50);

        // 创建线段2
        LineTo lineTo2 = new LineTo();
        lineTo2.setX(200);
        lineTo2.setY(200);

        // 创建线段3
        LineTo lineTo3 = new LineTo();
        lineTo3.setX(50);
        lineTo3.setY(200);

        // 将所有线段添加到路径中
        path.getElements().add(moveTo);
        path.getElements().addAll(lineTo1, lineTo2, lineTo3);

        // 设置路径的样式
        path.setStroke(Color.BLACK);
        path.setStrokeWidth(2);

        // 创建场景和布局
        Pane root = new Pane();
        root.getChildren().add(path);
        Scene scene = new Scene(root, 250, 250);

        // 设置场景到主舞台并显示
        primaryStage.setScene(scene);
        primaryStage.setTitle("Path Example");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
