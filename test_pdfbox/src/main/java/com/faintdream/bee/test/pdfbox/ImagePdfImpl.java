package com.faintdream.bee.test.pdfbox;

import com.faintdream.tool.annotate.NotComplete;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import com.faintdream.tool.util.IOUtil;

import java.io.File;
import java.io.IOException;

public class ImagePdfImpl extends PDDocument implements ImagePdf {


    /**
     * newPage 新页面(对象内使用)
     * newPageFactory 创建新页面的工厂方法
     */
    private PDPage newPage;
    private PageFactory<PDPage> newPageFactory = new DefNewPageFactory();

    /**
     * 是否开启单张图片处理模式(singleMode);
     * singleMode 一次只处理一张图片，一张图片一个pdf
     */
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
        if (getDocument().isClosed()) {
            throw new IOException(getClass().getSimpleName() + ": 对象已不可用，暂存文件已关闭");
        }

        // 创建一个新页面
        PDPage page = createPage();

        // 创建内容流
        PDPageContentStream contentStream = new PDPageContentStream(this, page);

        // 加载图片文件
        PDImageXObject image = loadImage(imageFile);

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
        if (singleMode) {
            PDPageTree pages = getPages();
            for (int i = 0; i < pages.getCount(); i++) {
                pages.remove(i);
            }
        }

        // 创建一个新页
        newPage = newPageFactory.build();
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

    private PDImageXObject loadImage(String imageFile) throws IOException {

        // 加载图片文件
        File file = new File(imageFile);

        if (!file.isFile()) {
            file = IOUtil.getFile(imageFile);
            if (!file.isFile()) {
                throw new IOException(String.format("[%s] 文件不存在!", file));
            }
        }

        return PDImageXObject.createFromFileByContent(file, this);
    }

    /**
     * getter & setter methods
     */

    public boolean isSingleMode() {
        return singleMode;
    }

    public void setSingleMode(boolean singleMode) {
        this.singleMode = singleMode;
    }

    public PageFactory<PDPage> getNewPageFactory() {
        return newPageFactory;
    }

    public void setNewPageFactory(PageFactory<PDPage> newPageFactory) {
        this.newPageFactory = newPageFactory;
    }
}
