package com.faintdream.tool.io.impl;

import com.faintdream.tool.io.ReadTextFromInputStreamAble;
import com.faintdream.tool.io.Reuse;
import org.jetbrains.annotations.Range;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

public class ReadTextFromInputStream implements ReadTextFromInputStreamAble {

    /**
     * 是否关闭流
     */
    private boolean closeStream = true;
    public String readText(final InputStream inputStream) {

        BufferedReader bufferedReader = null;
        InputStreamReader inputStreamReader = null;
        StringBuffer temp = new StringBuffer();

        try {

            // 使用 InputStreamReader 将字节流转换为字符流
            inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);

            // 使用 BufferedReader 包装 InputStreamReader
            bufferedReader = new BufferedReader(inputStreamReader);

            // 读取文本
            int c = bufferedReader.read();
            while (c != -1) {
                temp.append((char)c);
                c = bufferedReader.read();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭流
            Reuse.close(bufferedReader);
            Reuse.close(inputStreamReader);

            if (isCloseStream()) {
                Reuse.close(inputStream);
            }
        }

        return temp.toString();
    }

    public boolean isCloseStream() {
        return closeStream;
    }

    public boolean getCloseStream() {
        return closeStream;
    }

    public void setCloseStream(boolean closeStream) {
        this.closeStream = closeStream;
    }
}
