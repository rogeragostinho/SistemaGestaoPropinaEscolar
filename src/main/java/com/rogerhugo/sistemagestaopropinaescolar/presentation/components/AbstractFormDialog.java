package com.rogerhugo.sistemagestaopropinaescolar.presentation.components;

import javax.swing.*;
import java.awt.*;

public abstract class AbstractFormDialog<T> extends JDialog {
    protected T entity;
    private Container panelCenter;

    public AbstractFormDialog(Window own, String titulo, T entity) {
        super(own, titulo, ModalityType.APPLICATION_MODAL);
        setLayout(new BorderLayout(60, 40));

        this.entity = entity;

        initLayout();
        addListeners();

        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setSize(400, 400);
        setResizable(false);
        setLocationRelativeTo(own); // abre a janela em relação à janela pai
    }

    // Organiza o layout
    private void initLayout() {
        GridBagLayout layout = new GridBagLayout();
        panelCenter = new JPanel();
        panelCenter.setLayout(layout);

        initComponents();
        addComponents();

        add(panelCenter, BorderLayout.NORTH);
    }

    protected abstract void initComponents();

    protected void addComponent(Component component, int anchor, int fill, int gridwidth, int weightx, Insets insets)
    {
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.anchor = anchor;
        constraints.fill = fill;
        constraints.gridwidth = gridwidth;
        constraints.weightx = weightx;
        constraints.insets = insets;

        GridBagLayout layout = (GridBagLayout) panelCenter.getLayout();
        layout.setConstraints(component, constraints);
        panelCenter.add(component);
    }

    protected abstract void addComponents();
    
    protected abstract void addListeners();
}
