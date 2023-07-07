package com.faintdream.bee.test.pdfbox;

import com.faintdream.tool.annotate.NotComplete;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import java.io.File;
import java.io.IOException;

public class ImagePdfImpl extends PDDocument implements ImagePdf {


    /**
     * 默认页面宽高
     */
    private float defPageWidth = 595.27563f;
    private float defPageHeight = 841.8898f;

    /**
     * 新页面;
     * */
    private PDPage newPage;

    /**
     * 是否开启单张图片处理模式(singleMode);
     * singleMode 一次只处理一张图片，一张图片一个pdf
     * */
    private boolean singleMode = true;

    /**
     * 将图片插入到pdf文件
     *
     * @param imageFile 图片文件
     * @param pdfFile   pdf文件名
     */
    @Override
    public void pdfByImage(String imageFile, String pdfFile) throws IOException {

        // 文档关闭抛异常
        if(getDocument().isClosed()){
            throw new IOException(getClass().getSimpleName() + ": 对象已不可用，暂存文件已关闭");
        }

        // 创建一个新页面
        PDPage page = createPage();

        // 创建内容流
        PDPageContentStream contentStream = new PDPageContentStream(this, page);

        // 加载图片文件
        PDImageXObject image = PDImageXObject.createFromFileByContent(new File(imageFile), this);

        // 设置图片位置和大小
        ImageInfo info = setImageConfig(image);

        // 绘制图片到 PDF
        // 注意: 方法中的坐标 (x, y) 表示图片左下角的位置
        contentStream.drawImage(image, info.getAxisX(), info.getAxisY(), info.getWidth(), info.getHeight());

        // 关闭内容流
        contentStream.close();

        // 保存 PDF 文件
        save(pdfFile);

        // 关闭 PDF 文档
        // document.close();
    }

    /**
     * 创建空白的pdf页面
     */
    private PDPage createPage() throws IOException {

        // 删除原来的所有页面
        if(singleMode){
            PDPageTree pages = getPages();
            for(int i=0; i<pages.getCount();i++){
                pages.remove(i);
            }
        }

        // 创建一个新页
        if(newPage==null){
            setNewPage(new PDPage(PDRectangle.A4));
        }
        setNewPage(new PDPage(PDRectangle.A4));
        addPage(newPage);
        return newPage;
    }

    /**
     * 计算图片的大小和位置
     */
    private ImageInfo setImageConfig(PDImageXObject image) {

        // 图片的大小,位置信息
        ImageInfo info = new ImageInfo();

        float width = image.getWidth();
        float height = image.getHeight();

        // 页面宽高
        float pageWidth = newPage.getMediaBox().getWidth();
        float pageHeight = newPage.getMediaBox().getHeight();

        // 宽高缩放比
        float ratio = pageWidth / width;

        info.setWidth(pageWidth); // 宽度等于默认宽度
        info.setHeight(height * ratio); // 高度按照宽度的缩放比例计算

        info.setAxisX((pageWidth - info.getWidth()) / 2);
        info.setAxisY((pageHeight - info.getHeight()) / 2);

        return info;
    }

    /**
     * getter & setter methods
     */

    @NotComplete
    public float getDefPageWidth() {
        return defPageWidth;
    }

    @NotComplete
    public void setDefPageWidth(float defPageWidth) {
        this.defPageWidth = defPageWidth;
    }

    @NotComplete
    public float getDefPageHeight() {
        return defPageHeight;
    }

    @NotComplete
    public void setDefPageHeight(float defPageHeight) {
        this.defPageHeight = defPageHeight;
    }

    @NotComplete
    public boolean isSingleMode() {
        return singleMode;
    }

    @NotComplete
    public void setSingleMode(boolean singleMode) {
        this.singleMode = singleMode;
    }

    public PDPage getNewPage() {
        return newPage;
    }

    public void setNewPage(PDPage newPage) {
        this.newPage = newPage;
    }
}
