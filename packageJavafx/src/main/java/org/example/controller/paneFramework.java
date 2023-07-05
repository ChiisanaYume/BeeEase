package org.example.controller;

import javafx.scene.layout.Pane;
/**
 * @author paneFramework
 * 此方法是使用pane的画板
 */
public class paneFramework {
    public static Pane pane = new Pane();
    public static void paneFrameworkController(){
        pane.setId("paneFramework");
        pane.setPrefWidth(run.window.getWidth());
        pane.setPrefHeight(run.window.getHeight());
        addModule();
    }
    public static void addModule(){
        tablePaneFramework.tablePaneFrameworkController();
        pane.getChildren().addAll(tablePaneFramework.tabPane);
    }
}
