package com.rogerhugo.sistemagestaopropinaescolar.presentation.alunos;

import com.rogerhugo.sistemagestaopropinaescolar.model.Aluno;
import com.rogerhugo.sistemagestaopropinaescolar.model.Curso;
import com.rogerhugo.sistemagestaopropinaescolar.presentation.components.AbstractFormDialog;
import com.rogerhugo.sistemagestaopropinaescolar.service.CursoService;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public abstract class AlunoFormDialog extends AbstractFormDialog<Aluno> {
    protected JTextField textFieldNome;
    protected JTextField textFieldClasse;
    protected JComboBox comboBoxCurso;
    protected JTextField textFieldTurma;
    private JLabel labelNome;
    private JLabel labelClasse;
    private JLabel labelCurso;
    private JLabel labelTurma;
    protected JButton button;

    public AlunoFormDialog(Window own, String titulo, Aluno aluno) {
        super(own, titulo, aluno);
    }

    @Override
    protected void initComponents() {
        labelNome = new JLabel("Nome");
        labelClasse = new JLabel("Classe");
        labelCurso = new JLabel("Curso");
        labelTurma = new JLabel("Turma");

        initOtherComponents();
    }

    protected void initOtherComponents() {
        textFieldNome = new JTextField(1000);
        textFieldClasse = new JTextField(1000);

        List<Curso> cursos = CursoService.getInstance().pegarTodos();
        String[] nomes = new String[cursos.size()];
        for (int i = 0; i < cursos.size(); i++)
            nomes[i] = cursos.get(i).getNome();

        comboBoxCurso = new JComboBox(nomes);
        textFieldTurma = new JTextField(Integer.MAX_VALUE);

        button = new JButton("Adicionar");
    }

    @Override
    protected void addComponents() {
        addComponent(labelNome, GridBagConstraints.WEST, GridBagConstraints.NONE, GridBagConstraints.REMAINDER, 0, new Insets(40, 40, 3, 40));
        addComponent(textFieldNome, GridBagConstraints.CENTER, GridBagConstraints.BOTH, GridBagConstraints.REMAINDER, 1, new Insets(0, 40, 0, 40));

        addComponent(labelClasse, GridBagConstraints.WEST, GridBagConstraints.NONE, GridBagConstraints.REMAINDER, 0, new Insets(15, 40, 3, 40));
        addComponent(textFieldClasse, GridBagConstraints.CENTER, GridBagConstraints.BOTH, GridBagConstraints.REMAINDER, 1, new Insets(0, 40, 0, 40));

        addComponent(labelCurso, GridBagConstraints.WEST, GridBagConstraints.NONE, GridBagConstraints.REMAINDER, 0, new Insets(15, 40, 3, 40));
        addComponent(comboBoxCurso, GridBagConstraints.CENTER, GridBagConstraints.BOTH, GridBagConstraints.REMAINDER, 1, new Insets(0, 40, 0, 40));

        addComponent(labelTurma, GridBagConstraints.WEST, GridBagConstraints.NONE, GridBagConstraints.REMAINDER, 0, new Insets(15, 40, 3, 40));
        addComponent(textFieldTurma, GridBagConstraints.CENTER, GridBagConstraints.BOTH, GridBagConstraints.REMAINDER, 1, new Insets(0, 40, 0, 40));

        addComponent(button, GridBagConstraints.CENTER, GridBagConstraints.NONE, GridBagConstraints.REMAINDER, 0, new Insets(15, 0, 0, 0));
    }
}
