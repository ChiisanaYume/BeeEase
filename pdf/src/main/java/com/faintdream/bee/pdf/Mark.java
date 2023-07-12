package com.faintdream.bee.pdf;

/**
 * 标记，为一个对象添加标记
 * @author faintdream
 * @version 1.0
 * @param <D> Document
 * */
public interface Mark<D>{

    /**
     * @param document  要添加标记的文档
     * @return document 添加标记完成后的文档
     * */
    D Marking(D document);
}
