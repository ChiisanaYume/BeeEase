package com.faintdream.test1.gui.javafx;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Demo29 extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    /**
     * @param stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        // 创建文本框和按钮
        TextField nameField = new TextField();
        Button submitButton = new Button("提交");

        // 创建标签
        Label nameLabel = new Label("名字:");
        Label massageLabel = new Label();

        // 设置标签样式
        massageLabel.setStyle("-fx-text-fill: blue;");


        // 创建水平布局并设置间距和边距
        HBox inputBox = new HBox(10,nameLabel,nameField);

        // 创建垂直不在并设置间距和边距
        VBox root = new VBox(20,inputBox,submitButton,massageLabel);
        root.setPadding(new Insets(20));

        // 设置按钮点击事件
        submitButton.setOnAction(e->{
            String name = nameField.getText();
            if(!"".equals(name)){
                massageLabel.setText("Hello, " + name + "！！！");
                PauseTransition pause = new PauseTransition(Duration.seconds(15));
                pause.setOnFinished(event -> {
                    // 在暂停结束后执行的操作
                    massageLabel.setText("");
                });
                pause.play();

            }

        });

        // 创建场景并指定根节点
        Scene scene = new Scene(root,300,200);


        stage.setTitle(getClass().getSimpleName());
        stage.setScene(scene);
        stage.show();
    }
}
