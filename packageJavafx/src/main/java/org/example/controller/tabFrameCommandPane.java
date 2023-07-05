package org.example.controller;

import javafx.scene.layout.Pane;

/**
 * @see tabFrameCommandPane
 * 这个是画布
 */
public class tabFrameCommandPane {
    public static Pane pane = new Pane();
    public static void tabFrameCommandPaneController(){
        pane.setId("tabFrameCommandPane");
        pane.prefWidthProperty().bind(paneFramework.pane.prefWidthProperty());
        pane.prefHeightProperty().bind(paneFramework.pane.prefHeightProperty());
        addModule();
    }
    public static void addModule(){
        tabFrameCommandPaneCodeTextArea.tabFrameCommandPaneCodeTextAreaController();
        pane.getChildren().addAll(tabFrameCommandPaneCodeTextArea.textArea);
    }
}
