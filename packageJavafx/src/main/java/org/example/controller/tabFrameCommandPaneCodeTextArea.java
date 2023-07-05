package org.example.controller;

import javafx.scene.control.TextArea;

/**
 * @see tabFrameCommandPaneCodeTextArea
 */
public class tabFrameCommandPaneCodeTextArea {
    public static TextArea textArea = new TextArea();
    public static void tabFrameCommandPaneCodeTextAreaController(){
        textArea.setId("tabFrameCommandPaneCodeTextArea");
        textArea.setPrefWidth(520);
        textArea.setPrefHeight(305);
        textArea.setEditable(false);
        textArea.setWrapText(true);

    }
}
