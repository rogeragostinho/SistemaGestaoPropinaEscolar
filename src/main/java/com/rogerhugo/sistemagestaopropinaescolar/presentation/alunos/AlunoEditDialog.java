package com.rogerhugo.sistemagestaopropinaescolar.presentation.alunos;

import com.rogerhugo.sistemagestaopropinaescolar.model.Aluno;
import com.rogerhugo.sistemagestaopropinaescolar.service.AlunoService;

import javax.swing.*;
import java.awt.*;

public class AlunoEditDialog extends AlunoFormDialog {
    public AlunoEditDialog(Window own, Aluno aluno) {
        super(own, "Editar Aluno", aluno);
    }

    @Override
    protected void initComponents() {
        textFieldNome = new JTextField(aluno.getNome(), 1000);
        textFieldClasse = new JTextField(aluno.getClasse(), 1000);
        textFieldCurso = new JTextField(aluno.getCurso(), 1000);
        textFieldTurma = new JTextField(aluno.getTurma(), Integer.MAX_VALUE);

        button = new JButton("Salvar");
    }

    @Override
    protected void addListeners() {
        button.addActionListener(e -> {
            int id = this.aluno.getId();
            String nome = textFieldNome.getText();
            String classe = textFieldClasse.getText();
            String curso = textFieldCurso.getText();
            String turma = textFieldTurma.getText();

            Aluno aluno = new Aluno(nome, classe, curso, turma);

            if (!AlunoService.getInstance().atualizar(id, aluno))
                JOptionPane.showMessageDialog(this, "Erro ao salvar dados");

            dispose();
        });
    }
}
