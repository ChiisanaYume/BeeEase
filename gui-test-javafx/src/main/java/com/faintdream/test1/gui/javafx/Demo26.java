package com.faintdream.test1.gui.javafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Demo26 extends Application {
    /**
     * @param stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        // 舞台名称
        stage.setTitle("JavaFX Welcome");
        GridPane grid = new GridPane();

        // GridPane内容居中
        grid.setAlignment(Pos.CENTER);

        // 水平间距
        grid.setHgap(10d);

        // 垂直间距
        grid.setVgap(10d);

        // 填充:距离上下左右外框
        grid.setPadding(new Insets(25d,25d,25d,25d));

        Text sceneTitle = new Text("Welcome");
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL,20));

        // 0行
        // 0列
        // 占用两列
        // 占用一行
        grid.add(sceneTitle,0,0,2,1);

        Label userName = new Label("User Name:");
        grid.add(userName,0,1);

        TextField userTextField = new TextField();
        grid.add(userTextField,1,1);

        Label password = new Label("Password:");
        grid.add(password,0,2);

        PasswordField passwordField = new PasswordField();
        grid.add(passwordField,1,2);

        Button btn = new Button("Sign In");

        // 登录按钮方在水平布局中HBox中方便控制左右
        HBox hBoxBtn = new HBox(10);
        hBoxBtn.getChildren().add(btn);
        grid.add(hBoxBtn,1,4);

        final Text actionTarget = new Text();
        grid.add(actionTarget,1,6);

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                actionTarget.setFill(Color.FIREBRICK);
                actionTarget.setText("Sign in button pressed");
            }
        });

        Scene scene = new Scene(grid,300,225);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
