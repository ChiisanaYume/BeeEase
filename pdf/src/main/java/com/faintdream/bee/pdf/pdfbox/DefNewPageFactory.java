package com.faintdream.bee.pdf.pdfbox;

import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;

/**
 * 默认的构建页面工厂方法
 * @author faintdream
 * @see PageFactory
 * @version 1.0
 * */
public class DefNewPageFactory implements PageFactory<PDPage> {
    /**
     * 创建页面
     *
     * @return 创建完成的新页面
     */
    @Override
    public PDPage build() {
        return new PDPage(PDRectangle.A4);
    }
}
