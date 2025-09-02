package com.rogerhugo.sistemagestaopropinaescolar.presentation.alunos;

import com.rogerhugo.sistemagestaopropinaescolar.model.Aluno;
import com.rogerhugo.sistemagestaopropinaescolar.model.Curso;
import com.rogerhugo.sistemagestaopropinaescolar.service.AlunoService;
import com.rogerhugo.sistemagestaopropinaescolar.service.CursoService;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class AlunoEditDialog extends AlunoFormDialog {
    public AlunoEditDialog(Window own, Aluno aluno) {
        super(own, "Editar Aluno", aluno);
    }

    @Override
    protected void initOtherComponents() {
        textFieldNome = new JTextField(entity.getNome(), 1000);
        textFieldClasse = new JTextField(entity.getClasse(), 1000);

        List<Curso> cursos = CursoService.getInstance().pegarTodos();
        Curso curso = CursoService.getInstance().pegar(entity.getIdCurso());
        List<String> nomes = new ArrayList<>();
        nomes.add(curso.getNome());
        cursos.forEach(e -> {
            if (!nomes.contains(e.getNome()))
                nomes.add(e.getNome());
        } );

        comboBoxCurso = new JComboBox(nomes.toArray());
        textFieldTurma = new JTextField(entity.getTurma(), Integer.MAX_VALUE);

        button = new JButton("Salvar");
    }

    @Override
    protected void addListeners() {
        button.addActionListener(e -> {
            int id = this.entity.getId();
            String nome = textFieldNome.getText();
            String classe = textFieldClasse.getText();
            String nomeCurso = comboBoxCurso.getSelectedItem().toString();
            Curso curso = CursoService.getInstance().pegarPelo("nome", nomeCurso);
            int idCurso = curso.getId();
            String turma = textFieldTurma.getText();

            Aluno entity = new Aluno(nome, classe, idCurso, turma);

            if (!AlunoService.getInstance().atualizar(id, entity))
                JOptionPane.showMessageDialog(this, "Erro ao salvar dados");

            dispose();
        });
    }
}
