package com.rogerhugo.sistemagestaopropinaescolar.presentation.cursos;

import com.rogerhugo.sistemagestaopropinaescolar.model.Curso;
import com.rogerhugo.sistemagestaopropinaescolar.model.Pagamento;
import com.rogerhugo.sistemagestaopropinaescolar.presentation.pagamentos.PagamentoShowDialog;
import com.rogerhugo.sistemagestaopropinaescolar.presentation.pagamentos.SearchAlunoDialog;
import com.rogerhugo.sistemagestaopropinaescolar.service.CursoService;
import com.rogerhugo.sistemagestaopropinaescolar.service.PagamentoService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CursosPanel extends JPanel {

    private final JFrame main;
    private JPanel panelNorth;
    private JPanel panelMain;
    private JButton buttonAdicionar;
    private JButton buttonEliminar;
    private JPanel panelCenter;
    private JTable table;

    public CursosPanel(JFrame main) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.main = main;

        initComponents();
        addListeners();
        loadTable();
        disableButtons();
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

        buttonAdicionar = new JButton("Novo Curso");

        buttonEliminar = new JButton("Eliminar");
        //disableButtons();

        panelNorth.add(buttonAdicionar);
        panelNorth.add(Box.createGlue());
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

    private void loadTable() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Id");
        model.addColumn("Nome");
        model.addColumn("Valor Propina");

        List<Curso> cursos = new ArrayList<>(CursoService.getInstance().pegarTodos());
        cursos.forEach(curso -> model.addRow(new Object[] {curso.getId(), curso.getNome(), curso.getValorPropina()}));

        table.setModel(model);
        setWidthColumns();
    }

    private void setWidthColumns() {
        TableColumn columnId = table.getColumnModel().getColumn(0);
        columnId.setMaxWidth(30);
    }

    private void enableButtons() {
        buttonEliminar.setEnabled(true);
    }

    private void disableButtons() {
        buttonEliminar.setEnabled(false);
    }

    private void addListeners() {
        buttonAdicionar.addActionListener(e -> {
            new CursoCreateDialog(main).setVisible(true);
            loadTable();
        });

        buttonEliminar.addActionListener(e -> {
            int row = table.getSelectedRow();
            int id = (Integer) table.getValueAt(row, 0);
            if (JOptionPane.showConfirmDialog(this, "Tem certeza que deseja eliminar este registro?", "Escolha uma Opção", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                CursoService.getInstance().eliminar(id);
                loadTable();
            }
        });

        table.getSelectionModel().addListSelectionListener(e -> {
            if (table.getSelectedRow() != -1)
                enableButtons();
            else
                disableButtons();
        });
    }
}
