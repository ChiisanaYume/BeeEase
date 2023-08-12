package com.faintdream.tool.io.impl;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class ReadTextFromInputStream01 {
    public static synchronized void read(InputStream inputStream) {
        try {

            // 使用 InputStreamReader 将字节流转换为字符流
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);

            // 使用 BufferedReader 包装 InputStreamReader，可以一次读取一行文本
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            // 关闭流
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
