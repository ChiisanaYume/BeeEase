package org.example.tools;

import org.example.controller.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class consoleHanderRunnable implements Runnable{
    @Override
    public void run() {
        synchronized (consoleHanderRunnable.class){
            try {
                Runtime runtime = Runtime.getRuntime();
                Process process = runtime.exec(tabFrameHomePaneSdkTextField.textField.getText()+ tabFrameCommandPaneCodeTextArea.textArea.getText());
                BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream(), "GBK"));
                String line = null;
                process.waitFor();
                while ((line = input.readLine()) != null) {
                    tabFrameConsolePaneOutTextArea.textArea.setText(line);
                }
                while (process.exitValue()==0){
                    input.close();
                    tabFrameHomePaneVBoxButton.button.setDisable(false);
                    break;
                }
            } catch (Throwable t) {
                t.printStackTrace();
            }
        }
    }
}
