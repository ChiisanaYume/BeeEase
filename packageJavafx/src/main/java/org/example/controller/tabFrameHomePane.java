package org.example.controller;

import javafx.scene.layout.Pane;

/**
 * @author tabFrameHomePane 画布
 */
public class tabFrameHomePane {
    public static Pane pane = new Pane();
    public static void tabFrameHomePaneController(){
        pane.prefWidthProperty().bind(paneFramework.pane.prefWidthProperty());
        pane.prefHeightProperty().bind(paneFramework.pane.prefHeightProperty());
        addModule();
    }
    public static void addModule(){
        tabFrameHomePaneSdkTextField.tabFrameHomePaneSdkTextFieldController();
        tabFrameHomePaneSdkButton.tabFrameHomePaneSdkButtonController();
        tabFrameHomePaneOutputButton.tabFrameHomePaneOutputButtonController();
        tabFrameHomePaneOutputTextField.tabFrameHomePaneOutputTextFieldController();
        tabFrameHomePaneJarPackageButton.tabFrameHomePaneJarPackageButtonController();
        tabFrameHomePaneJarPackageTextField.tabFrameHomePaneJarPackageTextFieldController();
        tabFrameHomePaneVBox.tabFrameHomePaneVBoxController();
        tabFrameHomePaneImagesPathTextFieId.tabFrameHomePaneImagesPathTextFieIdController();
        tabFrameHomePaneImagesPathButton.tabFrameHomePaneImagesPathButtonController();
        pane.getChildren().addAll(tabFrameHomePaneSdkTextField.textField,tabFrameHomePaneSdkButton.button,tabFrameHomePaneOutputButton.button,tabFrameHomePaneOutputTextField.textField,tabFrameHomePaneJarPackageButton.button,tabFrameHomePaneJarPackageTextField.textField,tabFrameHomePaneVBox.vBox,tabFrameHomePaneImagesPathTextFieId.textField,tabFrameHomePaneImagesPathButton.button);
    }
}
