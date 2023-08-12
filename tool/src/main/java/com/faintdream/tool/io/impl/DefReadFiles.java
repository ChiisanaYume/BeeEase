package com.faintdream.tool.io.impl;

import com.faintdream.tool.io.ReadFiles;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class DefReadFiles implements ReadFiles {
    /**
     * 读文件(获取文件流);
     *
     * @param filename 文件名
     * @return 文件流
     * @throws IOException IO异常
     */
    @Override
    public InputStream read(final String filename) throws IOException {

        // 尝试从类路径读取文件流
        try{
            return readFromClassPath(filename);
        }catch (Exception ignored){
            // 忽略异常，继续执行程序
        }

        // 尝试从绝对路径读取文件流
        try{
            return readFromAbsolutePath(filename);
        }catch (Exception ignored){
            // 忽略异常，继续执行程序
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

    @Override
    public InputStream readFromClassPath(String filename) throws IOException {
        if(getClass().getClassLoader().getResource(filename)==null){
            throw new IOException("类路径文件不存在");
        }
        return getClass().getClassLoader().getResourceAsStream(filename);
    }

    @Override
    public InputStream readFromAbsolutePath(String filename) throws IOException {
        return read(new File(filename));
    }

    @Override
    public InputStream readFromParent(String parent, String filename) {
        return null;
    }
}
