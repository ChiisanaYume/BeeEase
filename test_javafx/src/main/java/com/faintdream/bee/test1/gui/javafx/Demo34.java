package com.faintdream.bee.test1.gui.javafx;

import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.ClosePath;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Demo34 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * @param stage the primary stage for this application, onto which
     *              the application scene can be set.
     *              Applications may create other stages, if needed, but they will not be
     *              primary stages.
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        Pane root = new Pane();
        Scene scene = new Scene(root, 400, 400);
        stage.setScene(scene);
        stage.setTitle(getClass().getSimpleName());

        Path path = new Path();
        MoveTo moveTo = new MoveTo(100, 100);
        LineTo lineTo1 = new LineTo(100, 120);
        LineTo lineTo2 = new LineTo(120, 120);
        LineTo lineTo3 = new LineTo(120, 100);
        ClosePath closePath = new ClosePath();
        path.getElements().addAll(moveTo, lineTo1, lineTo2, lineTo3, closePath);
        root.getChildren().add(path);

        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.seconds(2));
        pathTransition.setNode(root);
        pathTransition.setPath(path);
        pathTransition.setInterpolator(Interpolator.LINEAR);

        pathTransition.play();

        stage.show();
    }
}


