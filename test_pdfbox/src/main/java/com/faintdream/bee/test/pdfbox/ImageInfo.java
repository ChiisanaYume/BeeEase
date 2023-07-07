package com.faintdream.bee.test.pdfbox;

/**
 * 图片信息类
 * @author faintdream
 * @version 1.0
 *  */
public class ImageInfo {

    private static final float MM_TO_PX_RATIO = 2.83464567f;

    public ImageInfo() {
    }

    public ImageInfo(float width, float height) {
        this.width = width;
        this.height = height;
    }

    public ImageInfo(float width, float height, float axisX, float axisY) {
        this.width = width;
        this.height = height;
        this.axisX = axisX;
        this.axisY = axisY;
    }

    /**
     * 图片的宽，高，位置(x轴，y轴);
     * */
    private float width;
    private float height;
    private float axisX;
    private float axisY;


    /**
     * getter&setter
     * */
    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getAxisX() {
        return axisX;
    }

    public void setAxisX(float axisX) {
        this.axisX = axisX;
    }

    public float getAxisY() {
        return axisY;
    }

    public void setAxisY(float axisY) {
        this.axisY = axisY;
    }
}
