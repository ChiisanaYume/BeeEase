package com.faintdream.gui.javafx.util;

import com.faintdream.test1.gui.util.IOUtil;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.InputStream;
import java.net.URL;

public class IOUtilTest {
    @Test
    public void getClassPathTest() throws Exception {
        String classPath = IOUtil.getClassPath();
        System.out.println(classPath);

    }

    @Test
    public void getPathTest() throws Exception {
        String path1 = IOUtil.getPath();
        System.out.println(path1);
        String classPath = IOUtil.getClassPath();
        System.out.println(classPath);

        Assert.assertEquals(path1,classPath);

        String path2 = IOUtil.getPath("纸箱.png");
        System.out.println(path2);
    }

    @Test
    public void getPathFTest(){
        String path1 = IOUtil.getPathF("纸箱.png");
        System.out.println(path1);
    }
    @Test
    public void getFileTest(){
        File file1 = IOUtil.getFile("纸箱.png");
        System.out.println(file1);

        String path2 = IOUtil.getPath("纸箱.png");
        File file2 = new File(path2);
        System.out.println(file2);

        Assert.assertEquals(file1,file2);


    }

    @Test
    public void getURLTest(){
        URL url = IOUtil.getURL("纸箱.png");
        System.out.println(url);
    }

    @Test
    public void getInputStreamTest() throws Exception {
        InputStream inputStream = IOUtil.getInputStream("纸箱.png");
        System.out.println(inputStream);
        System.out.println(inputStream.read());
        inputStream.close();
    }

    @Test
    public void getClassLoaderTest(){
        ClassLoader classLoader = IOUtil.getClassLoader();
        System.out.println(classLoader);
    }
}
