package com.rogerhugo.sistemagestaopropinaescolar.presentation;

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
    private JList<String> listAlunos;
    private JTable tableAlunos;
    //private DefaultTableModel model;
    
    private JFrame main;

    public AlunosPanel(JFrame mainFrame) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        main = mainFrame;
        
        initComponents();
        addListeners();
        carregarListaAlunos();
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

        listAlunos = new JList<>();
        listAlunos.setBorder(new EmptyBorder(5, 7, 7, 5));
        listAlunos.setPreferredSize(listAlunos.getPreferredSize());

        // tableAlunos
         //model = new DefaultTableModel();
        tableAlunos = new JTable(/*model*/);
        JScrollPane scroll = new JScrollPane(tableAlunos);

        //panelCenter.add(listAlunos);
        panelCenter.add(scroll);

        panelMain.add(panelCenter);
    }

    private void addListeners() {
        buttonAdicionarAluno.addActionListener(e -> {
            Aluno aluno = AlunoService.getInstance().pegar(1);
            System.out.println(aluno);
            //AlunoFormDialog ald = new AlunoCreateDialog(main, new Aluno());
            AlunoFormDialog ald = new AlunoEditDialog(main, aluno);
            ald.setVisible(true);
        });
    }

    private void carregarListaAlunos() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nome");
        model.addColumn("Curso");

        //model.addRow(new Object[]{"Roger", 20, "Informática"});
        //model.addRow(new Object[]{"Maria", 22, "Direito"});

        List<Aluno> alunos = new ArrayList<>(AlunoService.getInstance().pegarTodos());
        alunos.forEach(aluno -> model.addRow(new Object[]{aluno.getNome(), aluno.getCurso()}));

        tableAlunos.setModel(model);

        /*List<Aluno> alunos = new ArrayList<>(AlunoService.getInstance().pegarTodos());
        List<String> nomesAlunos = new ArrayList<>();
        alunos.forEach(aluno -> nomesAlunos.add(aluno.getNome()));

        int index = listAlunos.getSelectedIndex();

        listAlunos.setListData(nomesAlunos.toArray(new String[0]));

        listAlunos.setSelectedIndex(index);

        System.out.println(alunos);
        System.out.println(nomesAlunos);
        System.out.println(nomesAlunos.toArray(new String[0]));*/
    }
}
