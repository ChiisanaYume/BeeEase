package com.faintdream.bee.test1.gui.javafx;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Demo27 extends Application {
    public static void main(String[] args) {
        launch();
    }

    /**
     * @param stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        Text actionTarget = new Text("Hello World");
        actionTarget.setFill(Color.BLACK);

        Button button = new Button("Check me");
        button.setOnAction((ActionEvent e)->{
            actionTarget.setFill(Color.FIREBRICK);
            actionTarget.setText("Sign in button pressed");

            PauseTransition pause = new PauseTransition(Duration.seconds(15));
            pause.setOnFinished((ActionEvent event) -> {
                actionTarget.setFill(Color.BLACK);
                actionTarget.setText("Hello World");
            });

            pause.play();
        });

        VBox root = new VBox();
        root.setAlignment(Pos.CENTER); // 设置垂直居中对齐
        root.getChildren().addAll(actionTarget,button);
        stage.setScene(new Scene(root,300,200));
        stage.show();
    }

}
