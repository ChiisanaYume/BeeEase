package com.faintdream.bee.pdf.pdfbox.bean;

import com.faintdream.bee.pdf.Position;

public class ImagePosition implements Position<Float> {

    /**
     * 图片的位置(x轴，y轴);
     * */
    Float axisX;
    Float axisY;


    @Override
    public void setX(Float x) {
        setAxisX(x);
    }

    @Override
    public void setY(Float y) {
        setAxisY(y);
    }

    @Override
    public Float getX() {
        return getAxisX();
    }

    @Override
    public Float getY() {
        return getAxisY();
    }


    /**
     * 图片的宽，高，位置(x轴，y轴);
     * */
    public Float getAxisX() {
        return axisX;
    }

    public void setAxisX(Float axisX) {
        this.axisX = axisX;
    }

    public Float getAxisY() {
        return axisY;
    }

    public void setAxisY(Float axisY) {
        this.axisY = axisY;
    }


}
