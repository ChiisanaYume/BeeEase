package com.faintdream.bee.pdf.pdfbox.bean;

/**
 * padding 容器`内部元素`和`容器边界`之间的距离
 *
 * @author faintdream
 * @version 1.0
 */
public class Padding {
    private float top;
    private float bottom;
    private float left;
    private float right;

    public Padding() {
    }

    public Padding(float padding) {
        this.top = padding;
        this.bottom = padding;
        this.left = padding;
        this.right = padding;
    }

    public Padding(float top, float bottom, float left, float right) {
        this.top = top;
        this.bottom = bottom;
        this.left = left;
        this.right = right;
    }


    /**
     * getter&setter
     */
    public float getTop() {
        return top;
    }

    public void setTop(float top) {
        this.top = top;
    }

    public float getBottom() {
        return bottom;
    }

    public void setBottom(float bottom) {
        this.bottom = bottom;
    }

    public float getLeft() {
        return left;
    }

    public void setLeft(float left) {
        this.left = left;
    }

    public float getRight() {
        return right;
    }

    public void setRight(float right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Padding{" +
                "top=" + top +
                ", bottom=" + bottom +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
