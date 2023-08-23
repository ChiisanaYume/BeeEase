package com.faintdream.tool.io.impl;

import com.faintdream.tool.io.FileFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DefFileFactory implements FileFactory {

    private File file;


    @Override
    public File build() throws Exception {
        return build(getFile());
    }

    /**
     * 创建文件
     *
     * @param file 文件的路径
     * @return file 仍然返回这个文件的路径
     * @throws Exception 异常
     */

    @Override
    public File build(File file) throws Exception {

        // 创建文件(阻塞)
        createFile(file);

        // 将文件纳入FileOperation容器管理
        // code

        return file;
    }

    /**
     * 创建文件
     * */
    private void createFile(final File file) throws IOException {

        File f = file.getAbsoluteFile(); // 绝对路径
        Path path = f.toPath(); // Path对象

        // 如果传入的路径(File)指向一个文件夹而不是文件，抛出异常
        if(f.isDirectory()){
            throw new IOException("非法操作,不支持操作文件夹...");
        }

        // 如果文件已经存在，则直接返回，不再创建
        if(f.exists()){
            return;
        }

        // 如果父路径不存在,创建它
        if (!path.getParent().toFile().exists()) {
            Files.createDirectories(path.getParent());
        }

        // 创建文件
        Files.createFile(path);

    }


    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }


}
