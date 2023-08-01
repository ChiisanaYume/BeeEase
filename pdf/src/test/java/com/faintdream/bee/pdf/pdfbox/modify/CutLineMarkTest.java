package com.faintdream.bee.pdf.pdfbox.modify;

import com.faintdream.tool.io.FileOperation;
import com.faintdream.tool.io.impl.DefFileOperation;
import com.faintdream.tool.util.IOUtil;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.*;

public class CutLineMarkTest {

    FileOperation oper = new DefFileOperation();

    @Test
    public void markingTest1() throws IOException {
        PDDocument document = PDDocument.load(oper.read("160X110 亿洲标牌0.8箭头铝 1块.pdf"));
        CutLineMark mark = new CutLineMark();
        PDDocument document2 = mark.Marking(document);

        document.save(getClass().getSimpleName() + "160X110 亿洲标牌0.8箭头铝 1块.pdf");
        document2.save(getClass().getSimpleName() + "markingTest1-2.pdf");

    }
    @Test
    @Ignore
    public void markingTest2() throws IOException {
        InputStream inputStream = oper.read("D:\\工作区w\\W打印\\2023\\08.01\\160X110 亿洲标牌0.8箭头铝 1块.pdf");
        System.out.println(oper);
        System.out.println(inputStream);
        PDDocument document = PDDocument.load(oper.read("D:\\工作区w\\W打印\\2023\\08.01\\160X110 亿洲标牌0.8箭头铝 1块.pdf"));
        CutLineMark mark = new CutLineMark();
        document = mark.Marking(document);

        document.save(getClass().getSimpleName() + "E:\\桌面\\160X110 亿洲标牌0.8箭头铝 1块.pdf");
    }
}