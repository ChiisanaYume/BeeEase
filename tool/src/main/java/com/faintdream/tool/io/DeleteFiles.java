package com.faintdream.tool.io;

import java.io.File;
import java.io.IOException;

/**
 * 删除目录
 * @author faintdream
 * @version 1.0
 * */
public interface DeleteFiles {

    /**
     * 删除目录并递归的删除子目录
     *
     * @param directory 要删除的目录
     * @throws IOException IO异常
     * */
    void deleteDirectory(File directory) throws IOException;

    /**
     * 删除文件
     *
     * @param file 要删除的目录
     * @throws IOException IO异常
     * */
    void deleteFile(File file) throws IOException;
}
