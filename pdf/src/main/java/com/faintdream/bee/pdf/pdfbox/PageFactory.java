package com.faintdream.bee.pdf.pdfbox;

import com.faintdream.bee.pdf.AbstractFactory;

import java.io.IOException;

/**
 * 创建页面的抽象工厂
 *
 * @param <P> 页面类型
 * @author faintdream
 * @version 1.0
 */
public interface PageFactory<P> extends AbstractFactory<P> {

    /**
     * 创建页面
     *
     * @return 创建完成的新页面
     * @throws IOException IO异常
     */
    P build() throws IOException;
}
