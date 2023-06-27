package com.faintdream.gui.javafx.util;

import com.faintdream.test1.gui.util.IOUtil;
import org.junit.Test;

import java.io.InputStream;

public class IOUtilTest {
    @Test
    public void getClassPath() throws Exception {
        String classPath = IOUtil.getClassPath();
        System.out.println(classPath);

    }

    @Test
    public void getInputStream() throws Exception {
        InputStream inputStream = IOUtil.getInputStream("纸箱.png");
        System.out.println(inputStream);
    }

    @Test
    public void getClassLoaderTest(){
        ClassLoader classLoader = IOUtil.getClassLoader();
        System.out.println(classLoader);
    }
}
