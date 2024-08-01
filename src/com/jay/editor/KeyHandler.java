package com.jay.editor;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    Viewer viewer;

    public KeyHandler(Viewer viewer) {
        this.viewer = viewer;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.isControlDown() && e.getKeyCode()==KeyEvent.VK_S) {
            viewer.file.save();
        }
        if (e.isShiftDown() && e.isControlDown() && e.getKeyCode() == KeyEvent.VK_S) {
            viewer.file.saveAs();
        }
        if (e.isControlDown() && e.getKeyCode()==KeyEvent.VK_Z) {
            viewer.edit.undo();
        }
        if (e.isAltDown() && e.getKeyCode()==KeyEvent.VK_F) {
            viewer.menuFile.doClick();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
