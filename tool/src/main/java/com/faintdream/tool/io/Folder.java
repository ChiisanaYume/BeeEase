package com.faintdream.tool.io;

import java.io.File;
import java.util.List;

/**
 * 文件夹
 * @author faintdream
 * @version 1.0
 * */
public interface Folder {

    /**
     * 获取文件夹中的文件
     * */
    List<File> getFiles();
}
