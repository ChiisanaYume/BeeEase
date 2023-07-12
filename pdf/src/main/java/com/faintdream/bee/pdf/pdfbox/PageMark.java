package com.faintdream.bee.pdf.pdfbox;

import com.faintdream.bee.pdf.Mark;
import org.apache.pdfbox.pdmodel.PDPage;

/**
 * 添加页面标示
 * @author faintdream
 * @version 1.0
 * */
public interface PageMark extends Mark<PDPage> {

    /**
     * 默认实现
     * */
    @Override
    PDPage Marking(PDPage page);
}
