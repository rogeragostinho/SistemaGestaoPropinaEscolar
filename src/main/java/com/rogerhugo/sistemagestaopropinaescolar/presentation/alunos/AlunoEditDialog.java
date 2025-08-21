package com.rogerhugo.sistemagestaopropinaescolar.presentation.alunos;

import com.rogerhugo.sistemagestaopropinaescolar.model.Aluno;

import javax.swing.*;

public class AlunoEditDialog extends AlunoFormDialog {
    public AlunoEditDialog(JFrame own, Aluno aluno) {
        super(own, "Editar Aluno", aluno);
    }

    @Override
    protected void initTextFields() {
        textFieldNome = new JTextField(aluno.getNome(), 1000);
        textFieldClasse = new JTextField(aluno.getClasse(), 1000);
        textFieldCurso = new JTextField(aluno.getCurso(), 1000);
        textFieldTurma = new JTextField(aluno.getTurma(), Integer.MAX_VALUE);
    }

    @Override
    protected void addListeners() {

    }
}
