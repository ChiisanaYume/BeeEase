package com.faintdream.bee.test1.gui.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Demo24 extends Application {
    /**
     * @param stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {

        BorderPane root = new BorderPane();

        Button top = new Button("Top");
        root.setTop(top);

        Button right = new Button("right");
        root.setRight(right);

        Button bottom = new Button("bottom");
        root.setBottom(bottom);

        Button left = new Button("left");
        root.setLeft(left);

        Scene scene = new Scene(root,300,200);
        stage.setScene(scene);
        stage.setTitle(getClass().getSimpleName());
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
