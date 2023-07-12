package com.faintdream.bee.pdf.pdfbox;

import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;

import java.io.IOException;

public class A3Page implements PageFactory<PDPage> {
    /**
     * 创建页面
     *
     * @return 创建完成的新页面
     * @throws IOException IO异常
     */
    @Override
    public PDPage build() throws IOException {
        return new PDPage(PDRectangle.A3);
    }
}
