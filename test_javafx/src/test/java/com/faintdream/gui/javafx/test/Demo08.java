package com.faintdream.gui.javafx.test;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import org.junit.Test;

import java.io.FileInputStream;
import java.util.Objects;

public class Demo08 extends Application {
    /**
     * @param stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("JavaFX测试");

        FileInputStream inputStream = new FileInputStream(getClassPath()+"纸箱.png");
        Image image = new Image(inputStream);

        ImageView imageView = new ImageView(image);

        imageView.setFitWidth(100);
        imageView.setFitHeight(100);

        Group group = new Group(imageView);
        Scene scene = new Scene(group,600,600);
        stage.setScene(scene);

        /*

        ┌-→ x
        ↓ y

        * */
        // 为stage添加事件
        stage.addEventHandler(KeyEvent.KEY_PRESSED,e->{
            if("W".equals(e.getCode().getName())){
                imageView.setLayoutY(imageView.getLayoutY()-3);
            }
            if("A".equals(e.getCode().getName())){
                imageView.setLayoutX(imageView.getLayoutX()-3);
            }
            if("S".equals(e.getCode().getName())){
                imageView.setLayoutY(imageView.getLayoutY()+3);
            }
            if("D".equals(e.getCode().getName())){
                imageView.setLayoutX(imageView.getLayoutX()+3);
            }
        });

        // 全屏显示舞台
        stage.setFullScreen(true);

        stage.show();
    }

    @Test
    public void launchTest(){
        launch();
    }

    private static String getClassPath(){
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        return Objects.requireNonNull(classLoader.getResource("")).getPath();
    }
}
