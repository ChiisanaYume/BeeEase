package com.faintdream.gui.swing.comparewindow;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

public class JTextPaneMultipleTextColors {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("JTextPane 多颜色文本示例");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JTextPane textPane = new JTextPane();
            textPane.setEditable(false);

            // 获取文档对象
            StyledDocument doc = textPane.getStyledDocument();

            // 创建红色样式
            Style redStyle = doc.addStyle("Red", null);
            StyleConstants.setForeground(redStyle, Color.RED);

            // 插入文本并应用红色样式
            try {
                doc.insertString(doc.getLength(), "这是红色文本\n", redStyle);
                doc.insertString(doc.getLength(), "这是普通文本\n", null);
                doc.insertString(doc.getLength(), "这又是红色文本\n", redStyle);


            } catch (BadLocationException e) {
                e.printStackTrace();
            }

            JScrollPane scrollPane = new JScrollPane(textPane);
            frame.add(scrollPane);

            frame.pack();
            frame.setVisible(true);
        });
    }
}
