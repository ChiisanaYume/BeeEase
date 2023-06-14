package com.faintdream.gui.javafx.test;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import org.junit.Test;

public class Demo06 extends Application {
    /**
     * @param stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {



        // 每个子节点之间的水平间距为25
        HBox hBox =new HBox(25);
        Scene scene = new Scene(hBox,300,250);

        Button button1 = new Button("按钮1");
        Button button2 = new Button("按钮2");
        Button button3 = new Button("按钮3");

        hBox.getChildren().addAll(button1,button2,button3);

        stage.setScene(scene);
        stage.show();
    }

    @Test
    public void launchTest(){
        launch();
    }
}
