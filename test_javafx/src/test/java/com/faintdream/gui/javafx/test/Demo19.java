package com.faintdream.gui.javafx.test;

import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

public class Demo19 extends Application {

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

        // 创建图标并设置到窗口
        FileInputStream inputStream = new FileInputStream(getClassPath()+"纸箱.png");
        Image icon = new Image(inputStream);
        inputStream.close();

        stage.getIcons().add(icon);

        stage.setScene(scene);
        stage.setTitle("Scene 测试");
        stage.show();

    }


    private String getClassPath(){
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        return Objects.requireNonNull(systemClassLoader.getResource("")).getPath();
    }

    protected Image loadImageFromResource(String resourceName) {
        URL resourceUrl = this.getClass().getResource(resourceName);
        if (resourceUrl != null) {
            return new Image(resourceUrl.toExternalForm());
        }
        return null;
    }
}
