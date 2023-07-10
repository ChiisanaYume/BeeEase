package com.faintdream.bee.test.pdfbox;

import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.junit.Test;

import java.io.IOException;

public class ImagePdfImplTest {
    @Test
    public void test1() throws Exception {
        ImagePdf pdf = new ImagePdfImpl();
        pdf.pdfByImage("iria.jpg","ImagePdfImplTest1.pdf");
        pdf.close();

    }

    @Test
    public void test2() throws Exception {
        ImagePdfImpl pdf = new ImagePdfImpl();
        pdf.setNewPageFactory(new A3Page());
        pdf.pdfByImage("iria.jpg","ImagePdfImplTest2.pdf");
        pdf.close();
    }

    @Test
    public void test3() throws IOException {
        ImagePdfImpl pdf = new ImagePdfImpl();
        pdf.setNewPageFactory(()->{return new PDPage(PDRectangle.LETTER);});
        pdf.pdfByImage("iria.jpg","ImagePdfImplTest3-1.pdf");
        pdf.setNewPageFactory(()->{return new PDPage(new PDRectangle(400,400));});
        pdf.pdfByImage("iria.jpg","ImagePdfImplTest3-2.pdf");

        pdf.setFixedImageSize(true); //固定宽高
        pdf.pdfByImage("iria.jpg","ImagePdfImplTest3-3.pdf");

        pdf.setNewPagePadding(20f); //设置padding
        pdf.pdfByImage("iria.jpg","ImagePdfImplTest3-4.pdf");

        pdf.setFixedImageSize(false);
        pdf.pdfByImage("iria.jpg","ImagePdfImplTest3-5.pdf");
        pdf.close();
    }

    @Test
    public void test4() throws IOException{
        ImagePdfImpl pdf = new ImagePdfImpl();
        pdf.setNewPagePadding(20f);
        pdf.pdfByImage("iria.jpg","ImagePdfImplTest4-1.pdf");
        pdf.close();
    }

    @Test
    public void test5() throws Exception {
        ImagePdf pdf = new ImagePdfImpl();
        pdf.pdfByImage("iria.jpg","iria.pdf");
        pdf.pdfByImage("babara.jpg","babara.pdf");
        pdf.close();

    }
}
