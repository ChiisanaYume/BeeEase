package com.faintdream.bee.test;

import com.faintdream.bee.pdf.pdfbox.ReadPdfText;
import com.faintdream.tool.util.IOUtil;
import org.junit.Test;

public class PDFTest3 {
    @Test
    public void Test1(){
        ReadPdfText readPDFText = new ReadPdfText();
        String text = readPDFText.getText(IOUtil.getFile("091蒋介石在挑动内战.pdf"));
        System.out.println(text);
    }
}
