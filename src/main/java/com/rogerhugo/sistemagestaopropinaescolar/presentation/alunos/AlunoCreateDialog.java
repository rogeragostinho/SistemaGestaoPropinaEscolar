package com.rogerhugo.sistemagestaopropinaescolar.presentation.alunos;

import com.rogerhugo.sistemagestaopropinaescolar.model.Aluno;
import com.rogerhugo.sistemagestaopropinaescolar.model.Curso;
import com.rogerhugo.sistemagestaopropinaescolar.service.AlunoService;
import com.rogerhugo.sistemagestaopropinaescolar.service.CursoService;

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
            String nomeCurso = comboBoxCurso.getSelectedItem().toString();
            Curso curso = CursoService.getInstance().pegarPelo("nome", nomeCurso);
            int idCurso = curso.getId();
            String turma = textFieldTurma.getText();

            Aluno aluno = new Aluno(nome, classe, idCurso, turma);

            if (!AlunoService.getInstance().registar(aluno))
                JOptionPane.showMessageDialog(this, "Erro ao adicionar novo aluno");

            dispose();
        });
    }
}
