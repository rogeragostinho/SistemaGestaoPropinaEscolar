package com.rogerhugo.sistemagestaopropinaescolar.presentation.cursos;

import com.rogerhugo.sistemagestaopropinaescolar.model.Curso;
import com.rogerhugo.sistemagestaopropinaescolar.presentation.components.AbstractFormDialog;

import javax.swing.*;
import java.awt.*;

public abstract class CursoFormDialog extends AbstractFormDialog<Curso> {

    private JLabel labelNome;
    private JLabel labelValorProprina;
    protected JTextField textFieldNome;
    protected JTextField textFieldValorPropina;
    protected JButton button;

    public CursoFormDialog(Window own, String titulo, Curso entity) {
        super(own, titulo, entity);

        setSize(350, 260);
    }

    @Override
    protected void initComponents() {
        labelNome = new JLabel("Nome");
        labelValorProprina = new JLabel("Valor propina");

        initOtherComponents();
    }

    protected void initOtherComponents() {
        textFieldNome = new JTextField(1000);
        textFieldValorPropina = new JTextField(1000);

        button = new JButton("Adicionar");
    }

    @Override
    protected void addComponents() {
        addComponent(labelNome, GridBagConstraints.WEST, GridBagConstraints.NONE, GridBagConstraints.REMAINDER, 0, new Insets(40, 40, 3, 40));
        addComponent(textFieldNome, GridBagConstraints.CENTER, GridBagConstraints.BOTH, GridBagConstraints.REMAINDER, 1, new Insets(0, 40, 0, 40));

        addComponent(labelValorProprina, GridBagConstraints.WEST, GridBagConstraints.NONE, GridBagConstraints.REMAINDER, 0, new Insets(15, 40, 3, 40));
        addComponent(textFieldValorPropina, GridBagConstraints.CENTER, GridBagConstraints.BOTH, GridBagConstraints.REMAINDER, 1, new Insets(0, 40, 0, 40));

        addComponent(button, GridBagConstraints.CENTER, GridBagConstraints.NONE, GridBagConstraints.REMAINDER, 0, new Insets(15, 0, 0, 0));
    }
}
