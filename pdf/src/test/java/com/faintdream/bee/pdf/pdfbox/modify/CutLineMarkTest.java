package com.faintdream.bee.pdf.pdfbox.modify;

import com.faintdream.tool.io.FileOperation;
import com.faintdream.tool.io.impl.DefFileOperation;
import com.faintdream.tool.util.IOUtil;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class CutLineMarkTest {

    FileOperation oper = new DefFileOperation();

    @Test
    public void markingTest1() throws IOException {
        PDDocument document = PDDocument.load(oper.read("320X230 利久盛1MM不锈钢标牌 1块.pdf"));
        CutLineMark mark = new CutLineMark();
        PDDocument document2 = mark.Marking(document);

        document.save(getClass().getSimpleName() + "markingTest1.pdf");
        document2.save(getClass().getSimpleName() + "markingTest1-2.pdf");

    }
}