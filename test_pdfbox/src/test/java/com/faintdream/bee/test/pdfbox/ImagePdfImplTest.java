package com.faintdream.bee.test.pdfbox;

import org.junit.Test;

import java.io.IOException;

public class ImagePdfImplTest {
    @Test
    public void test1() throws Exception {
        ImagePdf pdf = new ImagePdfImpl();
        pdf.pdfByImage("iria.jpg","ImagePdfImplTest1.pdf");
        pdf.close();

    }
}
