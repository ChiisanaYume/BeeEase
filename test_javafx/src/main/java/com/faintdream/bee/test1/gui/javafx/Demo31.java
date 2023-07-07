package com.faintdream.bee.test1.gui.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class Demo31 extends Application {

    @Override
    public void start(Stage stage) throws Exception {


        // 网格布局
        GridPane gridPane = new GridPane();

        // 设置网格布局的样式类
        gridPane.getStyleClass().add("grid-pane");

        // 设置行数
        RowConstraints row1 = new RowConstraints();
        RowConstraints row2 = new RowConstraints();
        gridPane.getRowConstraints().addAll(row1,row2);

        // 设置列数
        ColumnConstraints col1 = new ColumnConstraints();
        ColumnConstraints col2 = new ColumnConstraints();
        ColumnConstraints col3 = new ColumnConstraints();
        gridPane.getColumnConstraints().addAll(col1,col2,col3);

        // 创建组件并添加到网格布局中
        Label label1 = new Label("Label 1");
        Label label2 = new Label("Label 2");
        Label label3 = new Label("Label 3");
        Label label4 = new Label("Label 4");
        Label label5 = new Label("Label 5");
        Label label6 = new Label("Label 6");

        // 将组件添加到网格布局的指定位置
        gridPane.add(label1,0,0);
        gridPane.add(label2,0,1);
        gridPane.add(label3,0,2);
        gridPane.add(label4,1,0);
        gridPane.add(label5,1,1);
        gridPane.add(label6,1,2);

        Scene scene = new Scene(gridPane,400,300);

        // 应用CSS样式
        scene.getStylesheets().add("style-31.css");

        stage.setScene(scene);
        stage.setTitle("GridPane Test");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
