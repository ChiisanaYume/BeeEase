package com.faintdream.tool.io.impl;

import com.faintdream.tool.io.DeleteFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 文件管理器
 * @author faintdream
 * @version 1.0
 * 将文件纳入到一个文件管理器进行管理
 * */
public class BatchFileManager {

    final private Map<File,String> fileMap = new HashMap<>();
    final private DeleteFile df = new DefDeleteFile();

    // 文件纳入BatchFileManager管理
    public void add(File file,String tag){
        fileMap.put(file,tag);
    }

    // 解除文件BatchFileManager管理
    // 默认还会删除文件
    public void delete(File file) throws IOException {
        fileMap.remove(file);
        deleteFile(file);
    }

    /**
     * 解除文件BatchFileManager管理,并删除文件(根据标牌)
     * @param tag 标签
     * */
    public void delete(String tag) throws IOException {
        if(tag==null||tag.equals("")){
            throw new IOException("无效的标签");
        }

        // 遍历fileMap
        for (File key : fileMap.keySet()) {
            if(tag.equals(fileMap.get(key))){
                delete(key);
            }
        }

    }

    public void deleteFile(File file) throws IOException {
        df.deleteFile(file);
    }

}
