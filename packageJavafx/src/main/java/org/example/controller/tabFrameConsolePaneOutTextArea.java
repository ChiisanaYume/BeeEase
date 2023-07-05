package org.example.controller;

import javafx.scene.control.TextArea;

public class tabFrameConsolePaneOutTextArea {
    public static TextArea textArea = new TextArea();
    public static void tabFrameConsolePaneOutTextAreaController(){
        textArea.setId("tabFrameConsolePaneOutTextArea");
        textArea.setPrefWidth(520);
        textArea.setPrefHeight(305);
        textArea.setEditable(false);
        textArea.setWrapText(true);
    }
}
