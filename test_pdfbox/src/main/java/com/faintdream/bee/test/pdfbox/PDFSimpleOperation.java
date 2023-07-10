package com.faintdream.bee.test.pdfbox;

import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * 简单的PDF文件操作
 *
 * @author faintdream
 * @version 1.0
 */
public class PDFSimpleOperation implements DocumentOperation<PDDocument> {

    private PDFDocumentFactory documentFactory = new DefNewPDDocumentFactory();
    private boolean autoSave = false;

    private long countNo = 0L;

    /**
     * 创建一个新文档
     *
     * @return D document 新文档
     */
    @Override
    public PDDocument create() throws Exception {
        return documentFactory.build();
    }

    /**
     * 合并文档
     *
     * @param documents 待合并的文档集合(序列)
     * @return D document 合并完成后的新文档
     */
    @Override
    public PDDocument merge(List<PDDocument> documents) throws IOException {

        PDDocument document = new PDDocument();
        // 获取所有页面
        for (int i = 0; i < documents.size(); i++) {

            PDDocument cd = documents.get(i);

            // 连接到一起
            for (int j = 0; j < cd.getNumberOfPages(); j++) {
                document.addPage(cd.getPage(j));
            }
        }

        // 自动保存
        if(isAutoSave()){
            save(document);
        }

        return document;
    }

    /**
     * 拆分文档
     *
     * @param document 待合并的文档
     * @return List<D>  documents 拆分完成后的新文档集合(序列)
     */
    @Override
    public List<PDDocument> split(PDDocument document) throws IOException {
        List<PDDocument> list = new LinkedList<>();

        // 获取所有页面
        for (int i = 0; i < document.getNumberOfPages(); i++) {

            // 一页存一个PDF
            PDDocument cd = new PDDocument();
            cd.addPage(document.getPage(i));
            list.add(cd);
        }

        if(isAutoSave()){
            save(list);
        }

        return list;
    }


    /**
     * 保存文件
     * */
    private void save(PDDocument document) throws IOException {
        // 获取当前时间
        Date currentDate = new Date();

        // 设置日期格式
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        // 格式化日期为字符串
        String formattedDate = dateFormat.format(currentDate);

        // 拼接文件名
        String fileName = "document_" + getCountNo() + "_" + formattedDate + ".pdf";

        // 保存文档
        document.save(fileName);
    }

    public void save(List<PDDocument> documents) throws IOException {
        for(PDDocument document:documents){
            save(document);
        }
    }

    public PDFDocumentFactory getDocumentFactory() {
        return documentFactory;
    }

    public void setDocumentFactory(PDFDocumentFactory documentFactory) {
        this.documentFactory = documentFactory;
    }

    public boolean isAutoSave() {
        return autoSave;
    }

    public void setAutoSave(boolean autoSave) {
        this.autoSave = autoSave;
    }

    private long getCountNo() {
        return ++countNo;
    }
}
