package com.rogerhugo.sistemagestaopropinaescolar.presentation.alunos;

import com.rogerhugo.sistemagestaopropinaescolar.model.Aluno;
import com.rogerhugo.sistemagestaopropinaescolar.service.AlunoService;

import javax.swing.*;

public class AlunoCreateDialog extends AlunoFormDialog {
    public AlunoCreateDialog(JFrame own) {
        super(own, "Novo Aluno", null);
    }


    @Override
    protected void addListeners() {
        button.addActionListener(e -> {
            String nome = textFieldNome.getText();
            String classe = textFieldClasse.getText();
            String curso = textFieldCurso.getText();
            String turma = textFieldTurma.getText();

            Aluno aluno = new Aluno(nome, classe, curso, turma);

            if (!AlunoService.getInstance().registar(aluno))
                JOptionPane.showMessageDialog(this, "Erro ao adicionar novo aluno");

            dispose();
        });
    }
}
