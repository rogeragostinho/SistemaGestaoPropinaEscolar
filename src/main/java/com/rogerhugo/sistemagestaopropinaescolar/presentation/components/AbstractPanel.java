package com.rogerhugo.sistemagestaopropinaescolar.presentation.components;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public abstract class AbstractPanel extends JPanel {

    private JFrame main;
    private JPanel panelMain;

    public AbstractPanel(JFrame main) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.main = main;


    }

    private void init() {

    }

    private void initComponents() {
        panelMain = new JPanel(new BorderLayout());
        panelMain.setBorder(new EmptyBorder(15, 15, 55, 15));

        initPanelNorth();
        initPanelCenter();

        add(panelMain);
    }

    private void initPanelCenter() {
    }

    private void initPanelNorth() {
    }

    protected abstract void addListeners();
}
