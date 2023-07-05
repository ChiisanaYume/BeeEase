package org.example.controller;

import javafx.scene.control.TabPane;

/**
 * @author tablePaneFramework 选项卡外框
 */
public class tablePaneFramework {
    public static TabPane tabPane = new TabPane();
    public static void tablePaneFrameworkController(){
        tabPane.setId("tablePaneFramework");
        tabPane.prefWidthProperty().bind(paneFramework.pane.prefWidthProperty());
        tabPane.prefHeightProperty().bind(paneFramework.pane.prefHeightProperty());
        tabFrameHome.tabFrameHomeController();
        tabFrameKey.tabFrameKeyController();
        tabFrameOptional.tabFrameOptionalController();
        tabFrameCommand.tabFrameCommandController();
        tabFrameConsole.tabFrameConsoleController();
        tabPane.getTabs().addAll(tabFrameHome.tab,tabFrameKey.tab,tabFrameOptional.tab,tabFrameCommand.tab,tabFrameConsole.tab);
    }
}
