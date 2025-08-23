package com.rogerhugo.sistemagestaopropinaescolar.presentation.alunos;

import com.rogerhugo.sistemagestaopropinaescolar.model.Aluno;
import com.rogerhugo.sistemagestaopropinaescolar.service.AlunoService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class AlunosPanel extends JPanel {
    private JPanel panelMain;
    private JPanel panelNorth;

    private JButton buttonAdicionarAluno;
    private JButton buttonVerAluno;
    private JButton buttonEliminarAluno;

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

        buttonVerAluno = new JButton("Ver");
        buttonEliminarAluno = new JButton("Eliminar");
        disableButtons();

        panelNorth.add(buttonAdicionarAluno);
        panelNorth.add(Box.createGlue());
        panelNorth.add(buttonVerAluno);
        panelNorth.add(Box.createHorizontalStrut(5));
        panelNorth.add(buttonEliminarAluno);

        panelNorth.setBorder(new EmptyBorder(0, 0, 7, 0));

        panelMain.add(panelNorth, BorderLayout.NORTH);
    }

    public void initPanelCenter()
    {
        panelCenter = new JPanel(new BorderLayout());
        panelCenter.setBorder(new EmptyBorder(30, 0, 0, 0));

        tableAlunos = new JTable();
        JScrollPane scroll = new JScrollPane(tableAlunos);

        panelCenter.add(scroll);

        panelMain.add(panelCenter);
    }

    private void addListeners() {
        buttonAdicionarAluno.addActionListener(e -> {
            new AlunoCreateDialog(main).setVisible(true);
            carregarTabelaAlunos();
        });

        buttonVerAluno.addActionListener(e -> {
            int row = tableAlunos.getSelectedRow();
            int index = (Integer) tableAlunos.getValueAt(row, 0);
            Aluno aluno = AlunoService.getInstance().pegar(index);
            new AlunoShowDialog(main, aluno).setVisible(true);
            carregarTabelaAlunos();
        });

        buttonEliminarAluno.addActionListener(e -> {
            int row = tableAlunos.getSelectedRow();
            int index = (Integer) tableAlunos.getValueAt(row, 0);
            if (JOptionPane.showConfirmDialog(this, "Tem certeza que deseja eliminar este aluno?", "Escolha uma Opção", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                AlunoService.getInstance().eliminar(index);
                carregarTabelaAlunos();
            }
        });

        tableAlunos.getSelectionModel().addListSelectionListener(e -> {
            if (tableAlunos.getSelectedRow() != -1)
                enableButtons();
            else
                disableButtons();
        });
    }

    private void carregarTabelaAlunos() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Id");
        model.addColumn("Nome");
        model.addColumn("Curso");

        List<Aluno> alunos = new ArrayList<>(AlunoService.getInstance().pegarTodos());
        alunos.forEach(aluno -> model.addRow(new Object[]{aluno.getId(), aluno.getNome(), aluno.getCurso()}));

        tableAlunos.setModel(model);
        setWidthColumns();
    }

    private void setWidthColumns() {
        TableColumn columnId = tableAlunos.getColumnModel().getColumn(0);
        columnId.setMaxWidth(30);
    }

    private void enableButtons() {
        buttonVerAluno.setEnabled(true);
        buttonEliminarAluno.setEnabled(true);
    }

    private void disableButtons() {
        buttonVerAluno.setEnabled(false);
        buttonEliminarAluno.setEnabled(false);
    }
}
