package com.faintdream.tool.io;

import com.faintdream.tool.Factory;

import java.io.File;

/**
 * 构建文件的抽象工厂
 * @author faintdream
 * @version 1.0
 * */
public interface FileFactory extends Factory<File> {

    /**
     * 创建文件
     * @param file 文件的路径
     * @return file 仍然返回这个文件的路径
     * @throws Exception 异常
     * */
    File build(File file) throws Exception;
}
