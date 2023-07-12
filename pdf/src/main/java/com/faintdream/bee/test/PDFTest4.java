package com.faintdream.bee.test;

import com.faintdream.tool.util.IOUtil;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import java.io.File;
import java.io.IOException;

/**
 * 尝试构建有图片的pdf
 * */
public class PDFTest4 {
    public static void main(String[] args) {
        try {
            // 创建空白的 PDF 文档
            PDDocument document = new PDDocument();

            // 创建一页
            PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);

            // 创建内容流
            PDPageContentStream contentStream = new PDPageContentStream(document, page);

            // 加载图片文件
            File imageFile = IOUtil.getFile("akuma.png");
            PDImageXObject image = PDImageXObject.createFromFileByContent(imageFile, document);

            // 获取图片宽度和高度
            float imageWidth = image.getWidth();
            float imageHeight = image.getHeight();

            // 设置图片位置和大小
            float x = 100;
            float y = 500;
            float width = 200;
            float height = (imageHeight / imageWidth) * width;

            // 绘制图片到 PDF
            contentStream.drawImage(image, x, y, width, height);

            // 关闭内容流
            contentStream.close();

            // 保存 PDF 文件
            document.save("output.pdf");

            // 关闭 PDF 文档
            document.close();

            System.out.println("图片已插入到 PDF 文件中");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
