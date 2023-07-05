package org.example.controller;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.example.CollectMoneyBox.CollectMoneyStage;
import org.example.messagesbox.messageBox;


/**
 * @author run
 * javafx启动窗口
 *
 */
public class run extends Application{
    public static Stage window;
    @Override
    public void start(Stage stage) throws Exception {
        window = stage;
        window.setTitle("【蜗牛猫软件开发工作室】javafx自定义打包工具X64 SDK16");
        window.setWidth(533);
        window.setHeight(400);
        window.setResizable(false);
        CollectMoneyStage collectMoneyStage = new CollectMoneyStage();
        collectMoneyStage.CollectMoneyStageController(window,"服务码");
        messageBox messageBox = new messageBox();
        messageBox.messageController(window,"支付宝收款码","为了孩子的奶粉钱、尿布钱、请大佬打赏一点把。",600);
        paneFramework.paneFrameworkController();
        window.setScene(new Scene(paneFramework.pane));
        window.getScene().getStylesheets().addAll(this.getClass().getClassLoader().getResource("style.css").toExternalForm());
        window.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent windowEvent) {
                System.gc();
                System.exit(0);
            }
        });
        window.show();

    }
}