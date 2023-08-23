package com.faintdream.tool.io;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * 文件操作
 * @version 1.0
 * @author faintdream
 * */
public interface FilesRead {

    /**
     * 读文件(获取文件流);
     * @param filename 文件名
     * @return 文件流
     * @throws IOException IO异常
     * */
    InputStream read(String filename)throws IOException;

    /**
     * 读文件(获取文件流);
     * @param filename 文件名
     * @return 文件流
     * @throws IOException IO异常
     * */
    InputStream read(File filename)throws IOException;

    InputStream readFromClassPath(String filename) throws IOException;
    InputStream readFromAbsolutePath(String file) throws IOException;
    InputStream readFromParent(String parent, String filename);
}
