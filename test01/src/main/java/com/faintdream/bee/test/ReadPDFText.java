package com.faintdream.bee.test;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class ReadPDFText {
    public static String getClassPath() {

        // 获取当前线程的类加载器
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        // 使用类加载器获取类路径
        return Objects.requireNonNull(classLoader.getResource("")).getPath();
    }

    public String getText(final File filePath) {

        // 存放读取的文件(文本)内容
        StringBuffer text = new StringBuffer();
        try {

            // 加载PDF文件
            PDDocument document = PDDocument.load(filePath);

            // 创建PDFTextStripper对象
            PDFTextStripper stripper = new PDFTextStripper();

            // 从第一页到最后一页逐页读取文本内容
            for (int page = 1; page <= document.getNumberOfPages(); page++) {
                stripper.setStartPage(page);
                stripper.setEndPage(page);

                // 添加页码标识
                text.append("Page ").append(page).append(":\n");

                // 提取当前页的文本内容
                text.append(stripper.getText(document));

            }

            // 关闭PDF文件
            document.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text.toString();
    }


}
