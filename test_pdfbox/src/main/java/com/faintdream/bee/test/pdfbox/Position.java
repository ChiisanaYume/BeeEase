package com.faintdream.bee.test.pdfbox;

/**
 * 通用接口 - 位置信息
 * @author faintdream
 * @version 1.0
 * */
public interface Position <T> {

    void setX(T x);
    void setY(T y);
    T getX();
    T getY();
}
