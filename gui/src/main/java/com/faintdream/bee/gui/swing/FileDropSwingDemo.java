package com.faintdream.bee.gui.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.*;
import java.io.File;
import java.util.List;

public class FileDropSwingDemo {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("File Drop Swing Demo");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);

            JTextArea textArea = new JTextArea();
            JScrollPane scrollPane = new JScrollPane(textArea);

            // 注册拖放监听器
            new FileDropTarget(textArea);

            frame.add(scrollPane, BorderLayout.CENTER);

            frame.setVisible(true);
        });
    }
}

class FileDropTarget implements DropTargetListener {
    private JTextArea textArea;

    FileDropTarget(JTextArea textArea) {
        this.textArea = textArea;
        new DropTarget(textArea, this);
    }

    @Override
    public void dragEnter(DropTargetDragEvent dtde) {
        // 拖入时的处理
    }

    @Override
    public void dragOver(DropTargetDragEvent dtde) {
        // 拖动过程中的处理
    }

    @Override
    public void dropActionChanged(DropTargetDragEvent dtde) {
        // 拖放动作发生改变的处理
    }

    @Override
    public void dragExit(DropTargetEvent dte) {
        // 拖出时的处理
    }

    @Override
    public void drop(DropTargetDropEvent dtde) {
        // 执行拖放操作
        try {
            Transferable transferable = dtde.getTransferable();
            if (transferable.isDataFlavorSupported(DataFlavor.javaFileListFlavor)) {
                dtde.acceptDrop(DnDConstants.ACTION_COPY);

                List<File> fileList = (List<File>) transferable.getTransferData(DataFlavor.javaFileListFlavor);
                for (File file : fileList) {
                    String fileInfo = "File: " + file.getAbsolutePath() + "\n";
                    fileInfo += "Is Directory: " + file.isDirectory() + "\n";
                    fileInfo += "File Size: " + file.length() + " bytes\n\n";
                    textArea.append(fileInfo);
                }

                dtde.dropComplete(true);
            } else {
                dtde.rejectDrop();
            }
        } catch (Exception e) {
            e.printStackTrace();
            dtde.rejectDrop();
        }
    }
}
