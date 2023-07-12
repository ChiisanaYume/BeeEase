package com.faintdream.bee.test.pdfbox;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.IOException;

public class DefNewPDDocumentFactory extends PDFDocumentFactory {
    /**
     * 生产商品
     *
     * @return P  Product 生产的商品
     * @throws Exception 异常
     */
    @Override
    public PDDocument build() throws Exception {

        PDDocument document = new PDDocument();
        addContent(document);
        return document;
    }

    private void addContent(PDDocument document) throws IOException {

        PDPage page = new PDPage(PDRectangle.A4);
        document.addPage(page);

        PDPageContentStream contentStream = new PDPageContentStream(document, page);

        // 设置字体和字号
        PDFont font = PDType1Font.HELVETICA_BOLD;
        float fontSize = 36;
        contentStream.setFont(font, fontSize);

        // 获取页面的宽度和高度
        PDRectangle pageSize = page.getMediaBox();
        float pageWidth = pageSize.getWidth();
        float pageHeight = pageSize.getHeight();

        // 计算文本的宽度和高度
        String text = "Default Document";
        float textWidth = font.getStringWidth(text) * fontSize / 1000f;
        float textHeight = font.getFontDescriptor().getFontBoundingBox().getHeight() * fontSize / 1000f;

        // 计算文本的起始位置
        float startX = (pageWidth - textWidth) / 2;
        float startY = (pageHeight - textHeight) / 2;

        // 将文本绘制到页面的中心位置
        contentStream.beginText();
        contentStream.newLineAtOffset(startX, startY);
        contentStream.showText(text);
        contentStream.endText();

        contentStream.close();
    }
}
