package com.faintdream.test1.gui.javafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.concurrent.atomic.AtomicBoolean;

public class Demo23 extends Application {
    /**
     * @param stage the primary stage for this application, onto which
     *                     the application scene can be set.
     *                     Applications may create other stages, if needed, but they will not be
     *                     primary stages.
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {

        BorderPane borderPane = new BorderPane();
        borderPane.setStyle("-fx-background-color: gray;");


        HBox top = new HBox();
        top.setStyle("-fx-background-color: BLUE;");
        top.setMinHeight(60);

        Text text = new Text("Welcome 进销存");
        text.setFont(Font.font("宋体", FontWeight.BOLD,20));
        top.setAlignment(Pos.CENTER);

        top.getChildren().add(text);
        borderPane.setTop(top);

        VBox left = new VBox(10);
        left.setPadding(new Insets(10));
        left.setStyle("-fx-background-color: PINK;");
        left.setMinHeight(100);
        Button system = new Button("系统设置");
        left.getChildren().addAll(system,new Button("商品管理"),new Button("关于我们"),new Button("联系我们"));


        borderPane.setLeft(left);


        GridPane center = new GridPane();
        center.setStyle("-fx-background-color: GREEN;");
        center.setMinWidth(400);
        center.setMinHeight(240);

        AtomicBoolean centerColorIs = new AtomicBoolean(true);
        system.setOnAction(e->{
            if(centerColorIs.get()){
                center.setStyle("-fx-background-color: pink;");
                centerColorIs.set(false);
            }else{
                center.setStyle("-fx-background-color: GREEN;");
                centerColorIs.set(true);
            }
        });

        borderPane.setCenter(center);


        HBox bottom = new HBox(15);
        bottom.setAlignment(Pos.CENTER);
        bottom.setPadding(new Insets(10));

        bottom.getChildren().add(new Button("系统设置"));
        bottom.getChildren().add(new Button("商品管理"));
        bottom.getChildren().add(new Button("关于我们"));
        bottom.getChildren().add(new Button("联系我们"));

        borderPane.setBottom(bottom);

        Scene scene = new Scene(borderPane,600,400);
        stage.setTitle("Demo23");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
