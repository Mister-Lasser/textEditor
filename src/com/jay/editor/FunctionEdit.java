package com.jay.editor;

public class FunctionEdit {
    Viewer viewer;

    public FunctionEdit(Viewer viewer) {
        this.viewer = viewer;
    }

    public void undo() {
        viewer.um.undo();
    }

    public void redo() {
        viewer.um.redo();
    }

}
