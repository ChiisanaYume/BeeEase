package org.example.controller;

import javafx.scene.control.TextField;


public class tabFrameOptionalInstructionsTextFieId {
    public static TextField textField = new TextField();

    public static void tabFrameOptionalInstructionsTextFieIdController(){
        textField.setId("tabFrameOptionalInstructionsTextFieId");
        textField.setPromptText("应用程序的说明简介");
        textField.setText("程序版权归www.SnailCatMall.com蜗牛猫软件开发工作室公司所有。");
        textField.setLayoutX(160);
        textField.setLayoutY(5);
        textField.setPrefWidth(350);
        textField.setPrefHeight(50);
    }
}
