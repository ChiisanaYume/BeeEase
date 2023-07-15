package com.faintdream.bee.gui.javafx;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import java.net.URL;
import java.util.ResourceBundle;

public class ControlWindowController implements Initializable {

    @FXML
    private MenuBar menuBar;

    @FXML
    private MenuItem menuItem1;

    @FXML
    private MenuItem menuItem2;

    @FXML
    private MenuItem menuItem3;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // 在这里可以添加菜单项的事件处理逻辑
        menuItem1.setOnAction(event -> {
            System.out.println("点击了菜单项1");
        });
        menuItem2.setOnAction(event -> {
            System.out.println("点击了菜单项2");
        });
        menuItem3.setOnAction(event -> {
            System.out.println("点击了菜单项3");
        });
    }
}
