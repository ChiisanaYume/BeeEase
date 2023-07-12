package com.faintdream.bee.pdf.pdfbox;

import com.faintdream.bee.pdf.Mark;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

import java.io.IOException;

/**
 * 添加页面标示
 * @author faintdream
 * @version 1.0
 * */
public interface PdfMark extends Mark<PDDocument> {

    /**
     * 默认实现
     * */
    @Override
    PDDocument Marking(PDDocument document) throws IOException;
}
