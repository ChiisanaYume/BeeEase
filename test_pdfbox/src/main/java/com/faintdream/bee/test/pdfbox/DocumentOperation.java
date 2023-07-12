package com.faintdream.bee.test.pdfbox;

import java.util.List;

/**
 * 文档操作
 * @author faintdream
 * @version 1.0
 * @param <D> Document 文档
 * */
public interface DocumentOperation <D> {
    /**
     * 创建一个新文档
     *
     * @return D document 新文档
     * */
    D create() throws Exception;

    /**
     * 合并文档
     *
     * @param documents 待合并的文档集合(序列)
     * @return D document 合并完成后的新文档
     * */

    D merge(List<D> documents) throws Exception;

    /**
     * 拆分文档
     *
     * @param document 待合并的文档
     * @return List<D>  documents 拆分完成后的新文档集合(序列)
     */
    List<D> split(D document) throws Exception;
}
