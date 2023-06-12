package com.faintdream.bee.test;

import org.junit.Test;

import java.io.File;

public class PDFTest2 {
    @Test
    public void Test1(){
        ReadPDFText readPDFText = new ReadPDFText();
        String text = readPDFText.getText(new File(ReadPDFText.getClassPath() + "091蒋介石在挑动内战.pdf"));
        System.out.println(text);
    }
}
