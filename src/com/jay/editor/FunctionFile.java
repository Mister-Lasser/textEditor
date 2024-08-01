package com.jay.editor;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class FunctionFile {

    Viewer viewer;
    String fileName;
    String fileAddress;

    public FunctionFile(Viewer viewer) {
        this.viewer = viewer;
    }

    public void newFile() {
        viewer.textArea.setText("");
        viewer.window.setTitle("New");
        fileName = null;
        fileAddress = null;
    }

    public void open() {
        FileDialog fd = new FileDialog(viewer.window, "Open", FileDialog.LOAD);
        fd.setVisible(true);

        if(fd.getFile() != null) {
            fileName = fd.getFile();
            fileAddress = fd.getDirectory();
            viewer.window.setTitle(fileName);
        }

        System.out.println("File address and file name "+ fileAddress + fileName);
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileAddress + fileName));

            viewer.textArea.setText("");

            String line = null;

            while ((line = br.readLine()) != null) {
                viewer.textArea.append(line + "\n");
            }
            br.close();
        } catch (Exception e) {
            System.out.println("FILE COULD NOT BE OPENED!");
        }
    }

    public void save() {
        if(fileName == null) {
            saveAs();
        } else {
            try {
                FileWriter fw = new FileWriter(fileAddress + fileName);
                fw.write(viewer.textArea.getText());
                viewer.window.setTitle(fileName);
                fw.close();
            } catch (Exception e) {
                System.out.println("Something went wrong...");
            }
        }
    }

    public void saveAs() {
        FileDialog fd = new FileDialog(viewer.window, "Save", FileDialog.SAVE);
        fd.setVisible(true);

        if(fd.getFile() != null) {
            fileName = fd.getFile();
            fileAddress = fd.getDirectory();
            viewer.window.setTitle(fileName);
        }

        try {
            FileWriter fw = new FileWriter(fileAddress + fileName);
            fw.write(viewer.textArea.getText());
            fw.close();
        } catch (Exception e) {
            System.out.println("Something went wrong...");
        }
    }

    public void exit() {
        System.exit(0);
    }
}
