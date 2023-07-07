package com.faintdream.bee.test.pdfbox;

import com.faintdream.tool.util.IOUtil;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import java.io.File;
import java.io.IOException;

public class ImagePdfImpl extends PDDocument implements ImagePdf {


    /**
     * 默认页面宽高
     */
    private final float ratio_72 = 2.834645669f;
    private float defPageWidth = 595.27563f;
    private float defPageHeight = 841.8898f;

    /**
     * 将图片插入到pdf文件
     *
     * @param imageFile 图片文件
     * @param pdfFile   pdf文件名
     */
    @Override
    public void pdfByImage(String imageFile, String pdfFile) throws IOException {

        // 创建空白的 PDF 文档
        PDDocument document = this;

        // 创建一个新页面
        PDPage page = createPage();

        // 创建内容流
        PDPageContentStream contentStream = new PDPageContentStream(this, page);

        // 加载图片文件
        PDImageXObject image = PDImageXObject.createFromFileByContent(new File(imageFile), this);

        // 获取图片宽度和高度
        float imageWidth = image.getWidth();
        float imageHeight = image.getHeight();

        // 设置图片位置和大小
        float[] conf = setImageConfig(image);

        // 绘制图片到 PDF
        // 方法中的坐标 (x, y) 表示图片左下角的位置
        contentStream.drawImage(image, conf[0], conf[1], conf[2], conf[3]);

        // 关闭内容流
        contentStream.close();

        // 保存 PDF 文件
        document.save(pdfFile);

        // 关闭 PDF 文档
        document.close();
    }

    /**
     * 创建空白的pdf页面
     */
    private PDPage createPage() throws IOException {

        // 创建一页
        PDPage page = new PDPage(PDRectangle.A4);
        addPage(page);
        return page;
    }

    /**
     * 计算图片的大小和位置
     */
    private float[] setImageConfig(PDImageXObject image) {
        float[] config = new float[4];

        config[0] = 0f;
        config[1] = 0f;

        float width = image.getWidth();
        float height = image.getHeight();


//        // A4纸竖放，宽要小于高
//        if (width > height) {
//            config[3] = getDefPageWidth();
//
//            float ratioH = getDefPageHeight() / width;
//            config[2] = width * ratioH * ratio_72;
//            return config;
//        }

        float ratio = getDefPageWidth() / width;
        config[2] = getDefPageWidth(); // 宽度等于默认宽度
        config[3] = height * ratio;

        config[0] = (getDefPageWidth()-config[2])/2;
        config[1] = (getDefPageHeight()-config[3])/2;

        return config;
    }

    public float getDefPageWidth() {
        return defPageWidth;
    }

    public void setDefPageWidth(float defPageWidth) {
        this.defPageWidth = defPageWidth;
    }

    public float getDefPageHeight() {
        return defPageHeight;
    }

    public void setDefPageHeight(float defPageHeight) {
        this.defPageHeight = defPageHeight;
    }
}
