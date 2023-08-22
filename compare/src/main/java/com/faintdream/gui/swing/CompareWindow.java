package com.faintdream.gui.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetAdapter;
import java.awt.dnd.DropTargetDropEvent;
import java.io.File;
import java.util.List;


@SuppressWarnings("unchecked")
public class CompareWindow {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("文件拖放示例");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel panel = new JPanel();
            panel.setLayout(new BorderLayout());

            JTextArea textArea = new JTextArea();
            textArea.setEditable(false);
            panel.add(new JScrollPane(textArea), BorderLayout.CENTER);

            // 添加底部面板
            JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

            // 添加对比按钮
            JButton compareButton = new JButton("文件对比");
            compareButton.addActionListener(e -> {
                // 在这里执行对比操作，您可以从 textArea 中获取文件路径并进行比较
                // 比如，您可以将文件路径存储在一个数据结构中，然后执行比较逻辑
                // 这里只是示例，具体操作需要根据您的需求来实现
                // 这里仅清空文本区域作为示例
                StringBuffer text = new StringBuffer();
                text.append(textArea.getText());
                text.append("\n");
                text.append("--所有文件完全相同--");
                text.append("\n");
                textArea.setText(text.toString());
            });

            // 添加对比按钮
            JButton clearButton = new JButton("清理输出");
            clearButton.addActionListener(e -> {
                textArea.setText("");
            });

            // 添加关闭按钮
            JButton closeButton = new JButton("关闭窗口");
            closeButton.addActionListener(e -> {
                frame.dispose(); // 关闭窗口
                System.exit(0); // 退出程序
            });

            // 将按钮添加到底部面板
            bottomPanel.add(compareButton);
            bottomPanel.add(clearButton);
            bottomPanel.add(closeButton);

            // 将底部面板添加到主面板
            panel.add(bottomPanel, BorderLayout.SOUTH);

            frame.add(panel);
            frame.setSize(400, 300);
            frame.setVisible(true);

            // 启用文件拖放支持
            enableFileDrop(textArea, files -> {
                StringBuilder builder = new StringBuilder();
                for (File file : files) {
                    builder.append(file.getAbsolutePath()).append("\n");
                }
                textArea.append(builder.toString());
            });
        });
    }

    // 启用文件拖放支持的方法
    private static void enableFileDrop(Component component, FileDropListener listener) {
        DropTarget dropTarget = new DropTarget(component, new DropTargetAdapter() {
            @Override
            public void drop(DropTargetDropEvent dtde) {
                try {
                    Transferable transferable = dtde.getTransferable();
                    if (transferable.isDataFlavorSupported(DataFlavor.javaFileListFlavor)) {
                        dtde.acceptDrop(DnDConstants.ACTION_COPY_OR_MOVE);
                        List<File> fileList = (List<File>) transferable.getTransferData(DataFlavor.javaFileListFlavor);
                        if (listener != null) {
                            listener.filesDropped(fileList);
                        }
                    } else {
                        dtde.rejectDrop();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    interface FileDropListener {
        void filesDropped(List<File> files);
    }
}
