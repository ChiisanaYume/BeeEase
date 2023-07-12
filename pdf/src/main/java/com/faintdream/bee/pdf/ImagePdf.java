package com.faintdream.bee.pdf;

import java.io.IOException;

/**
 * 从图片构建pdf文件
 * @version 1.0
 * @author faintdream
 * */
public interface ImagePdf extends AutoCloseable {

    /**
     * 将图片插入到pdf文件
     * @param imageFile 图片文件
     * @param pdfFile pdf文件名
     * @throws IOException IO异常
     * */
    void pdfByImage(String imageFile,String pdfFile) throws IOException;
}
