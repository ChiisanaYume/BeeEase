package com.faintdream.tool.io.impl;

import com.faintdream.tool.io.ReadTextFromInputStreamAble;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class DefReadFilesTest {

    private DefReadFiles drf = new DefReadFiles();
    private ReadTextFromInputStreamAble rs = new ReadTextFromInputStream();
    @Test
    public void readFileFromAbsoluteTest() throws IOException {
        InputStream inputStream = drf.readFromAbsolutePath("D:\\study\\BeeEase\\readme.md");
        String text = rs.readText(inputStream);
        System.out.println(text);
    }

    @Test
    public void readFileFromClassPath() throws IOException {
        InputStream inputStream = drf.readFromClassPath("maven的生命周期.md");
        String text = rs.readText(inputStream);
        System.out.println(text);
    }

}