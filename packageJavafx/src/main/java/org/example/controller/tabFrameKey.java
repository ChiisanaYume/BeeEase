package org.example.controller;

import javafx.scene.control.Tab;

/**
 * @author tabFrameKey 关键的选项卡
 */
public class tabFrameKey {
    public static Tab tab = new Tab();
    public static void tabFrameKeyController(){
        tab.setId("tabFrameKey");
        tab.setClosable(false);
        tab.setText("必填参数");
        tabFrameKeyPane.tabFrameKeyPaneController();
        tab.setContent(tabFrameKeyPane.pane);
    }
}
