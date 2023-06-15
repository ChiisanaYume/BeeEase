package com.faintdream.gui.javafx.test;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Objects;

public class Demo09 extends Application {
    /**
     * @param stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("JavaFX图片测试");

        InputStream input = new FileInputStream(getClassPath() + "Miyu.jpg");
        Image image = new Image(input);
        ImageView imageView = new ImageView(image);

        // 设置图片的大小
        imageView.setFitWidth(1138 / 2.0);
        imageView.setFitHeight(1500 / 2.0);

        Group group = new Group(imageView);
        Scene scene = new Scene(group, 1138 / 2.0, 1500 / 2.0);

        stage.setScene(scene);
        input.close();

        stage.show();

    }

    private static String getClassPath() {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        return Objects.requireNonNull(classLoader.getResource("")).getPath();
    }

    @Test
    public void test() {
        launch();
    }
}
