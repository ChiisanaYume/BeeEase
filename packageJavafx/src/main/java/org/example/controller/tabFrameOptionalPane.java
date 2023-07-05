package org.example.controller;

import javafx.scene.layout.Pane;

public class tabFrameOptionalPane {
    public static Pane pane = new Pane();
    public static void tabFrameOptionalPaneController(){
        pane.prefWidthProperty().bind(paneFramework.pane.prefWidthProperty());
        pane.prefHeightProperty().bind(paneFramework.pane.prefHeightProperty());
        addModule();
    }
    public static void addModule(){
        tabFrameOptionalInstructionsLabel.tabFrameOptionalInstructionsLabelController();
        tabFrameOptionalInstructionsTextFieId.tabFrameOptionalInstructionsTextFieIdController();
        tabFrameOptionalPaneSupplierLabel.tabFrameOptionalPaneSupplierLabelController();
        tabFrameOptionalPaneSupplierTextFieId.tabFrameOptionalPaneSupplierTextFieIdController();
        tabFrameOptionalPaneIsInstallLabel.tabFrameOptionalPaneIsInstallLabelController();
        tabFrameOptionalPaneIsInstallCheckBox.tabFrameOptionalPaneIsInstallCheckBoxController();
        tabFrameOptionalPaneGeneratePackagingLabel.tabFrameOptionalPaneGeneratePackagingLabelController();
        tabFrameOptionalPaneGeneratePackagingButton.tabFrameOptionalPaneGeneratePackagingButtonController();
        pane.getChildren().addAll(tabFrameOptionalInstructionsLabel.label,tabFrameOptionalInstructionsTextFieId.textField,tabFrameOptionalPaneSupplierLabel.label,tabFrameOptionalPaneSupplierTextFieId.textField,tabFrameOptionalPaneIsInstallLabel.label,tabFrameOptionalPaneIsInstallCheckBox.checkBox,tabFrameOptionalPaneGeneratePackagingLabel.label, tabFrameOptionalPaneGeneratePackagingButton.button);
    }
}
