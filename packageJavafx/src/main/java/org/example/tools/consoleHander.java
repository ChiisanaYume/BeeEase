package org.example.tools;

import org.example.controller.tabFrameCommandPaneCodeTextArea;
import org.example.controller.tabFrameConsolePaneOutTextArea;
import org.example.controller.tabFrameHomePaneOutputButton;
import org.example.controller.tabFrameHomePaneVBoxButton;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class consoleHander {
    public static void consoleHanderController(){
        tabFrameHomePaneVBoxButton.button.setDisable(true);
        Thread thread = new Thread(new consoleHanderRunnable());
        thread.start();
    }
}
