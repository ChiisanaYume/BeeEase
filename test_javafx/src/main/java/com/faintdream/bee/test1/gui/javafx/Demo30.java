package com.faintdream.bee.test1.gui.javafx;

import com.faintdream.tool.util.IOUtil;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.net.URL;

public class Demo30 extends Application {
    /**
     * @param stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {

        // FXML配置文件URL
        URL fxmlUrl = IOUtil.getURL("demo30.fxml");

        // 加载FXML文件
        Parent root = FXMLLoader.load(fxmlUrl);

        // 创建场景并应用css样式
        Scene scene = new Scene(root,400,300);

        scene.getStylesheets().add("style-30.css"); // 这个路径式相对于类路径的相对路径

        // 设置舞台属性并显示舞台
        stage.setScene(scene);
        stage.setTitle(getClass().getSimpleName());
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
        // new Demo30().test01();
    }

    private void test01(){
        ClassLoader classLoader1 = this.getClass().getClassLoader();
        ClassLoader classLoader2 = IOUtil.getClassLoader();
        System.out.println(classLoader1);
        System.out.println(classLoader2);
        System.out.println(classLoader1.equals(classLoader2));
    }
}
