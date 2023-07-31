package com.faintdream.tool.io.impl;

import com.faintdream.tool.io.FileOperation;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class DefFileOperation implements FileOperation {
    /**
     * 读文件(获取文件流);
     *
     * @param filename 文件名
     * @return 文件流
     * @throws IOException IO异常
     */
    @Override
    public InputStream read(String filename) throws IOException {

        // 尝试从类路径读取文件流
        try{
            return getClass().getClassLoader().getResourceAsStream(filename);
        }catch (Exception ignored){

        }

        // 尝试从绝对路径读取文件流
        try{
            read(new File(filename));
        }catch (Exception ignored){
            // throw new IOException();
        }

        throw new IOException("无法读取文件");
    }

    /**
     * 读文件(获取文件流);
     *
     * @param filename 文件名
     * @return 文件流
     * @throws IOException IO异常
     */
    @Override
    public InputStream read(File filename) throws IOException {
        Path path = filename.getAbsoluteFile().toPath();
        return Files.newInputStream(path);
    }
}
