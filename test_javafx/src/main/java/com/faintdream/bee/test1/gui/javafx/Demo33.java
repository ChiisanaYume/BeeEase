package com.faintdream.bee.test1.gui.javafx;

import com.faintdream.tool.util.IOUtil;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class Demo33 extends Application {

    @Override
    public void start(Stage stage) throws Exception {


        // 网格布局
        GridPane gridPane = new GridPane();

        // 设置网格布局的样式类
        gridPane.getStyleClass().add("grid-pane");

        // 设置行高和列宽
        RowConstraints rowConstraints = new RowConstraints();
        rowConstraints.setPrefHeight(100); // 设置行高为100
        gridPane.getRowConstraints().add(rowConstraints);

        ColumnConstraints columnConstraints = new ColumnConstraints();
        columnConstraints.setPrefWidth(100); // 设置列宽为100
        gridPane.getColumnConstraints().add(columnConstraints);

        // 创建组件并添加到网格布局中
        Label label1 = new Label("Label 1");
        Label label2 = new Label("Label 2");
        Label label3 = new Label("Label 3");
        Label label4 = new Label("Label 4");
        Label label5 = new Label("Label 5");
        Label label6 = new Label("Label 6");

        // 给所有组件添加边框
        label1.getStyleClass().add("bordered-label");
        label2.getStyleClass().add("bordered-label");
        label3.getStyleClass().add("bordered-label");
        label4.getStyleClass().add("bordered-label");
        label5.getStyleClass().add("bordered-label");
        label6.getStyleClass().add("bordered-label");

        // 将组件添加到网格布局的指定位置
        gridPane.add(label1,0,0);
        gridPane.add(label2,1,0);
        gridPane.add(label3,3,0);
        gridPane.add(label4,0,1);
        gridPane.add(label5,1,1);
        gridPane.add(label6,2,1);

        Scene scene = new Scene(gridPane,300,200);

        // 应用CSS样式
        scene.getStylesheets().add("style-33.css");

        stage.setScene(scene);
        stage.getIcons().add(new Image(IOUtil.getInputStream("纸箱.png")));
        stage.setTitle("GridPane Test");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
