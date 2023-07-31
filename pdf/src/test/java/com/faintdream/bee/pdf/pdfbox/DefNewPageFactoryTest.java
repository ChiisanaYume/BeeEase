package com.faintdream.bee.pdf.pdfbox;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class DefNewPageFactoryTest {

    @Test
    public void buildTest() throws IOException {
        PageFactory<PDPage> pageFactory = new DefNewPageFactory();
        PDPage page = pageFactory.build();

        PDDocument document = new PDDocument();
        document.addPage(page);

        document.save("DefNewPageFactoryTest.pdf");
        document.close();
    }
}