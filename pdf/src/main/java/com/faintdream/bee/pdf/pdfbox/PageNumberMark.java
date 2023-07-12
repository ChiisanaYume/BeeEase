package com.faintdream.bee.pdf.pdfbox;

import org.apache.pdfbox.pdmodel.PDPage;

public interface PageNumberMark extends PageMark{
    /**
     * 默认实现
     *
     * @param page
     */
    @Override
    default PDPage Marking(PDPage page){
        PDPage newPage = page;
        return newPage;
    }
}
