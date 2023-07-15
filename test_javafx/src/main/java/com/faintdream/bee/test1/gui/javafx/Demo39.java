package com.faintdream.bee.test1.gui.javafx;

import javafx.application.Application;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Demo39 extends Application {

    @Override
    public void start(Stage primaryStage) {
        // 创建文件选择器
        FileChooser fileChooser = new FileChooser();

        // 设置文件选择器的标题
        fileChooser.setTitle("选择文件");

        // 显示文件选择窗口并获取选中的文件
        java.io.File selectedFile = fileChooser.showOpenDialog(primaryStage);

        if (selectedFile != null) {
            System.out.println("选中的文件路径：" + selectedFile.getAbsolutePath());
        } else {
            System.out.println("没有选中任何文件。");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
