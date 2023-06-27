package com.faintdream.test1.gui.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.Objects;

public class IOUtil {

    private IOUtil(){}

    /**
     * 获取类路径
     * @return 类路径(String)
     * */
    public static String getClassPath() throws Exception {
        ClassLoader classLoader = IOUtil.class.getClassLoader();;
        return Objects.requireNonNull(classLoader.getResource("")).getPath();
    }


    /**
     * 获取类路径
     * @return 类路径(String)
     * */
    public static String getClassPath(String filename) throws Exception {
        ClassLoader classLoader = IOUtil.class.getClassLoader();;
        return Objects.requireNonNull(classLoader.getResource(filename)).getPath();
    }

    public static InputStream getInputStream(String filename) throws Exception {
        return new FileInputStream(getClassPath()+filename);
    }

    /**
     * 获取类加载器
     * @return 类加载器(ClassLoader)
     */
    public static ClassLoader getClassLoader(){
        return IOUtil.class.getClassLoader();
    }

    public static URL getURL(String filename){
        return getClassLoader().getResource(filename);
    }

}
