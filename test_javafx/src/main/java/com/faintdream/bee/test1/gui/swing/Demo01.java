package com.faintdream.bee.test1.gui.swing;

import com.faintdream.tool.util.IOUtil;

import javax.swing.*;
import java.awt.*;

public class Demo01 {
    public static void setBackgroundImage(JFrame frame, Container container, String imageName) {
        // 限定加载图片路径，相对路径
        ImageIcon icon = new ImageIcon(IOUtil.getPath("Miyu-sf.jpg"));
        final JLabel labelBackground = new JLabel();
        labelBackground.setIcon(icon);
        // 设置label的大小
        labelBackground.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
        // 将背景图片标签放入面板的最底层
        frame.getLayeredPane().add(labelBackground, Integer.MIN_VALUE);
        // 将容器转换为面板设置为透明
        JPanel panel = (JPanel) container;
        panel.setOpaque(false);
    }

    public static void main(String[] args) {
        // 创建 JFrame 和 Container
        JFrame frame = new JFrame();
        Container container = frame.getContentPane();

        // 调用设置背景图片的方法
        setBackgroundImage(frame, container, "纸箱.png");

        // 其他操作和界面组件的添加等
        // ...

        // 设置 JFrame 的大小、可见性和关闭操作
        frame.setBounds(100,100,600,800);
        // frame.setSize(600, 800);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
