package com.faintdream.test1.gui.javafx;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Demo28 extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        PieChart pieChart = new PieChart();
        pieChart.setData(getCharData());

        stage.setTitle("PieChart");
        StackPane root = new StackPane();
        root.getChildren().add(pieChart);
        stage.setScene(new Scene(root,400,240));
        stage.show();
    }

    private ObservableList<PieChart.Data> getCharData() {
        ObservableList<PieChart.Data> answer = FXCollections.observableArrayList();
        answer.addAll(new PieChart.Data("java", 17.56),
                new PieChart.Data("javaFX", 31.37));
        return answer;

    }

    public static void main(String[] args) {
        launch(args);
    }
}
