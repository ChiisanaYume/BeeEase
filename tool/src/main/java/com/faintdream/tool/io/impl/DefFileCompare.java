package com.faintdream.tool.io.impl;

import com.faintdream.tool.io.FilesCompare;
import com.faintdream.tool.io.FilesRead;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * 判断文件是否完全相同
 * 使用java流读取文件，然后逐字节进行比较，如果有一个字节不相同，那个文件就不相同
 * @version 1.0
 * @author faintdream
 * @see com.faintdream.tool.io.FilesCompare
 * */
public class DefFileCompare implements FilesCompare {
    /**
     * 判断所有文件是否完全相同
     *
     * @param files 文件
     * @return true 文件完全相同 false 文件不相同
     * @throws IOException IO异常
     */
    @Override
    public boolean compare(final File... files) throws IOException {

        for (int i = 0; i < files.length; i++) {
            if (compare(files[0], files[i])) {
                continue;
            }
            return true;
        }

        return false;
    }

    public boolean compare(final File file1, final File file2) throws IOException {

        // 获取绝对路径
        File f1 = file1.getAbsoluteFile();
        File f2 = file2.getAbsoluteFile();

        // 判断两个文件是否存在
        if (!f1.exists()) {
            throw new IOException("文件不存在");
        }

        if (!f2.exists()) {
            throw new IOException("文件不存在");
        }

        // 分别读取两个文件
        FilesRead filesRead = new DefFilesRead();
        InputStream stream1 = filesRead.read(f1);
        InputStream stream2 = filesRead.read(f2);

        // 每个字节每个字节的比较两个文件
        try {
            while (true) {
                int a = stream1.read();
                int b = stream2.read();

                // System.err.println(a+" ?= "+b);
                // 判断是否已经读到文件末尾
                if (a == -1 || b == -1) {
                    // 判断当前字节是否相同,
                    if (a == b) {
                        break;
                    }
                    // 一个文件读完了，另外一个还没有读完，两个文件不一样
                    return false;
                }

                // 判断当前字节是否相同(有一个字节不相同，证明两个文件不一样)
                if (a != b) {
                    return false;
                }
            }
        } finally {
            stream2.close();
            stream2.close();
        }

        // 说有的测试都成功执行，返回true;
        return true;
    }
}
