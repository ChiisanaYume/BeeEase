package com.faintdream.bee.pdf.pdfbox.bean;

import com.faintdream.bee.pdf.Size;

public class ImageSize implements Size<Float> {
    @Override
    public void setWidth(Float width) {
        this.width = width;
    }

    @Override
    public void setHeight(Float height) {
        this.height = height;
    }

    @Override
    public Float getWidth() {
        return width;
    }

    @Override
    public Float getHeight() {
        return height;
    }

    private Float width;
    private Float height;


}
