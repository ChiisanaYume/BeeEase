package com.faintdream.tool.io.impl;

import com.faintdream.tool.io.FilesCompare;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Objects;

import static org.junit.Assert.*;

public class DefFileCompareTest {

    DefFileCompare c = new DefFileCompare();

    @Test
    public void compareTest1() throws IOException, URISyntaxException {
        File file1 = new File(Objects.requireNonNull(getClass().getClassLoader().getResource("クロ1.jpg")).toURI());
        File file2 = new File(Objects.requireNonNull(getClass().getClassLoader().getResource("クロ2.jpg")).toURI());
        boolean compare = c.compare(file1, file2);
        System.out.println(compare);
        assertTrue(compare);
    }

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

}