package com.faintdream.test1.gui.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import com.faintdream.test1.gui.util.Tool;

import java.net.URL;
import java.util.Objects;

public class Demo30 extends Application {
    /**
     * @param stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {

        // 获取类的类加载器
        ClassLoader classLoader = getClass().getClassLoader();

        // 类路径
        URL fxmlUrl = classLoader.getResource("demo30.fxml");

        // 加载FXML文件
        Parent root = FXMLLoader.load(fxmlUrl);

        // 创建场景并应用css样式
        Scene scene = new Scene(root,400,300);
        scene.getStylesheets().add(ClassLoader.getSystemResource("style-30.css").getPath());

        // 设置舞台属性并显示舞台
        stage.setScene(scene);
        stage.setTitle(getClass().getSimpleName());
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
