package com.rogerhugo.sistemagestaopropinaescolar.presentation;

import com.rogerhugo.sistemagestaopropinaescolar.model.Aluno;
import com.rogerhugo.sistemagestaopropinaescolar.service.AlunoService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class AlunosPanel extends JPanel {
    private JPanel panelMain;
    private JPanel panelNorth;

    private JButton buttonAdicionarAluno;
    private JButton buttonEditarPessoa;
    private JButton buttonRemoverPessoa;

    private JPanel panelCenter;
    private JList<String> listPessoas;
    
    private JFrame main;

    public AlunosPanel(JFrame mainFrame) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        main = mainFrame;
        
        initComponents();
        addListeners();
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

        listPessoas = new JList<>();
        listPessoas.setBorder(new EmptyBorder(5, 7, 7, 5));
        listPessoas.setPreferredSize(listPessoas.getPreferredSize());

        panelCenter.add(listPessoas);

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
}
