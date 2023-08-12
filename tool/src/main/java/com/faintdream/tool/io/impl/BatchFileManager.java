package com.faintdream.tool.io.impl;

import com.faintdream.tool.io.DeleteFiles;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 文件管理器
 * @author faintdream
 * @version 1.0
 * 将文件纳入到一个文件管理器进行管理
 * */
public class BatchFileManager {

    /**
     * fileMap 维护的HashMap集合，以File为key,标签(String)为value
     * df 需要使用DeleteFile对象来删除文件
     * DEF_TAG 默认标签名
     * */
    final private Map<File,String> fileMap = new HashMap<>();
    final private DeleteFiles df = new DefDeleteFiles();
    final private String DEF_TAG = "default";

    /**
     * 将文件纳入BatchFileManager管理
     * @param file 文件路径
     * @param tag 文件标签
     * */
    public void add(File file,String tag){
        fileMap.put(file,tag);
    }

    /**
     * 将文件纳入BatchFileManager管理(使用默认标牌)
     * @param file 文件路径
     * */
    public void add(File file){
        add(file,DEF_TAG);
    }

    /**
     * 解除文件BatchFileManager管理并,并删除文件(根据文件路径)
     * @param file 文件路径
     * @throws IOException
     * */
    public void delete(File file) throws IOException {
        fileMap.remove(file);
        deleteFile(file);
    }

    /**
     * 解除文件BatchFileManager管理,并删除文件(根据文件标牌)
     * @param tag 标签
     * @throws IOException
     * */
    public void delete(String tag) throws IOException {
        if (tag == null || tag.equals("")) {
            throw new IOException("无效的标签");
        }

        // 使用 synchronized 锁住 fileMap
        synchronized (fileMap) {

            // 创建一个临时列表来保存需要删除的文件
            List<File> filesToDelete = new ArrayList<>();

            // 遍历fileMap
            for (File key : fileMap.keySet()) {
                if (tag.equals(fileMap.get(key))) {
                    filesToDelete.add(key);
                }
            }

            // 删除需要删除的文件
            for (File file : filesToDelete) {
                delete(file);
            }
        }
    }

    /**
     * 解除BatchFileManager管理的所有文件,并删除所有文件
     * */
    public void delete() throws IOException {

        // 使用 synchronized 锁住 fileMap
        synchronized (fileMap) {

            // 创建一个临时列表来保存需要删除的文件
            List<File> filesToDelete = new ArrayList<>(fileMap.keySet());

            // 删除需要删除的文件
            for (File file : filesToDelete) {
                delete(file);
            }
        }
    }
    public void deleteFile(File file) throws IOException {
        df.deleteFile(file);
    }

    public Map<File, String> getFileMap() {
        return fileMap;
    }
}
