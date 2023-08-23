package com.faintdream.tool.io.impl;

import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Objects;

import static org.junit.Assert.*;

public class DefFilesCompareTest {

    DefFilesCompare c = new DefFilesCompare();

    @Test
    public void compareTest1() throws IOException, URISyntaxException {
        File file1 = new File(Objects.requireNonNull(getClass().getClassLoader().getResource("クロ1.jpg")).toURI());
        File file2 = new File(Objects.requireNonNull(getClass().getClassLoader().getResource("クロ2.jpg")).toURI());
        boolean compare = c.compare(file1, file2);
        System.out.println(compare);
        assertTrue(compare);
    }

    @Ignore
    @Test
    public void compareTest2() throws IOException {
        try {
            c.compare(null, null);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void compareTest3() throws IOException, URISyntaxException {
        File file1 = new File(Objects.requireNonNull(getClass().getClassLoader().getResource("クロ1.jpg")).toURI());
        File file2 = new File(Objects.requireNonNull(getClass().getClassLoader().getResource("Miyu.jpg")).toURI());
        boolean compare = c.compare(file1, file2);
        System.out.println(compare);
        assertFalse(compare);
    }

    @Test
    @Ignore
    public void compareTest4() throws IOException {
        File file1 = new File("D:\\工作区w\\客户图纸\\江阴-君宝\\面板78号\\JBFT22.06.05-02缝焊机操作面板.pdf");
        File file2 = new File("D:\\工作区w\\客户图纸\\江阴-君宝\\江阴君宝面板75#\\JBFT22.06.05-02缝焊机操作面板.pdf");
        File file3 = new File("D:\\工作区w\\客户图纸\\江阴-君宝\\君宝[69#]20220827\\JBFT22.06.05-02缝焊机操作面板.pdf");
        File file4 = new File("D:\\工作区w\\客户图纸\\江阴-君宝\\君宝85#\\JBFT22.06.05-02缝焊机操作面板.pdf");
        File file5 = new File("D:\\工作区w\\客户图纸\\江阴-君宝\\君宝72#\\JBFT22.06.05-02缝焊机操作面板.pdf");
        boolean compare = c.compare(file1,file2,file3,file4,file5);
        System.out.println(compare);
        assertTrue(compare);
    }

}