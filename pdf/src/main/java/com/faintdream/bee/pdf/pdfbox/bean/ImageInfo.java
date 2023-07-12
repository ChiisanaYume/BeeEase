package com.faintdream.bee.pdf.pdfbox.bean;

import com.faintdream.bee.pdf.Position;
import com.faintdream.bee.pdf.Size;

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
        size.setWidth(width);
        size.setHeight(height);
    }


    public ImageInfo(float width, float height, float axisX, float axisY) {
        this.width = width;
        this.height = height;
        this.axisX = axisX;
        this.axisY = axisY;
        size.setWidth(width);
        size.setHeight(height);
        position.setX(axisX);
        position.setY(axisY);
    }

    public ImageInfo(Size<Float> size) {
        width = size.getWidth();
        height = size.getHeight();
    }

    public ImageInfo(Position<Float> position){
        axisX = position.getX();
        axisY = position.getY();
    }

    /**
     * 图片的宽，高，位置(x轴，y轴);
     * */
    private float width;
    private float height;
    private float axisX;
    private float axisY;

    private Size<Float> size = new ImageSize();
    private Position<Float> position = new ImagePosition();


    /**
     * getter&setter
     * */
    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
        size.setWidth(width);
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
        size.setHeight(height);
    }

    public float getAxisX() {
        return axisX;
    }

    public void setAxisX(float axisX) {
        this.axisX = axisX;
        position.setX(axisX);
    }

    public float getAxisY() {
        return axisY;
    }

    public void setAxisY(float axisY) {
        this.axisY = axisY;
        position.setY(axisY);
    }

    public Size<Float> getSize() {
        return size;
    }

    public void setSize(Size<Float> size) {
        this.size = size;
        setWidth(size.getWidth());
        setHeight(size.getHeight());
    }

    public Position<Float> getPosition() {
        return position;
    }

    public void setPosition(Position<Float> position) {
        this.position = position;
        setAxisX(position.getX());
        setAxisY(position.getY());
    }
}
