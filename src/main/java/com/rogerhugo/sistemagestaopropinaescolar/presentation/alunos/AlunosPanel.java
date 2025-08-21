package com.rogerhugo.sistemagestaopropinaescolar.presentation.alunos;

import com.rogerhugo.sistemagestaopropinaescolar.model.Aluno;
import com.rogerhugo.sistemagestaopropinaescolar.service.AlunoService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class AlunosPanel extends JPanel {
    private JPanel panelMain;
    private JPanel panelNorth;

    private JButton buttonAdicionarAluno;
    private JButton buttonEditarPessoa;
    private JButton buttonRemoverPessoa;

    private JPanel panelCenter;
    private JTable tableAlunos;
    
    private JFrame main;

    public AlunosPanel(JFrame mainFrame) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        main = mainFrame;
        
        initComponents();
        addListeners();
        carregarTabelaAlunos();
    }

    private void initComponents() {
        panelMain = new JPanel(new BorderLayout());
        panelMain.setBorder(new EmptyBorder(15, 15, 55, 15));

        initPanelNorth();
        initPanelCenter();

        add(panelMain);
    }

    public void initPanelNorth()
    {
        panelNorth = new JPanel();
        panelNorth.setLayout(new BoxLayout(panelNorth, BoxLayout.X_AXIS));

        buttonAdicionarAluno = new JButton("Novo Aluno");

        buttonEditarPessoa = new JButton("Editar");
        buttonRemoverPessoa = new JButton("Remover");
        //desabilitarButtons();

        panelNorth.add(buttonAdicionarAluno);
        panelNorth.add(Box.createGlue());
        panelNorth.add(buttonEditarPessoa);
        panelNorth.add(Box.createHorizontalStrut(5));
        panelNorth.add(buttonRemoverPessoa);

        panelNorth.setBorder(new EmptyBorder(0, 0, 7, 0));

        panelMain.add(panelNorth, BorderLayout.NORTH);
    }

    public void initPanelCenter()
    {
        panelCenter = new JPanel(new BorderLayout());
        panelCenter.setBorder(new EmptyBorder(30, 0, 0, 0));

        tableAlunos = new JTable(/*model*/);
        JScrollPane scroll = new JScrollPane(tableAlunos);

        panelCenter.add(scroll);

        panelMain.add(panelCenter);
    }

    private void addListeners() {
        buttonAdicionarAluno.addActionListener(e -> {
            new AlunoCreateDialog(main).setVisible(true);
            carregarTabelaAlunos();
        });
    }

    private void carregarTabelaAlunos() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nome");
        model.addColumn("Curso");

        List<Aluno> alunos = new ArrayList<>(AlunoService.getInstance().pegarTodos());
        alunos.forEach(aluno -> model.addRow(new Object[]{aluno.getNome(), aluno.getCurso()}));

        tableAlunos.setModel(model);
    }
}
