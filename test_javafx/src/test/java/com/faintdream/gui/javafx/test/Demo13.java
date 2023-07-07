package com.faintdream.gui.javafx.test;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.InnerShadow;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.junit.Test;

public class Demo13 extends Application {
    /**
     * @param stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Keyboard");
        Group group = new Group();

        Scene scene = new Scene(group,530,300, Color.WHITE);

        StringProperty stringProperty = new SimpleStringProperty();

        InnerShadow shadowIs = new InnerShadow();
        shadowIs.setOffsetX(3.5);
        shadowIs.setOffsetY(3.5);

        Text status = new Text();
        status.setEffect(shadowIs);
        status.setX(100d);
        status.setY(100d);
        status.setFill(Color.LIME);
        status.setFont(Font.font(null, FontWeight.BOLD,35));
        status.setTranslateX(50d);

        status.textProperty().bind(stringProperty);
        stringProperty.set("Line\nLine2\nLine3");
        group.getChildren().add(status);

        stage.setScene(scene);
        stage.show();
    }

    @Test
    public void launchTest(){
        launch();
    }
}
