package com.faintdream.bee.test1.gui.javafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.File;
import java.io.IOException;

public class Demo40 extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("PDF 操作面板");

        // 创建布局
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(10);

        // 创建按钮
        Button createButton = new Button("创建 PDF");
        Button modifyButton = new Button("修改 PDF");

        // 按钮点击事件处理
        createButton.setOnAction(event -> createPDF());
        modifyButton.setOnAction(event -> modifyPDF());

        // 将按钮添加到布局
        vbox.getChildren().addAll(createButton, modifyButton);

        // 创建场景并设置到舞台
        Scene scene = new Scene(vbox, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // 创建 PDF 文件
    private void createPDF() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("保存 PDF");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF 文件", "*.pdf"));

        File file = fileChooser.showSaveDialog(null);
        if (file != null) {
            try {
                PDDocument document = new PDDocument();
                PDPage page = new PDPage();
                document.addPage(page);

                PDPageContentStream contentStream = new PDPageContentStream(document, page);
                contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
                contentStream.beginText();
                contentStream.newLineAtOffset(50, 700);
                contentStream.showText("Hello, PDFBox!");
                contentStream.endText();
                contentStream.close();

                document.save(file);
                document.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 修改 PDF 文件
    private void modifyPDF() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("选择 PDF");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF 文件", "*.pdf"));

        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            try {
                PDDocument document = PDDocument.load(file);

                // 在这里添加你的修改操作

                document.save(file);
                document.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
