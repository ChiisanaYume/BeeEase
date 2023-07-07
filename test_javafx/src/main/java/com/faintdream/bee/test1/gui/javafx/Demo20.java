package com.faintdream.bee.test1.gui.javafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class Demo20 extends Application {
    /**
     * The main entry point for all JavaFX applications.
     * The start method is called after the init method has returned,
     * and after the system is ready for the application to begin running.
     *
     * <p>
     * NOTE: This method is called on the JavaFX Application Thread.
     * </p>
     *
     * @param primaryStage the primary stage for this application, onto which
     *                     the application scene can be set.
     *                     Applications may create other stages, if needed, but they will not be
     *                     primary stages.
     * @throws Exception if something goes wrong
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        // 水平布局，内容都是水平摆放的
        HBox hbox = new HBox(10);

        // 设置padding
        // hbox.setPadding(new Insets(10));
        hbox.setPadding(new Insets(100,10,10,50));// 上 右 下 左 顺时针



        // 组件
        Button[] buttons = {new Button("按钮1"),new Button("按钮2"),new Button("按钮3")};
        TextField textField = new TextField();

        hbox.getChildren().addAll(buttons[0],buttons[1],buttons[2],textField);

        //
        HBox.setHgrow(textField, Priority.ALWAYS);

        Scene scene = new Scene(hbox,600,400);
        primaryStage.setTitle("测试");
        primaryStage.setScene(scene);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }

}
