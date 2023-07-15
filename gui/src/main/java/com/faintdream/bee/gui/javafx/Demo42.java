package com.faintdream.bee.gui.javafx;
import javafx.scene.Scene;
import javafx.application.Application;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Demo42 extends Application{


    @Override
    public void start(Stage stage) throws Exception {
        // 创建菜单项
        MenuItem menuItem1 = new MenuItem("打开");
        MenuItem menuItem2 = new MenuItem("另存");
        MenuItem menuItem3 = new MenuItem("退出");

        // 创建菜单
        Menu menu = new Menu("文件");
        menu.getItems().addAll(menuItem1, menuItem2, menuItem3);

        // 创建菜单栏
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().add(menu);

        // 创建布局
        VBox vbox = new VBox(menuBar);

        // 创建场景
        Scene scene = new Scene(vbox, 400, 400);

        // 设置舞台
        stage.setTitle("JavaFX菜单示例");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
