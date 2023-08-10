package com.faintdream.tool.io.impl;

import com.faintdream.tool.io.FileFactory;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class DefFileFactoryTest {

    @Test
    public void buildTest01() throws Exception {

        DefFileFactory factory = new DefFileFactory();
        factory.setFile(new File("buildTest01.test"));
        File file = factory.build();

        boolean existed = file.exists();
        Assert.assertTrue(existed);//是否成功创建文件

        System.out.println(file + "创建成功...");

        boolean deleted = file.delete();
        Assert.assertTrue(deleted);//是否成功删除文件
    }

    @Ignore
    @Test
    public void buildTest02() throws Exception {

        DefFileFactory factory = new DefFileFactory();
        factory.setFile(new File("C:\\a\\bb\\cc\\buildTest02.test"));
        File file = factory.build();

        boolean existed = file.exists();
        Assert.assertTrue(existed);//是否成功创建文件

        System.out.println(file + "创建成功...");

        boolean deleted = file.delete();
        Assert.assertTrue(deleted);//是否成功删除文件
    }

}