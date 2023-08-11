package com.faintdream.tool.io.impl;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import static org.junit.Assert.*;

public class BatchFileManagerTest {

    @Test
    public void addTest(){
        File file1 = new File("addTest-01.txt").getAbsoluteFile();
        File file2 = new File("addTest-02.txt").getAbsoluteFile();
        File file3 = new File("addTest-03.txt").getAbsoluteFile();

        BatchFileManager manager = new BatchFileManager();
        manager.add(file1,"addTest");
        manager.add(file2,"addTest");
        manager.add(file3,"addTest");

        System.out.println(manager.getClass());
        Map<File, String> fileMap = manager.getFileMap();

        for(File key:fileMap.keySet()){
            System.out.println(key);
        }
    }

    @Test
    public void deleteTest1() throws IOException {
        File file1 = new File("deleteTest-01.txt").getAbsoluteFile();
        File file2 = new File("deleteTest-02.txt").getAbsoluteFile();
        File file3 = new File("deleteTest-03.txt").getAbsoluteFile();

        boolean b;

        b = file1.createNewFile();
        System.out.println(b);
        b = file2.createNewFile();
        System.out.println(b);
        b = file3.createNewFile();
        System.out.println(b);

        assertTrue(file1.exists());
        assertTrue(file2.exists());
        assertTrue(file3.exists());

        BatchFileManager manager = new BatchFileManager();
        manager.add(file1,"deleteTest1");
        manager.add(file2,"deleteTest1");
        manager.add(file3,"deleteTest1");

        manager.delete(file1);
        manager.delete(file2);
        manager.delete(file3);

        assertFalse(file1.exists());
        assertFalse(file2.exists());
        assertFalse(file3.exists());

    }

    @Test
    public void deleteTest2() throws IOException {
        File file1 = new File("deleteTest-01.txt").getAbsoluteFile();
        File file2 = new File("deleteTest-02.txt").getAbsoluteFile();
        File file3 = new File("deleteTest-03.txt").getAbsoluteFile();

        boolean b;

        b = file1.createNewFile();
        System.out.println(b);
        b = file2.createNewFile();
        System.out.println(b);
        b = file3.createNewFile();
        System.out.println(b);

        assertTrue(file1.exists());
        assertTrue(file2.exists());
        assertTrue(file3.exists());

        BatchFileManager manager = new BatchFileManager();
        manager.add(file1,"deleteTest2");
        manager.add(file2,"deleteTest2");
        manager.add(file3,"deleteTest2");

        manager.delete("deleteTest2");

        assertFalse(file1.exists());
        assertFalse(file2.exists());
        assertFalse(file3.exists());

    }
}