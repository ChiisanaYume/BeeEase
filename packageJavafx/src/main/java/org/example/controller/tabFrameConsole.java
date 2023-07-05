package org.example.controller;

import javafx.scene.control.Tab;

/**
 * @see tabFrameConsole 这个是控制台输出语句查看是否打包完成或者打包失败
 */
public class tabFrameConsole {
    public static Tab tab = new Tab();
    public static void tabFrameConsoleController(){
        tab.setId("tabFrameConsole");
        tab.setClosable(false);
        tab.setText("控制台输出");
        tabFrameConsolePane.tabFrameConsolePaneController();
        tab.setContent(tabFrameConsolePane.pane);
    }
}
