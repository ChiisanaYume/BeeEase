package com.faintdream.bee.test.pdfbox;

import com.faintdream.tool.util.IOUtil;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.Test;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class PDFSimpleOperationTest {

    @Test
    public void buildTest() throws Exception {
        PDFSimpleOperation simpleOperation = new PDFSimpleOperation();
        PDDocument document = simpleOperation.create();
        document.save(getClass().getSimpleName() + "-buildTest.pdf");
    }

    @Test
    public void splitTest() throws IOException {
        PDFSimpleOperation simpleOperation = new PDFSimpleOperation();

        // 自动保存文件
        simpleOperation.setAutoSave(true);

        // 读文件
        PDDocument document = PDDocument.load(IOUtil.getFile("Android4入门.pdf"));

        List<PDDocument> split = simpleOperation.split(document);

        document.close();


    }

    @Test
    public void marginTest() throws IOException{
        PDFSimpleOperation simpleOperation = new PDFSimpleOperation();

        // 自动保存文件
        simpleOperation.setAutoSave(true);

        // 读文件
        PDDocument document1 = PDDocument.load(IOUtil.getFile("babara.pdf"));
        PDDocument document2 = PDDocument.load(IOUtil.getFile("iria.pdf"));

        List<PDDocument> documents = new LinkedList<>();

        documents.add(document1);
        documents.add(document2);

        simpleOperation.merge(documents);


    }
}
