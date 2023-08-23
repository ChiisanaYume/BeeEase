package com.faintdream.tool.io;

import java.io.File;
import java.io.IOException;

/**
 * @author faintdream
 * @version 1.0
 * 判断文件是否(完全)相同
 * */
@FunctionalInterface
public interface FilesCompare {

    /**
     * 判断所有文件是否完全相同
     * @param files 文件
     * @return true 文件完全相同 false 文件不相同
     * @throws IOException IO异常
     * */
    boolean compare(File...files) throws IOException;
}
