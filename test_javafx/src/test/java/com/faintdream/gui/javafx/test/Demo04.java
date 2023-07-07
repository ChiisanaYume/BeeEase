package com.faintdream.gui.javafx.test;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

public class Demo04 extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        VBox box = new VBox();
        final Scene scene = new Scene(box, 300, 250);
        scene.setFill(null);

        Line line = new Line();
        line.setStartX(0.0f);
        line.setStartY(0.0f);
        line.setEndX(100.0f);
        line.setEndY(100.0f);

        box.getChildren().add(line);

        stage.setScene(scene);
        stage.show();

        getParametersTest();
    }

    @Ignore
    @Test
    /**
     * 测试launch()的参数
     * */
    public void getParametersTest() {
        Parameters parameters = getParameters();
        System.out.println(parameters);
        List<String> unnamedParams = parameters.getUnnamed();

        if (!unnamedParams.isEmpty()) {
            for (String text : unnamedParams) {
                System.out.println(text);
            }
        }
    }

    @Test
    public void Domo04Test() {
        // 测试launch()的参数
        launch("JavaFX", "Spring");
    }


}
