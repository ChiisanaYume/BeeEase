package com.faintdream.bee.test.pdfbox;

/**
 * 通用接口 - 尺寸信息
 * @author faintdream
 * @version 1.0
 * */
public interface Size<T>{

    void setWidth(T width);
    void setHeight(T weight);
    T getWidth();
    T getHeight();
}
