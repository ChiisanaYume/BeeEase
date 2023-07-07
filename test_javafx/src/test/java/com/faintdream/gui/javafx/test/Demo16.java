package com.faintdream.gui.javafx.test;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.junit.Test;

public class Demo16 extends Application {
    @Test
    public void Test(){
        launch();
    }
    /**
     * @param stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        Group root = new Group();
        Scene scene = new Scene(root,300,150);

        stage.setScene(scene);
        stage.setTitle("Test Filed Sample");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(5);
        grid.setHgap(5);

        scene.setRoot(grid);

        final TextField name = new TextField();
        name.setPromptText("Enter you first name");
        name.setPrefColumnCount(10);
        name.getText();
        GridPane.setConstraints(name,0,0);
        grid.getChildren().add(name);

        stage.show();
    }
}
