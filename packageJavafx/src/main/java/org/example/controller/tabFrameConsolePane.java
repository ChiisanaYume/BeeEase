package org.example.controller;

import javafx.scene.layout.Pane;

/**
 * @see tabFrameConsolePane 这个是画布
 */
public class tabFrameConsolePane {
    public static Pane pane = new Pane();
    public static void tabFrameConsolePaneController(){
        pane.prefWidthProperty().bind(paneFramework.pane.prefWidthProperty());
        pane.prefHeightProperty().bind(paneFramework.pane.prefHeightProperty());
        addModule();
    }
    public static void addModule(){
        tabFrameConsolePaneOutTextArea.tabFrameConsolePaneOutTextAreaController();
        pane.getChildren().addAll(tabFrameConsolePaneOutTextArea.textArea);
    }
}
