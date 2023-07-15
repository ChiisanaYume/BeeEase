package com.faintdream.bee.pdf.pdfbox;

import com.faintdream.bee.pdf.ImagePdf;
import com.faintdream.bee.pdf.Position;
import com.faintdream.bee.pdf.Size;
import com.faintdream.bee.pdf.pdfbox.bean.ImageInfo;
import com.faintdream.bee.pdf.pdfbox.bean.ImagePosition;
import com.faintdream.bee.pdf.pdfbox.bean.ImageSize;
import com.faintdream.bee.pdf.pdfbox.bean.Padding;
import com.faintdream.tool.io.Folder;
import com.faintdream.tool.io.impl.FDFolder;
import com.faintdream.tool.util.IOUtil;
import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class ImagePdfImpl extends PDDocument implements ImagePdf {

    /**
     * 将图片插入到pdf文件
     *
     * @param imageFile 图片文件
     * @param pdfFile   pdf文件名
     * @throws IOException IO异常
     */
    @Override
    public void pdfByImage(String imageFile, String pdfFile) throws IOException {

        // 安全检查
        securityCheck();

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

        // 写入缓存
        writeTemp();

        // 关闭内容流
        contentStream.close();

        // 添加属性信息
        additionInformation();

        // 保存 PDF 文件
        if (isAutoSave()) {
            saveFile(pdfFile);
        }


        // 关闭 PDF 文档
        // document.close();
    }

    /**
     * 将图片插入到pdf文件(从文件夹中获取)
     *
     * @param folder  图片文件夹
     * @param pdfFile pdf文件名
     * @throws IOException IO异常
     */
    @Override
    public void pdfByFolder(String folder, String pdfFile) throws IOException {

        // 获取当前文件夹的所有图片文件
        Folder f = new FDFolder();
        List<File> files = f.getListFiles(loadFolder(folder));


        // 单模式存储多个文件
        if (isSingleMode()) {
            // 转换成PDF
            for (File file : files) {
                pdfByImage(file.toString(), rename(pdfFile, getCountNo(true)));
            }
            return;
        }

        boolean temp1 = isAutoSave(); // 暂存原值
        boolean temp2 = isEnableDocumentTemp(); // 暂存原值

        setAutoSave(false); // 暂时关闭自动保存文件
        setEnableDocumentTemp(false); // 暂时关闭缓存
        // 转换成PDF
        for (File file : files) {
            pdfByImage(file.toString(), pdfFile);
        }

        setAutoSave(temp1); // 还原自动保存文件设置
        setEnableDocumentTemp(temp2); // 还原缓存设置
        addPageNumber(); // 添加页码
        saveFile(pdfFile); // 保存文件

    }

    /**
     * newPage 新页面(对象内使用)
     * newPageFactory 创建新页面的工厂方法
     * newPagePadding 新页面padding
     * countNo 加在存储文件后面的编号(对象内使用)
     * documentTemps 文档缓存
     * pageNumberMark 添加页码的对象
     */
    private PDPage newPage;
    private PageFactory<PDPage> newPageFactory = new DefNewPageFactory();

    private Padding newPagePadding = new Padding(0, 0, 0, 0);
    private long countNo = 0L;
    private List<PDDocument> documentTemp = new LinkedList<>();

    private PageNumberMark pageNumberMark = new PageNumberMark();


    /**
     * singleMode 是否开启单张图片处理模式; 一次只处理一张图片，一张图片一个pdf
     * fixedImageSize 图片自动拉伸; 图片大小恒等于: 页面 - 页边距（padding）
     * ignorePaddingH 忽略水平方向的padding
     * ignorePaddingV 忽略垂直方向的padding
     * autoSave 自动保存
     * markPageNumber 标注页码
     * enableDocumentTemp 启用缓存
     */
    private boolean singleMode = true;
    private boolean fixedImageSize = false;
    private boolean ignorePaddingH = true;
    private boolean ignorePaddingV = false;
    private boolean autoSave = true;
    private boolean markPageNumber = false;
    private boolean enableDocumentTemp = true;


    public void saveFile(String fileName) throws IOException {
        save(rename(fileName));
    }

    /**
     * 安全检查
     */
    private void securityCheck() throws IOException {
        // 文档关闭抛异常
        if (getDocument().isClosed()) {
            throw new IOException(getClass().getSimpleName() + ": 对象已不可用，暂存文件已关闭");
        }
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
     * 写入缓存(只有单模式会启用缓存)
     */
    private void writeTemp() throws IOException {
        if(isEnableDocumentTemp()){
            if (isSingleMode()) {
                documentTemp.add(this);
            } else {
                // 将每一页都提取出来
                DocumentOperation<PDDocument> operation = new PDFSimpleOperation();
                try {
                    List<PDDocument> documents = operation.split(this);
                    documentTemp.addAll(documents);
                } catch (Exception e) {
                    throw new IOException(e);
                }
            }
        }
    }

    /**
     * 清空缓存
     */
    public void resetTemp() {
        documentTemp.clear();
        countNo = 0L;
    }

    /**
     * 添加页码
     */
    private void addPageNumber() throws IOException {
        if (markPageNumber) {
            // 设置当前页码
            pageNumberMark.setPageNumber(1L);
            pageNumberMark.Marking(this);
        }
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

        // 图片自动拉伸(fixedImageSize); 图片大小 == 页面-页边距（padding） == 实际页面宽高
        if(isFixedImageSize()){
            info.setWidth(actualWidth);
            info.setHeight(actualHeight);
            info.setAxisX(newPagePadding.getLeft());
            info.setAxisY(newPagePadding.getBottom());
            return info;
        }

        // 正常流程
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
        if (isFixedImageSize()) {
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
        if (isFixedImageSize()) {
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
     * 加载文件
     */
    private File loadFolder(String filename) throws IOException {
        // 加载图片文件
        File file = new File(filename);

        if (!file.isDirectory()) {
            file = IOUtil.getFile(filename);
            if (!file.isDirectory()) {
                throw new IOException(String.format("[%s] 文件不存在!", file));
            }
        }

        return file;
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
     * 加工一下文件名
     */
    private String rename(String filename) {
        return rename(filename, null);
    }

    /**
     * 加工一下文件名
     */
    private String rename(String filename, Long no) {
        String newFileName = filename;
        if (newFileName.endsWith(".pdf") || newFileName.endsWith(".PDF")) {
            newFileName = filename.substring(0, filename.lastIndexOf("."));
            if (no != null) {
                newFileName = newFileName + "-" + no + ".pdf";
            } else {
                newFileName = newFileName + ".pdf";
            }
        }
        return newFileName;
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

    private long getCountNo() {
        return countNo;
    }

    private long getCountNo(boolean append) {
        if (append) {
            return ++countNo;
        }
        return getCountNo();
    }

    public boolean isAutoSave() {
        return autoSave;
    }

    public void setAutoSave(boolean autoSave) {
        this.autoSave = autoSave;
    }

    public List<PDDocument> getDocumentTemp() {
        return documentTemp;
    }

    public boolean isMarkPageNumber() {
        return markPageNumber;
    }

    public void setMarkPageNumber(boolean markPageNumber) {
        this.markPageNumber = markPageNumber;
    }

    public PageNumberMark getPageNumberMark() {
        return pageNumberMark;
    }

    public void setPageNumberMark(PageNumberMark pageNumberMark) {
        this.pageNumberMark = pageNumberMark;
    }

    public boolean isEnableDocumentTemp() {
        return enableDocumentTemp;
    }

    public void setEnableDocumentTemp(boolean enableDocumentTemp) {
        this.enableDocumentTemp = enableDocumentTemp;
    }
}
