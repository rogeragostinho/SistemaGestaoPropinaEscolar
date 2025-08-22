package com.rogerhugo.sistemagestaopropinaescolar.presentation.alunos;

import com.rogerhugo.sistemagestaopropinaescolar.model.Aluno;

import javax.swing.*;
import java.awt.*;

public abstract class AlunoFormDialog extends JDialog {
    protected JTextField textFieldNome;
    protected JTextField textFieldClasse;
    protected JTextField textFieldCurso;
    protected JTextField textFieldTurma;
    private JLabel labelNome;
    private JLabel labelClasse;
    private JLabel labelCurso;
    private JLabel labelTurma;
    protected JButton button;
    private JPanel panelCenter;

    protected Aluno aluno;

    public AlunoFormDialog(Window own, String titulo, Aluno aluno) {
        super(own, titulo, ModalityType.APPLICATION_MODAL);
        setLayout(new BorderLayout(60, 40));

        this.aluno = aluno;

        initLayout();
        addListeners();

        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setSize(400, 400);
        setResizable(false);
        setLocationRelativeTo(own);
    }

    private void initLayout() {
        GridBagLayout layout = new GridBagLayout();
        panelCenter = new JPanel();
        panelCenter.setLayout(layout);

        labelNome = new JLabel("Nome");
        labelClasse = new JLabel("Classe");
        labelCurso = new JLabel("Curso");
        labelTurma = new JLabel("Turma");

        initComponents();

        addComponent(labelNome, GridBagConstraints.WEST, GridBagConstraints.NONE, GridBagConstraints.REMAINDER, 0, new Insets(40, 40, 3, 40));
        addComponent(textFieldNome, GridBagConstraints.CENTER, GridBagConstraints.BOTH, GridBagConstraints.REMAINDER, 1, new Insets(0, 40, 0, 40));

        addComponent(labelClasse, GridBagConstraints.WEST, GridBagConstraints.NONE, GridBagConstraints.REMAINDER, 0, new Insets(15, 40, 3, 40));
        addComponent(textFieldClasse, GridBagConstraints.CENTER, GridBagConstraints.BOTH, GridBagConstraints.REMAINDER, 1, new Insets(0, 40, 0, 40));

        addComponent(labelCurso, GridBagConstraints.WEST, GridBagConstraints.NONE, GridBagConstraints.REMAINDER, 0, new Insets(15, 40, 3, 40));
        addComponent(textFieldCurso, GridBagConstraints.CENTER, GridBagConstraints.BOTH, GridBagConstraints.REMAINDER, 1, new Insets(0, 40, 0, 40));

        addComponent(labelTurma, GridBagConstraints.WEST, GridBagConstraints.NONE, GridBagConstraints.REMAINDER, 0, new Insets(15, 40, 3, 40));
        addComponent(textFieldTurma, GridBagConstraints.CENTER, GridBagConstraints.BOTH, GridBagConstraints.REMAINDER, 1, new Insets(0, 40, 0, 40));

        addComponent(button, GridBagConstraints.CENTER, GridBagConstraints.NONE, GridBagConstraints.REMAINDER, 0, new Insets(15, 0, 0, 0));

        add(panelCenter, BorderLayout.NORTH);
    }

    protected void initComponents() {
        textFieldNome = new JTextField(1000);
        textFieldClasse = new JTextField(1000);
        textFieldCurso = new JTextField(1000);
        textFieldTurma = new JTextField(Integer.MAX_VALUE);

        button = new JButton("Adicionar");
    }

    public void addComponent(Component component, int anchor, int fill, int gridwidth, int weightx, Insets insets)
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

    protected abstract void addListeners();
}
