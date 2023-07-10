package com.faintdream.bee.test.pdfbox;

import com.faintdream.tool.util.IOUtil;
import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import java.io.File;
import java.io.IOException;

public class ImagePdfImpl extends PDDocument implements ImagePdf {


    /**
     * newPage 新页面(对象内使用)
     * newPageFactory 创建新页面的工厂方法
     * newPagePadding 新页面padding
     */
    private PDPage newPage;
    private PageFactory<PDPage> newPageFactory = new DefNewPageFactory();

    private Padding newPagePadding = new Padding(0, 0, 0, 0);


    /**
     * 是否开启单张图片处理模式(singleMode);
     * singleMode 一次只处理一张图片，一张图片一个pdf
     */
    private boolean singleMode = true;

    /**
     * 图片自动拉伸(fixedImageSize);
     * fixedImageSize 图片大小恒等于: 页面 - 页边距（padding）
     */
    private boolean fixedImageSize = false;

    /**
     * 忽略水平 & 垂直方法的padding
     * */
    private boolean ignorePaddingH =true;

    private boolean ignorePaddingV =false;

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

        // 添加属性信息
        additionInformation();

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

        // 图片的尺寸,位置信息
        ImageInfo info = new ImageInfo();

        // 图片尺寸
        float width = image.getWidth();
        float height = image.getHeight();

        // 页面宽高
        float pageWidth = newPage.getMediaBox().getWidth();
        float pageHeight = newPage.getMediaBox().getHeight();

        // 页面实际宽高(去掉padding)
        float actualWidth = pageWidth - newPagePadding.getLeft() - newPagePadding.getRight();
        float actualHeight = pageHeight - newPagePadding.getTop() - newPagePadding.getBottom();

        // 计算尺寸
        info.setSize(calcSize(actualWidth, actualHeight, width, height));

        // 计算位置
        info.setPosition(calcPosition(pageWidth, pageHeight, info.getWidth(), info.getHeight()));
        return info;
    }

    /**
     * 计算位置 图片位于页面中心
     *
     * @param outer 边长
     * @param inner 图长
     */
    private float calcCP(float outer, float inner) {
        if (isFixedImageSize()) {
            System.out.println("---");
        }
        return (outer - inner) / 2;
    }

    /**
     * 计算位置
     *
     * @param outW 外边宽
     * @param outH 外边高
     * @param w    图宽
     * @param h    图高
     */
    private Position<Float> calcPosition(Float outW, Float outH, Float w, Float h) {

        Position<Float> position = new ImagePosition();

        // 固定宽高
        if(isFixedImageSize()){
            position.setX(newPagePadding.getLeft());
            position.setY(newPagePadding.getBottom());
            return position;
        }

        // 计算位置
        position.setX(calcCP(outW, w));
        position.setY(calcCP(outH, h));

        return position;
    }

    /**
     * 计算尺寸
     *
     * @param outW 外边宽
     * @param outH 外边高
     * @param w    图宽
     * @param h    图高
     */
    private Size<Float> calcSize(Float outW, Float outH, Float w, Float h) {

        Size<Float> size = new ImageSize();

        // 固定宽高
        if(isFixedImageSize()){
            size.setWidth(outW);
            size.setHeight(outH);
        }

        // 宽高缩放比
        float ratio = outW / w;

        size.setWidth(outW); // 宽度等于默认宽度
        size.setHeight(h * ratio); // 高度按照宽度的缩放比例计算

        // 图片不能完全显示(图片比页面都要长)
        if (size.getHeight() > outH) {
            ratio = outH / h;
            size.setWidth(w * ratio);
            size.setHeight(outH);
        }

        return size;
    }

    /**
     * 加载图片文件
     */
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
     * 设置PDF的属性信息
     */
    private void additionInformation() {
        PDDocumentInformation info = this.getDocumentInformation();
        info.setAuthor("faintdream@163.com");
        info.setProducer("faintdream.beeEase & apache.pdfbox");
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

    public Padding getNewPagePadding() {
        return newPagePadding;
    }

    public void setNewPagePadding(Padding newPagePadding) {
        this.newPagePadding = newPagePadding;
    }

    public void setNewPagePadding(Float padding) {
        this.newPagePadding = new Padding(padding);
    }

    public boolean isFixedImageSize() {
        return fixedImageSize;
    }

    public void setFixedImageSize(boolean fixedImageSize) {
        this.fixedImageSize = fixedImageSize;
    }

    public boolean isIgnorePaddingH() {
        return ignorePaddingH;
    }

    public void setIgnorePaddingH(boolean ignorePaddingH) {
        this.ignorePaddingH = ignorePaddingH;
    }

    public boolean isIgnorePaddingV() {
        return ignorePaddingV;
    }

    public void setIgnorePaddingV(boolean ignorePaddingV) {
        this.ignorePaddingV = ignorePaddingV;
    }
}
