package com.faintdream.test1.gui.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class Demo32 extends Application {

    @Override
    public void start(Stage stage) {
        // 创建网格布局
        GridPane gridPane = new GridPane();

        // 设置行高和列宽
        RowConstraints rowConstraints = new RowConstraints();
        rowConstraints.setPrefHeight(50); // 设置行高为50
        gridPane.getRowConstraints().add(rowConstraints);

        ColumnConstraints columnConstraints = new ColumnConstraints();
        columnConstraints.setPrefWidth(100); // 设置列宽为100
        gridPane.getColumnConstraints().add(columnConstraints);

        // 添加标签到网格布局
        Label label = new Label("Cell");
        gridPane.add(label, 0, 0); // 添加到第一行第一列

        // 创建场景并显示舞台
        Scene scene = new Scene(gridPane, 200, 200);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
