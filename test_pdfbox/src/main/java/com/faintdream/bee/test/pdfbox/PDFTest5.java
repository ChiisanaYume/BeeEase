package com.faintdream.bee.test.pdfbox;

import com.faintdream.tool.util.IOUtil;
import org.junit.Test;

import java.io.IOException;

public class PDFTest5 {
    @Test
    public void test() throws IOException {
        ImagePdf pdf = new ImagePdfImpl();
        // pdf.pdfByImage(IOUtil.getPathF("akuma.png"),"PDFTest5.pdf");
        pdf.pdfByImage(IOUtil.getPathF("iria.jpg"),"PDFTest5-2.pdf");
    }
}
