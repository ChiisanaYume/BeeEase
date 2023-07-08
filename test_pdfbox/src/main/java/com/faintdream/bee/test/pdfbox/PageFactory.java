package com.faintdream.bee.test.pdfbox;

import java.io.IOException;

/**
 * 创建页面的抽象工厂
 * @version 1.0
 * @author faintdream
 * @param <P> 页面类型
 * */
public interface PageFactory <P> {

    /**
     * 创建页面
     * @return 创建完成的新页面
     * @throws IOException IO异常
     * */
    P build() throws IOException;
}
