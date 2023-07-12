package com.faintdream.bee.test;

import com.faintdream.bee.pdf.pdfbox.ReadPdfText;
import org.junit.Test;

import java.io.File;

public class PDFTest2 {
    @Test
    public void Test1(){
        ReadPdfText readPDFText = new ReadPdfText();
        String text = readPDFText.getText(new File(ReadPdfText.getClassPath() + "091蒋介石在挑动内战.pdf"));
        System.out.println(text);
    }
}
