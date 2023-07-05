package org.example.CollectMoneyBox;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.example.controller.run;

public class CollectMoneyStage {
    public Stage stage = new Stage();
    public void CollectMoneyStageController(Stage window,String title){
        stage.initOwner(window);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setAlwaysOnTop(true);
        stage.setTitle(title);
        stage.setWidth(400);
        stage.setHeight(500);
        stage.setResizable(false);
        CollectMoneyStagePane collectMoneyStagePane = new CollectMoneyStagePane();
        collectMoneyStagePane.CollectMoneyStagePaneController(stage);
        stage.setScene(new Scene(collectMoneyStagePane.pane));
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent windowEvent) {
                windowEvent.consume();
            }
        });
        stage.show();
    }
}
