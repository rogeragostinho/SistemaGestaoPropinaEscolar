package com.rogerhugo.sistemagestaopropinaescolar.presentation.alunos;

import com.rogerhugo.sistemagestaopropinaescolar.model.Aluno;
import com.rogerhugo.sistemagestaopropinaescolar.model.Curso;
import com.rogerhugo.sistemagestaopropinaescolar.presentation.MainFrame;
import com.rogerhugo.sistemagestaopropinaescolar.service.AlunoService;
import com.rogerhugo.sistemagestaopropinaescolar.service.CursoService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class AlunoShowDialog extends JDialog {
    private Aluno aluno;
    private JButton buttonEditar;
    private JButton buttonFechar;
    private JLabel labelNome;
    private JLabel labelClasse;
    private JLabel labelCurso;
    private JLabel labelTurma;

    public AlunoShowDialog(JFrame own, Aluno aluno) {
        super(own, "Detalhes do Aluno", true);
        setLayout(new BorderLayout());

        this.aluno = aluno;

        JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout(FlowLayout.RIGHT));
        panel1.setBorder(new EmptyBorder(0, 0, 0, 10));

        buttonEditar = new JButton("Editar");
        panel1.add(buttonEditar);
        panel1.add(new JButton("Eliminar"));

        JPanel panel2 = new JPanel();
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
        panel2.setBorder(new EmptyBorder(10, 15, 0, 15));

        labelNome = new JLabel("Nome: " + this.aluno.getNome());
        labelClasse = new JLabel("Classe: " + this.aluno.getClasse());
        Curso curso = CursoService.getInstance().pegar(aluno.getIdCurso());
        labelCurso = new JLabel("Curso: " + curso.getNome());
        labelTurma = new JLabel("Turma: " + this.aluno.getTurma());

        panel2.add(labelNome);
        panel2.add(labelClasse);
        panel2.add(labelCurso);
        panel2.add(labelTurma);

        JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonFechar = new JButton("Fechar");
        panel3.add(buttonFechar);

        add(panel1, BorderLayout.NORTH);
        add(panel2, BorderLayout.CENTER);
        add(panel3, BorderLayout.SOUTH);

        addListeners();

        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setSize(400, 400);
        setResizable(false);
        setLocationRelativeTo(own);
    }

    private void addListeners() {
        buttonEditar.addActionListener(e -> {
            new AlunoEditDialog(this, this.aluno).setVisible(true);
            atualizar();
        });

        buttonFechar.addActionListener(e -> dispose());
    }

    private void atualizar() {
        aluno = AlunoService.getInstance().pegar(aluno.getId());
        labelNome.setText("Nome: " + this.aluno.getNome());
        labelClasse.setText("Classe: " + this.aluno.getClasse());
        Curso curso = CursoService.getInstance().pegar(aluno.getIdCurso());
        labelCurso.setText("Curso: " + curso.getNome());
        labelTurma.setText("Turma: " + this.aluno.getTurma());
    }
}
