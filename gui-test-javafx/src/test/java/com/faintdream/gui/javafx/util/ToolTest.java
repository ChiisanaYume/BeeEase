package com.faintdream.gui.javafx.util;

import com.faintdream.test1.gui.util.Tool;
import org.junit.Test;

import java.io.InputStream;

public class ToolTest {
    @Test
    public void getClassPath() throws Exception {
        String classPath = Tool.getClassPath();
        System.out.println(classPath);

    }

    @Test
    public void getInputStream() throws Exception {
        InputStream inputStream = Tool.getInputStream("纸箱.png");
        System.out.println(inputStream);
    }

    @Test
    public void getClassLoaderTest(){
        ClassLoader classLoader = Tool.getClassLoader();
        System.out.println(classLoader);
    }
}
