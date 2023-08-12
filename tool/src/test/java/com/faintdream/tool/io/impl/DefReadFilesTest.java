package com.faintdream.tool.io.impl;

import com.faintdream.tool.io.ReadTextFromInputStreamAble;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.*;

public class DefReadFilesTest {

    private DefReadFiles drf = new DefReadFiles();
    private ReadTextFromInputStreamAble rs = new ReadTextFromInputStream();
    @Test
    public void readFileByAbsoluteTest() throws IOException {
        InputStream inputStream = drf.readByAbsolutePath("D:\\study\\BeeEase\\readme.md");
        String text = rs.readText(inputStream);
        System.out.println(text);
    }

}