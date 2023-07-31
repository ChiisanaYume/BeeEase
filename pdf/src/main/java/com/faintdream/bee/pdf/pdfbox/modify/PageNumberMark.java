package com.faintdream.bee.pdf.pdfbox.modify;

import com.faintdream.bee.pdf.pdfbox.PdfMark;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode;
import java.io.IOException;

/**
 * 添加页码
 * */
public class PageNumberMark implements PdfMark {
    /**
     * 默认实现
     *
     * @param document 要添加页码的文档
     */
    @Override
    public PDDocument Marking(PDDocument document) throws IOException {


        for (PDPage page : document.getPages()) {

            PDPageContentStream contentStream = new PDPageContentStream(document,page,AppendMode.APPEND,false);

            // 设置字体和字号
            PDFont font = PDType1Font.HELVETICA_BOLD;
            float fontSize = 20;
            contentStream.setFont(font, fontSize);

            // 获取页面的宽度和高度
            PDRectangle pageSize = page.getMediaBox();
            float pageWidth = pageSize.getWidth();
            //float pageHeight = pageSize.getHeight();

            // 计算文本的宽度和高度
            String text = getPageNumber(true).toString();
            float textWidth = font.getStringWidth(text) * fontSize / 1000f;
            float textHeight = font.getFontDescriptor().getFontBoundingBox().getHeight() * fontSize / 1000f;

            // 计算文本的起始位置
            float startX = (pageWidth - textWidth) / 2;
            //float startY = (pageHeight - textHeight) / 2;
            float startY = 15;

            // 将文本绘制到页面的中心位置
            contentStream.beginText();
            contentStream.newLineAtOffset(startX, startY);
            contentStream.showText(text);
            contentStream.endText();

            // 关闭流
            contentStream.close();
        }
        return document;
    }

    private Long pageNumber = 0L;

    public Long getPageNumber() {
        return pageNumber;
    }

    private Long getPageNumber(boolean append){
        if(append){
            return pageNumber++;
        }

        return pageNumber;
    }

    public void setPageNumber(Long pageNumber) {
        this.pageNumber = pageNumber;
    }

}
