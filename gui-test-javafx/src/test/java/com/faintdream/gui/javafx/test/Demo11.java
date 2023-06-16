package com.faintdream.gui.javafx.test;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.junit.Test;

public class Demo11 extends Application {
    /**
     * @param stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {

        stage.setTitle("Demo11");

        Circle circle = new Circle(40,40,30);
        Group root = new Group(circle);

        Scene scene = new Scene(root,800,400, Color.BEIGE);

        Text text1 = new Text(25,25,"HelloWorld");
        text1.setFill(Color.CHOCOLATE);
        text1.setFont(Font.font("宋体",25));

        root.getChildren().add(text1);
        stage.setScene(scene);
        stage.show();
    }

    @Test
    public void launchTest(){
        launch();
    }
}
