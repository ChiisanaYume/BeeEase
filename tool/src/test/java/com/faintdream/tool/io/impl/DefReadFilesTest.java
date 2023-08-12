package com.faintdream.tool.io.impl;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.*;

public class DefReadFilesTest {

    private DefReadFiles drf = new DefReadFiles();
    @Test
    public void readFileByAbsoluteTest() throws IOException {
        InputStream inputStream = drf.readByAbsolutePath("D:\\study\\BeeEase\\readme.md");
        ReadTextFromInputStream01.read(inputStream);
    }

}