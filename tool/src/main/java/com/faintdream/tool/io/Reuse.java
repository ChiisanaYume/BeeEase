package com.faintdream.tool.io;

/**
 * 经常使用,可以复用的一些IO代码
 * @version 1.0
 * @author faintdream
 * */
public class Reuse {

    public static void close(AutoCloseable res) {
        if(res!=null){
            try {
                res.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
