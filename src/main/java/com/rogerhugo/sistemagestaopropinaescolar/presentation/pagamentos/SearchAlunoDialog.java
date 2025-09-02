package com.rogerhugo.sistemagestaopropinaescolar.presentation.pagamentos;

import com.rogerhugo.sistemagestaopropinaescolar.model.Aluno;
import com.rogerhugo.sistemagestaopropinaescolar.model.Pagamento;
import com.rogerhugo.sistemagestaopropinaescolar.service.AlunoService;
import com.rogerhugo.sistemagestaopropinaescolar.service.CursoService;
import com.rogerhugo.sistemagestaopropinaescolar.service.PagamentoService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SearchAlunoDialog extends JDialog {

    private JTable table;
    private JList list;
    private JTextField textField;
    private JButton button;

    public SearchAlunoDialog(JFrame own) {
        super(own, "Pesquisar aluno", true);

        init();
        addListeners();
        loadTable("");
        button.setEnabled(false);

        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setSize(600, 600);
        //setResizable(false);
        setLocationRelativeTo(own);
    }

    private void init() {
        setLayout(new BorderLayout());

        JPanel panelNorth = new JPanel(new BorderLayout());
        panelNorth.setBorder(new EmptyBorder(10, 10, 10, 10));

        JPanel panelNorthWest = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelNorthWest.add(new JLabel("Nome:"));
        textField = new JTextField(15);
        panelNorthWest.add(textField);

        panelNorth.add(panelNorthWest, BorderLayout.WEST);
        button = new JButton("Registrar Pagamento");
        panelNorth.add(button, BorderLayout.EAST);

        JPanel panelCenter = new JPanel(new GridLayout(2, 1));
        panelCenter.setBorder(new EmptyBorder(10, 10, 10, 10));

        table = new JTable();
        JScrollPane scrollTable = new JScrollPane(table);
        list = new JList();
        JScrollPane scrollList = new JScrollPane(list);

        JPanel panelCenterBottom = new JPanel(new BorderLayout());

        panelCenterBottom.add(new JLabel("Historico Pagamentos"), BorderLayout.NORTH);
        panelCenterBottom.add(scrollList, BorderLayout.CENTER);

        panelCenter.add(scrollTable);
        panelCenter.add(panelCenterBottom);

        add(panelNorth, BorderLayout.NORTH);
        add(panelCenter, BorderLayout.CENTER);
    }

    private void loadTable(String nome) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Id");
        model.addColumn("Nome");
        model.addColumn("Curso");

        List<Aluno> alunos = new ArrayList<>(AlunoService.getInstance().pesquisar(nome));
        alunos.forEach(aluno -> model.addRow(new Object[]{aluno.getId(), aluno.getNome(),
                CursoService.getInstance().pegar(aluno.getIdCurso()).getNome()
        }));

        table.setModel(model);
        setWidthColumns();
    }

    private void setWidthColumns() {
        TableColumn columnId = table.getColumnModel().getColumn(0);
        columnId.setMaxWidth(30);
    }

    private void loadList(int idAluno) {
        List<Pagamento> pagamentos = PagamentoService.getInstance().consultarHistorico(idAluno);
        String[] lines = new String[pagamentos.size()];

        for (int i = 0; i < pagamentos.size(); i++)
            lines[i] = ""+pagamentos.get(i).getValor() + " - " + pagamentos.get(i).getData();

        list.setListData(lines);
    }

    private void addListeners() {
        textField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                onChange();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                onChange();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                onChange();
            }

            private void onChange() {
                loadTable(textField.getText());
            }
        });

        table.getSelectionModel().addListSelectionListener(e -> {
            if (table.getSelectedRow() != -1) {
                int row = table.getSelectedRow();
                int idAluno = (Integer) table.getValueAt(row, 0);
                loadList(idAluno);

                button.setEnabled(true);
            } else {
                button.setEnabled(false);
            }
        });

        button.addActionListener(e -> {
            int row = table.getSelectedRow();
            int idAluno = (Integer) table.getValueAt(row, 0);
            System.out.println(idAluno);
            new PagamentoCreateDialog(this, idAluno).setVisible(true);
            loadTable("");
        });
    }
}
