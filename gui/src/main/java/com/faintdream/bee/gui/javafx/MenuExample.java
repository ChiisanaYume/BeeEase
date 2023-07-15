package com.faintdream.bee.gui.javafx;

import com.faintdream.tool.util.IOUtil;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;

public class MenuExample extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        File file = IOUtil.getFile("controlWindow.fxml");
        System.out.println(file.exists());
        URL url = file.toURI().toURL();
        System.out.println(url);
        Parent root = FXMLLoader.load(url);
        Scene scene = new Scene(root, 400, 300);
        primaryStage.setTitle("JavaFX菜单示例");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
