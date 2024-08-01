package com.jay.editor;

import javax.swing.*;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Viewer implements ActionListener {

    JFrame window;

    //TEXT AREA
    JTextArea textArea;
    JScrollPane scrollPane;
    Boolean wordWrapOn = false;

    //TOP MENU BAR
    JMenuBar menuBar;
    JMenu menuFile, menuEdit, menuFormat, menuColor;

    //FILE MENU
    JMenuItem iNew, iOpen, iSave, iSaveAs, iExit;

    //EDIT MENU
    JMenuItem iUndo, iRedo;

    //FORMAT MENU
    JMenuItem
            iWrap,
            iFontArial, iFontCSMS, iFontTNR,
            iFOntSize12, iFontSize14, iFontSize16, iFontSize18, iFontSize20, iFontSize22;
    JMenu menuFont, menuFontSize;

    //COLORS
    JMenuItem iColor1, iColor2, iColor3, iColor4;

    FunctionFile file = new FunctionFile(this);
    FunctionFormat format = new FunctionFormat(this);
    FunctionColor color = new FunctionColor(this);
    FunctionEdit edit = new FunctionEdit(this);

    KeyHandler keyHandler = new KeyHandler(this);

    UndoManager um = new UndoManager();

    public static void main(String[] args) {
        new Viewer();
    }

    public Viewer() {
        createWindow();
        createTextArea();
        createMenuBar();
        createFileMenu();
        createFormatMenu();
        createColor();
        createEditMenu();

        format.selectedFont = "Arial";
        format.setFont(16);
        format.wordWrap();
        color.changeColor("White");

        window.setVisible(true);
    }

    public void createWindow() {
        window = new JFrame("Notepad");
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void createTextArea() {
        textArea = new JTextArea();
        textArea.setFont(format.arial);

        textArea.addKeyListener(keyHandler);

        textArea.getDocument().addUndoableEditListener(
                new UndoableEditListener() {
                    @Override
                    public void undoableEditHappened(UndoableEditEvent e) {
                        um.addEdit(e.getEdit());
                    }
                }
        );

        scrollPane = new JScrollPane(
                textArea,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS
        );
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        window.add(scrollPane);
    }

    public void createMenuBar() {

        menuBar = new JMenuBar();
        window.setJMenuBar(menuBar);

        menuFile = new JMenu("File");
        menuBar.add(menuFile);

        menuEdit = new JMenu("Edit");
        menuBar.add(menuEdit);

        menuFormat = new JMenu("Format");
        menuBar.add(menuFormat);

        menuColor = new JMenu("Color");
        menuBar.add(menuColor);
    }

    public void createFileMenu() {
        iNew = new JMenuItem("New");
        iNew.addActionListener(this);
        iNew.setActionCommand("New");
        menuFile.add(iNew);

        iOpen = new JMenuItem("Open");
        iOpen.addActionListener(this);
        iOpen.setActionCommand("Open");
        menuFile.add(iOpen);
        
        iSave = new JMenuItem("Save");
        iSave.addActionListener(this);
        iSave.setActionCommand("Save");
        menuFile.add(iSave);

        iSaveAs = new JMenuItem("Save as");
        iSaveAs.addActionListener(this);
        iSaveAs.setActionCommand("Save as");
        menuFile.add(iSaveAs);

        iExit = new JMenuItem("Exit");
        iExit.addActionListener(this);
        iExit.setActionCommand("Exit");
        menuFile.add(iExit);
    }

    public void createFormatMenu() {
        iWrap = new JMenuItem("Word Wrap: Off");
        iWrap.addActionListener(this);
        iWrap.setActionCommand("Word Wrap");
        menuFormat.add(iWrap);

        menuFont = new JMenu("Font");
        menuFormat.add(menuFont);

        iFontArial = new JMenuItem("Arial");
        iFontArial.addActionListener(this);
        iFontArial.setActionCommand("Arial");
        menuFont.add(iFontArial);
        
        iFontCSMS = new JMenuItem("Comic Sans MS");
        iFontCSMS.addActionListener(this);
        iFontCSMS.setActionCommand("Comic Sans MS");
        menuFont.add(iFontCSMS);
        
        iFontTNR = new JMenuItem("Times New Roman");
        iFontTNR.addActionListener(this);
        iFontTNR.setActionCommand("Times New Roman");
        menuFont.add(iFontTNR);

        menuFontSize = new JMenu("Font Size");
        menuFormat.add(menuFontSize);

        iFOntSize12 = new JMenuItem("12");
        iFOntSize12.addActionListener(this);
        iFOntSize12.setActionCommand("12");
        menuFontSize.add(iFOntSize12);

        iFontSize14 = new JMenuItem("14");
        iFontSize14.addActionListener(this);
        iFontSize14.setActionCommand("14");
        menuFontSize.add(iFontSize14);

        iFontSize16 = new JMenuItem("16");
        iFontSize16.addActionListener(this);
        iFontSize16.setActionCommand("16");
        menuFontSize.add(iFontSize16);

        iFontSize18 = new JMenuItem("18");
        iFontSize18.addActionListener(this);
        iFontSize18.setActionCommand("18");
        menuFontSize.add(iFontSize18);

        iFontSize20 = new JMenuItem("20");
        iFontSize20.addActionListener(this);
        iFontSize20.setActionCommand("20");
        menuFontSize.add(iFontSize20);

        iFontSize22 = new JMenuItem("22");
        iFontSize22.addActionListener(this);
        iFontSize22.setActionCommand("22");
        menuFontSize.add(iFontSize22);
    }

    public void createEditMenu() {
        iUndo = new JMenuItem("Undo");
        iUndo.addActionListener(this);
        iUndo.setActionCommand("Undo");
        menuEdit.add(iUndo);

        iRedo = new JMenuItem("Redo");
        iRedo.addActionListener(this);
        iRedo.setActionCommand("Redo");
        menuEdit.add(iRedo);
    }

    public void createColor() {
        iColor1 = new JMenuItem("White");
        iColor1.addActionListener(this);
        iColor1.setActionCommand("White");
        menuColor.add(iColor1);

        iColor2 = new JMenuItem("Black");
        iColor2.addActionListener(this);
        iColor2.setActionCommand("Black");
        menuColor.add(iColor2);

        iColor3 = new JMenuItem("Blue");
        iColor3.addActionListener(this);
        iColor3.setActionCommand("Blue");
        menuColor.add(iColor3);

        iColor4 = new JMenuItem("Red");
        iColor4.addActionListener(this);
        iColor4.setActionCommand("Red");
        menuColor.add(iColor4);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {
            case "New" -> file.newFile();
            case "Open" -> file.open();
            case "Save" -> file.save();
            case "Save as" -> file.saveAs();
            case "Exit" -> file.exit();

            case "Word Wrap" -> format.wordWrap();

            case "Arial", "Times New Roman", "Comic Sans MS" -> format.setFont(command);

            case "12", "14", "16", "18", "20", "22" -> format.setFont(Integer.parseInt(command));

            case "White", "Blue", "Red", "Black" -> color.changeColor(command);

            case "Undo" -> edit.undo();
            case "Redo" -> edit.redo();
        }
    }
}
