package com.faintdream.test1.gui.javafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Demo21 extends Application {
    /**
     * @param stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        VBox vBox = new VBox();
        vBox.setSpacing(15);

        vBox.setPadding(new Insets(20,10,10,50));
        Button button1 = new Button("按钮A");
        Button button2 = new Button("按钮B");
        Button button3 = new Button("按钮C");
        Button button4 = new Button("按钮D");

        vBox.getChildren().addAll(button1,button2,button3,button4);
        Scene scene = new Scene(vBox,400,200);

        stage.setScene(scene);
        stage.setTitle("Demo21");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
