package com.faintdream.tool.io.impl;

import com.faintdream.tool.io.FileFactory;

import java.io.File;
import java.io.IOException;

public class DefFileFactory implements FileFactory {

    private File file;
    /**
     * 创建文件
     *
     * @return File  创建的文件
     * @throws Exception 异常
     */
    @Override
    public File build() throws Exception {

        // 创建文件(阻塞)
        createFile(file);
        // 将文件纳入FileOperation容器管理

        return file;
    }

    /**
     * 创建文件
     * */
    private void createFile(final File file) throws IOException {

        File f = file.getAbsoluteFile();

        // 如果传入的路径(File)指向一个文件夹而不是文件，抛出异常
        if(!f.isFile()){
            throw new IOException("非法操作,不支持操作文件夹...");
        }

        // 如果文件已经存在，则直接返回，不再创建
        if(f.exists()){
            return;
        }

        // 创建文件
        boolean exists = file.createNewFile();
        if(exists){
            throw new IOException("未知原因文件创建失败...");
        }


    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

}
