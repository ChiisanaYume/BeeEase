package org.example.controller;

import javafx.scene.control.Tab;

/**
 * @author tabFrameHome 首页第一张选项卡
 */
public class tabFrameHome {
    public static Tab tab = new Tab();
    public static void tabFrameHomeController(){
        tab.setId("tabFrameHome");
        tab.setClosable(false);
        tab.setText("首页");
        tabFrameHomePane.tabFrameHomePaneController();
        tab.setContent(tabFrameHomePane.pane);
    }
}
