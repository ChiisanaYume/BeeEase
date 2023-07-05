package org.example.controller;

import javafx.scene.control.Tab;

/**
 * @see tabFrameOptional 可选参数配置一些不必要的参数
 */
public class tabFrameOptional {
    public static Tab tab = new Tab();
    public static void tabFrameOptionalController(){
        tab.setId("tabFrameOptional");
        tab.setClosable(false);
        tab.setText("可选参数");
        tabFrameOptionalPane.tabFrameOptionalPaneController();
        tab.setContent(tabFrameOptionalPane.pane);

    }
}
