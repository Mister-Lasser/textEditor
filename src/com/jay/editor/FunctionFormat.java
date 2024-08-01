package com.jay.editor;

import java.awt.*;

public class FunctionFormat {
    Viewer viewer;
    Font arial, comicSansMS, timeNewRoman;
    String selectedFont;

    public FunctionFormat(Viewer viewer) {
        this.viewer = viewer;
    }

    public void wordWrap() {
        if(!viewer.wordWrapOn) {
            viewer.wordWrapOn = true;
            viewer.textArea.setLineWrap(true);
            viewer.textArea.setWrapStyleWord(true);
            viewer.iWrap.setText("Word Wrap: On");
        } else {
            viewer.wordWrapOn = false;
            viewer.textArea.setLineWrap(false);
            viewer.textArea.setWrapStyleWord(false);
            viewer.iWrap.setText("Word Wrap: Off");
        }
    }

    public void setFont(int fontSize) {
        arial = new Font("Arial", Font.PLAIN, fontSize);
        timeNewRoman = new Font("Times New Roman", Font.PLAIN, fontSize);
        comicSansMS = new Font("Comic Sans MS", Font.PLAIN, fontSize);

        setFont(selectedFont);
    }

    public void setFont(String font) {
        selectedFont = font;

        switch (selectedFont) {
            case "Arial" -> viewer.textArea.setFont(arial);
            case "Comic Sans MS" -> viewer.textArea.setFont(comicSansMS);
            case "Times New Roman" -> viewer.textArea.setFont(timeNewRoman);
        }
    }
}
