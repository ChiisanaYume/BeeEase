package com.faintdream.gui.swing;

import javax.swing.*;
import java.awt.Color;

public class JTextAreaTextColorSimple {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("JTextArea 文本颜色示例");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JTextArea textArea = new JTextArea(10, 40);
            textArea.setEditable(false);

            // 设置文本颜色为红色
            textArea.setForeground(Color.RED);

            textArea.append("这是红色文本\n");
            textArea.append("这是普通文本\n");
            textArea.append("这又是红色文本\n");

            JScrollPane scrollPane = new JScrollPane(textArea);
            frame.add(scrollPane);

            frame.pack();
            frame.setVisible(true);
        });
    }
}
