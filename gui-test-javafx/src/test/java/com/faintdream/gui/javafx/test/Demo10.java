package com.faintdream.gui.javafx.test;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.junit.Test;

public class Demo10 extends Application {

    @Test
    public void test(){
        launch();
    }
    /**
     * @param stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {

        stage.setTitle("Drawing Text");
        Group root = new Group();
        Group group = new Group();

        Scene scene= new Scene(root,300,250, Color.WHITE);

        Text text = new Text();
        text.setCache(true);
        text.setX(10.0);
        text.setY(70.0);
        text.setFill(Color.RED);
        text.setText("JavaFX SuKi");
        text.setFont(Font.font(null, FontWeight.BOLD,32));

        group.getChildren().add(text);
        root.getChildren().add(text);

        stage.setScene(scene);

        stage.show();

    }


}
