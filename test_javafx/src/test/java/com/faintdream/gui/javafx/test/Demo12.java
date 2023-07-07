package com.faintdream.gui.javafx.test;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.Reflection;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.junit.Test;

public class Demo12 extends Application{

    /**
     * @param stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Demo12");

        Group root = new Group();
        Scene scene = new Scene(root,400,250, Color.PINK);

        Text t = new Text();
        t.setX(10d);
        t.setY(50d);
        t.setCache(true);
        t.setText("This is a test");
        t.setFill(Color.RED);
        t.setFont(Font.font(null, FontWeight.BOLD,30));

        Reflection r = new Reflection();
        r.setFraction(0.7);

        t.setEffect(r);

        root.getChildren().add(t);
        stage.setScene(scene);
        stage.show();


    }

    @Test
    public void launchTest(){
        launch();
    }
}