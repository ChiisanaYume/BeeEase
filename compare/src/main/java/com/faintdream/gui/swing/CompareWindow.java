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
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import com.faintdream.tool.io.FilesCompare;
import com.faintdream.tool.io.impl.DefFilesCompare;


@SuppressWarnings("unchecked")
public class CompareWindow {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {

            // 选择的文件
            List<File> selectedFiles = new LinkedList<>();

            JFrame frame = new JFrame("文件比较(比较文件是否完全相同)");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel panel = new JPanel();
            panel.setLayout(new BorderLayout());

            JTextArea textArea = new JTextArea();
            textArea.append("程序运行可能会比较慢,请耐心等待...\n\n");

            // 设置文本颜色为红色
            textArea.setForeground(Color.RED);

            panel.add(new JScrollPane(textArea), BorderLayout.CENTER);

            // 添加底部面板
            JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

            // 添加`文件对比`按钮，并绑定事件
            JButton compareButton = new JButton("文件对比");
            compareButton.addActionListener(e -> {

                // 在这里执行对比操作，您可以从 textArea 中获取文件路径并进行比较
                StringBuffer text = new StringBuffer();
                text.append("\n");

                // 将List集合转化为数组
                File[] files = new File[selectedFiles.size()];
                FilesCompare fileCompare = new DefFilesCompare();
                for (int i = 0; i < files.length; i++) {
                    files[i] = selectedFiles.get(i);
                }

                try {
                    if(fileCompare.compare(files)) {
                        text.append("-- 所有文件均相同 --\n\n");
                    } else {
                        text.append("-- 有不相同的文件 --\n\n");
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                // 清空List集合
                selectedFiles.clear();
                textArea.append(text.toString());

            });
            // 为`文件对比`按钮(后入先至???)绑定新事件
            compareButton.addActionListener(e ->{
                //textArea.append("\n程序运行比较慢,请耐心等待...\n");
            });


            // 添加`清理输出`按钮(后入先至???)，并绑定事件
            JButton clearButton = new JButton("清理输出");
            clearButton.addActionListener(e -> {
                // 清空List集合
                selectedFiles.clear();
                textArea.setText("");
                textArea.append("程序运行可能会比较慢,请耐心等待...\n\n");

            });

            // 添加`关闭窗口`按钮，并绑定事件
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
            frame.setSize(500, 300);
            frame.setVisible(true);

            // 启用文件拖放支持
            enableFileDrop(textArea, files -> {
                StringBuilder text = new StringBuilder();
                //selectedFiles.set(files);
                for (File file : files) {

                    text.append(file.getAbsolutePath()).append("\n");

                    // 如果拖拽的是目录
                    if(file.isDirectory()){
                        text.append("注意:目录并不会加入比较列表\n");
                        continue;
                    }
                    selectedFiles.add(file.getAbsoluteFile());
                }
                textArea.append(text.toString());
            });

        });

    }

    // 启用文件拖放支持的方法
    @SuppressWarnings("spell")
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
