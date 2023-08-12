package com.faintdream.tool.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * 从流中读取文本
 * @version 1.0
 * @author faintdream
 * */
public interface ReadTextFromInputStreamAble {

    /**
     * 从流中读取文本
     * @param inputStream 输入流
     * @return 读取到的文本
     * @throws IOException IO异常
     * */
    String readText(InputStream inputStream) throws IOException;
}
