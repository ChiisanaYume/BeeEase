package com.faintdream.bee.pdf.pdfbox.modify;

import com.faintdream.tool.io.FilesRead;
import com.faintdream.tool.io.impl.DefFilesRead;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.After;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class CutLineMarkTest {

    FilesRead oper = new DefFilesRead();

    @Test
    public void markingTest1() throws IOException {
        PDDocument document = PDDocument.load(oper.read("160X110 亿洲标牌0.8箭头铝 1块.pdf"));
        CutLineMark mark = new CutLineMark();
        PDDocument document2 = mark.Marking(document);

        document.save(getClass().getSimpleName() + " - " + "markingTest1-1.pdf");
        document2.save(getClass().getSimpleName() + " - " + "markingTest1-2.pdf");

    }

    @Test

    public void markingTest2() throws IOException {
        InputStream inputStream = oper.read("D:\\study\\temp\\160X110 亿洲标牌0.8箭头铝 1块.pdf");
        System.out.println(oper);
        System.out.println(inputStream);
        PDDocument document = PDDocument.load(oper.read("D:\\study\\temp\\160X110 亿洲标牌0.8箭头铝 1块.pdf"));
        CutLineMark mark = new CutLineMark();
        document = mark.Marking(document);

        document.save(getClass().getSimpleName() + " - " + "160X110 亿洲标牌0.8箭头铝 1块.pdf");
    }

    @After
    public void close(){
        String test1File1 = getClass().getSimpleName() + "markingTest1-1.pdf";
        String test1File2 = getClass().getSimpleName() + "markingTest1-2.pdf";
        String test2File1 = getClass().getSimpleName() + "160X110 亿洲标牌0.8箭头铝 1块.pdf";

        deleteFileByClassPath(test1File1);
        deleteFileByClassPath(test1File2);
        deleteFileByClassPath(test2File1);

    }

    private void deleteFileByClassPath(String filename){
        File file = new File(filename);
        if(file.exists()){
            boolean b = file.delete();
            System.out.println(b);
        }


    }

}