package com.faintdream.tool.io.impl;

import com.faintdream.tool.io.DeleteFile;

import java.io.File;
import java.io.IOException;

public class DefDeleteFile implements DeleteFile {

    /**
     * 删除目录并递归的删除子目录
     * @param directory 要删除的目录
     * @throws IOException IO异常
     * */
    @Override
    public void deleteDirectory(final File directory) throws IOException {

        // 如果给定的文件是一个目录
        if (directory.isDirectory()) {

            // 获取目录下的所有文件和子目录
            File[] files = directory.listFiles();

            if (files != null) {

                // 遍历每个文件和子目录，并递归调用deleteFile方法
                for (File subFile : files) {
                    deleteDirectory(subFile); // 递归删除子文件和子目录
                }
            }
        }

        // 删除文件或目录
        boolean deleted = directory.delete();

        if(!deleted){
            throw new IOException("未知错误，无法删除文件...");
        }
    }

    /**
     * 删除文件
     *
     * @param file 要删除的目录
     * @throws IOException IO异常
     */
    @Override
    public void deleteFile(final File file) throws IOException {
        deleteDirectory(file);
    }

}
