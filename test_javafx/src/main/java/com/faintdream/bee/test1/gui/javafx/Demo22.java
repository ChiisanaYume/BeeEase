package com.faintdream.bee.test1.gui.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Demo22 extends Application {
    /**
     * @param primaryStage the primary stage for this application, onto which
     *                     the application scene can be set.
     *                     Applications may create other stages, if needed, but they will not be
     *                     primary stages.
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {

        VBox vBox = new VBox(20);

        Scene scene = new Scene(vBox,500,500);

        DatePicker checkDatePicker = new DatePicker();
        vBox.getChildren().add(checkDatePicker);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Demo22");

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
