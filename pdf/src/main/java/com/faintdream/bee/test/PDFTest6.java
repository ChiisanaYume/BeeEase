package com.faintdream.bee.test;

import com.faintdream.tool.util.IOUtil;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;

import java.io.File;
import java.util.Calendar;

/**
 * 获取pdf文件的属性
 * */
public class PDFTest6 {
    public static void main(String[] args) {
        try {

            File filePath = new File( IOUtil.getPathF("iria.pdf"));
            // System.out.println(filePath);

            // 加载PDF文件
            PDDocument document = PDDocument.load(filePath);

            PDDocumentInformation information = document.getDocumentInformation();

            show(information);

            information.setAuthor("faintdream@163.com");
            information.setTitle("Iria");
            information.setTitle("pdf测试");
            information.setCreator("PDFBox");

            // 设置修改日期为当前时间
            Calendar modifiedDate = Calendar.getInstance();
            information.setModificationDate(modifiedDate);

            document.save(filePath);
            show(information);

            // 关闭PDF文件
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void show(PDDocumentInformation info){
        System.out.println("-----");
        System.out.println("标题: " + info.getTitle());
        System.out.println("主题: " + info.getSubject());
        System.out.println("作者: " + info.getAuthor());
        System.out.println("开发工具: " + info.getCreator());
        System.out.println("关键字: " + info.getKeywords());
        System.out.println("创建日期: " + info.getCreationDate());
        System.out.println("修改日期: " + info.getModificationDate());
    }
}
