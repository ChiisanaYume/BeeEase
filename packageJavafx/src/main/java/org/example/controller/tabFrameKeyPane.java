package org.example.controller;

import javafx.scene.layout.Pane;

/**
 * @author tabFrameKeyPane 画布
 */
public class tabFrameKeyPane {
    public static Pane pane = new Pane();
    public static void tabFrameKeyPaneController(){
        pane.prefWidthProperty().bind(paneFramework.pane.prefWidthProperty());
        pane.prefHeightProperty().bind(paneFramework.pane.prefHeightProperty());
        addModule();
    }
    public static void addModule(){
        tabFrameKeyPaneProgramNameLabel.tabFrameKeyPaneProgramNameLabelController();
        tabFrameKeyPaneProgramNameTextFieId.tabFrameKeyPaneProgramNameTextFieIdController();
        tabFrameKeyPaneMainClassLabel.tabFrameKeyPaneMainClassLabelController();
        tabFrameKeyPaneMainClassTextFieId.tabFrameKeyPaneMainClassTextFieIdController();
        tabFrameKeyPaneTypeLabel.tabFrameKeyPaneTypeLabelController();
        tabFrameKeyPaneTypeChoiceBox.tabFrameKeyPaneTypeChoiceBoxController();
        tabFrameKeyPaneVersionNumberLabel.tabFrameKeyPaneVersionNumberLabelController();
        tabFrameKeyPaneVersionNumberTextFieId.tabFrameKeyPaneVersionNumberTextFieIdController();
        tabFrameKeyPaneCopyrightLabel.tabFrameKeyPaneCopyrightLabelController();
        tabFrameKeyPaneCopyrightTextFieId.tabFrameKeyPaneCopyrightTextFieIdController();
        pane.getChildren().addAll(tabFrameKeyPaneProgramNameLabel.label, tabFrameKeyPaneProgramNameTextFieId.textField,tabFrameKeyPaneMainClassLabel.label,tabFrameKeyPaneMainClassTextFieId.textField,tabFrameKeyPaneTypeLabel.label,tabFrameKeyPaneTypeChoiceBox.choiceBox,tabFrameKeyPaneVersionNumberLabel.label,tabFrameKeyPaneVersionNumberTextFieId.textField,tabFrameKeyPaneCopyrightLabel.label,tabFrameKeyPaneCopyrightTextFieId.textField);
    }
}
