package com.jay.editor;

import java.awt.*;

public class FunctionColor {
    Viewer viewer;

    public FunctionColor(Viewer viewer) {
        this.viewer = viewer;
    }

    public void changeColor(String color) {
        switch (color) {
            case "White" -> {
                viewer.window.getContentPane().setBackground(Color.white);
                viewer.textArea.setBackground(Color.white);
                viewer.textArea.setForeground(Color.black);
            }

            case "Black" -> {
                viewer.window.getContentPane().setBackground(Color.black);
                viewer.textArea.setBackground(Color.black);
                viewer.textArea.setForeground(Color.white);
            }

            case "Blue" -> {
                viewer.window.getContentPane().setBackground(Color.blue);
                viewer.textArea.setBackground(Color.blue);
                viewer.textArea.setForeground(Color.green);
            }

            case "Red" -> {
                viewer.window.getContentPane().setBackground(Color.red);
                viewer.textArea.setBackground(Color.red);
                viewer.textArea.setForeground(Color.white);
            }
        }
    }
}
