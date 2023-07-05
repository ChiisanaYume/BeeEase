package org.example.controller;

import javafx.scene.control.Tab;

/**
 * @see tabFrameCommand
 * 显示当前展现的cmd命令行代码
 */
public class tabFrameCommand {
    public static Tab tab = new Tab();
    public static void tabFrameCommandController(){
        tab.setId("tabFrameCommand");
        tab.setClosable(false);
        tab.setText("命令行");
        tabFrameCommandPane.tabFrameCommandPaneController();
        tab.setContent(tabFrameCommandPane.pane);
    }
}
