package com.faintdream.bee.pdf.pdfbox.modify;

import com.faintdream.bee.pdf.pdfbox.PdfMark;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import java.awt.Color;
import java.io.IOException;

public class CutLineMark implements PdfMark {

    private Float cutLineLength = 17F; // 3mm(???)
    private Float cutLineWidth = 0.3528F*3F;
    /**
     * 默认实现
     *
     * @param document
     */
    @Override
    public PDDocument Marking(PDDocument document) throws IOException {
        for (PDPage page : document.getPages()) {

            PDPageContentStream contentStream = new PDPageContentStream(document,page, PDPageContentStream.AppendMode.APPEND,false);

            // 获取页面的宽度和高度
            PDRectangle pageSize = page.getMediaBox();

            // 页面宽高
            float w = pageSize.getWidth();
            float h = pageSize.getHeight();

            // 设置绘制颜色
//            contentStream.setStrokingColor(Color.BLACK);
//            contentStream.setLineWidth(getCutLineWidth());
//
//            // 绘制矩形
//            contentStream.addRect(100, 100, 200, 100);
//            contentStream.stroke();
            float l = getCutLineLength();

            line(contentStream,0,h,l,h);
            line(contentStream,0,h,0,h-l);

            line(contentStream,0,0,0,l);
            line(contentStream,0,0,l,0);



            // 关闭流
            contentStream.close();
        }
        return document;
    }

    /**
     * 绘制线
     * */
    private void line(PDPageContentStream contentStream,float startX,float startY,float endX,float endY) throws IOException {

        // 设置线的线宽
        contentStream.setLineWidth(getCutLineWidth());

        // 开始绘制线
        contentStream.moveTo(startX, startY); // 移动到起始点
        contentStream.lineTo(endX, endY);     // 画线到终点
        contentStream.stroke();               // 绘制线
    }

    public Float getCutLineLength() {
        return cutLineLength;
    }

    public void setCutLineLength(Float cutLineLength) {
        this.cutLineLength = cutLineLength;
    }

    public Float getCutLineWidth() {
        return cutLineWidth;
    }

    public void setCutLineWidth(Float cutLineWidth) {
        this.cutLineWidth = cutLineWidth;
    }
}
