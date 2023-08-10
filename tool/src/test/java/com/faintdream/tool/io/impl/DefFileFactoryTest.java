package com.faintdream.tool.io.impl;

import com.faintdream.tool.io.FileFactory;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class DefFileFactoryTest {

    @Test
    public void buildTest01() throws Exception {

        DefFileFactory factory = new DefFileFactory();
        factory.setFile(new File("buildTest01.test"));
        File file = factory.build();
        System.out.println(file + "创建成功...");
    }

}