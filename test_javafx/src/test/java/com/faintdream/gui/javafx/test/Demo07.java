package com.faintdream.gui.javafx.test;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.junit.Test;

public class Demo07 extends Application {

    private static final double SCREEN_WIDTH = 1920.0d;
    private static final double SCREEN_HEIGHT = 1080.0d;
    /**
     * @param stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {

        // 宽高值
        final double WIDTH = 400d;
        final double HEIGHT = 400d;

        // 布局
        HBox hBox = new HBox();

        // 场景
        Scene scene = new Scene(hBox,WIDTH,HEIGHT);

        //----------------------------------------------------------------------------------------------------

        // 设置舞台名称
        stage.setTitle("测试窗口");

        // 设置舞台位置(屏幕正中间)
        stage.setX((SCREEN_WIDTH - WIDTH)/2);
        stage.setY((SCREEN_HEIGHT - HEIGHT)/2);

        // 设置舞台宽高(一般不会直接设置舞台宽高，而是通过场景来设置)
        // stage.setWidth(400);
        // stage.setHeight(400);

        // 设置舞台的风格
        stage.initStyle(StageStyle.DECORATED); // 默认
        // stage.initStyle(StageStyle.UNIFIED);
        // stage.initStyle(StageStyle.UNDECORATED); // 什么也没有
        // stage.initStyle(StageStyle.TRANSPARENT); // 透明
        // stage.initStyle(StageStyle.UTILITY); // 极简

        // 监听器
        stage.setOnCloseRequest((event)->{
            System.out.println("关闭窗口");
        });

        stage.setOnHidden(event->{
           System.out.println("窗口已经隐藏");
        });

        stage.setOnHiding(event->{
            System.out.println("窗口即将隐藏");
        });

        stage.setOnShowing(event->{
            System.out.println("窗口即将显示");
        });

        stage.setOnShown(event->{
           System.out.println("窗口已经显示");
        });

        // 设置场景
        stage.setScene(scene);

        // 全屏显示舞台
        // stage.setFullScreen(true);

        // 显示舞台
        stage.show();

        // 隐藏窗口
        // stage.hide();
        //----------------------------------------------------------------------------------------------------
    }
    @Test
    public void test(){
        launch();
    }
}
