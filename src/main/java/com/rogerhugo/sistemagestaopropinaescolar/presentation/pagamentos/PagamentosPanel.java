package com.rogerhugo.sistemagestaopropinaescolar.presentation.pagamentos;

import com.rogerhugo.sistemagestaopropinaescolar.model.Aluno;
import com.rogerhugo.sistemagestaopropinaescolar.model.Pagamento;
import com.rogerhugo.sistemagestaopropinaescolar.service.AlunoService;
import com.rogerhugo.sistemagestaopropinaescolar.service.PagamentoService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PagamentosPanel extends JPanel {
    private final JFrame main;
    private JPanel panelNorth;
    private JPanel panelMain;
    private JButton buttonAdicionar;
    private JButton buttonVerDetalhes;
    private JButton buttonEliminar;
    private JPanel panelCenter;
    private JTable table;

    public PagamentosPanel(JFrame mainFrame) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.main = mainFrame;

        initComponents();
        addListeners();
        loadTable();
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

        buttonAdicionar = new JButton("Registrar novo pagamento");

        buttonVerDetalhes = new JButton("Ver");
        buttonEliminar = new JButton("Eliminar");
        //disableButtons();

        panelNorth.add(buttonAdicionar);
        panelNorth.add(Box.createGlue());
        panelNorth.add(buttonVerDetalhes);
        panelNorth.add(Box.createHorizontalStrut(5));
        panelNorth.add(buttonEliminar);

        panelNorth.setBorder(new EmptyBorder(0, 0, 7, 0));

        panelMain.add(panelNorth, BorderLayout.NORTH);
    }

    public void initPanelCenter()
    {
        panelCenter = new JPanel(new BorderLayout());
        panelCenter.setBorder(new EmptyBorder(30, 0, 0, 0));

        table = new JTable();
        JScrollPane scroll = new JScrollPane(table);

        panelCenter.add(scroll);

        panelMain.add(panelCenter);
    }

    private void addListeners() {
        buttonAdicionar.addActionListener(e -> new SearchAlunoDialog(main).setVisible(true));
    }

    private void loadTable() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Id");
        model.addColumn("Valor");
        model.addColumn("Data");

        List<Pagamento> pagamentos = new ArrayList<>(PagamentoService.getInstance().pegarTodos());
        pagamentos.forEach(pagamento -> model.addRow(new Object[]{pagamento.getId(), pagamento.getValor(), pagamento.getData()}));

        table.setModel(model);
        setWidthColumns();
    }

    private void setWidthColumns() {
        TableColumn columnId = table.getColumnModel().getColumn(0);
        columnId.setMaxWidth(30);
    }
}
