package com.faintdream.test2.gui.javafx;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Demo02 extends Application {
    /**
     * @param stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {

        BorderPane root = new BorderPane();


        Button top = new Button("上");
        BorderPane.setAlignment(top, Pos.TOP_CENTER);
        BorderPane.setMargin(top, new Insets(10));
        top.setOnAction(eventHandler); // 添加按钮点击事件
        root.setTop(top);

        Button right = new Button("右");
        BorderPane.setAlignment(right, Pos.CENTER_RIGHT);
        BorderPane.setMargin(right, new Insets(10));
        right.setOnAction(eventHandler); // 添加按钮点击事件
        root.setRight(right);

        Button bottom = new Button("下");
        BorderPane.setAlignment(bottom, Pos.BOTTOM_CENTER);
        BorderPane.setMargin(bottom, new Insets(10));
        bottom.setOnAction(eventHandler); // 添加按钮点击事件
        root.setBottom(bottom);

        Button left = new Button("左");
        BorderPane.setAlignment(left, Pos.CENTER_LEFT);
        BorderPane.setMargin(left, new Insets(10));
        left.setOnAction(eventHandler); // 添加按钮点击事件
        root.setLeft(left);

        Button center = new Button("中");
        BorderPane.setAlignment(center, Pos.CENTER);
        BorderPane.setMargin(center, new Insets(10));
        center.setOnAction(eventHandler); // 添加按钮点击事件
        root.setCenter(center);

        Scene scene = new Scene(root,300,300);
        stage.setScene(scene);
        stage.setTitle(getClass().getSimpleName());
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    EventHandler<ActionEvent> eventHandler = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent actionEvent) {

            // System.out.println(actionEvent);

            if(actionEvent.getSource() instanceof Button ){
                Button sourceButton = (Button)actionEvent.getSource();
                String buttonText = sourceButton.getText();
                System.out.println(buttonText);
            }

        }
    };
}
