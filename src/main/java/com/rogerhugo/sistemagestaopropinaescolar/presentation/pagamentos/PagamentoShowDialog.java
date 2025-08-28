package com.rogerhugo.sistemagestaopropinaescolar.presentation.pagamentos;

import com.rogerhugo.sistemagestaopropinaescolar.model.Pagamento;
import com.rogerhugo.sistemagestaopropinaescolar.service.PagamentoService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class PagamentoShowDialog extends JDialog {

    private final Pagamento pagamento;
    private final JButton buttonFechar;
    private final JButton buttonEliminar;

    public PagamentoShowDialog(JFrame own, Pagamento pagamento) {
        super(own, "Detalhes do Aluno", true);
        setLayout(new BorderLayout());

        this.pagamento = pagamento;

        JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout(FlowLayout.RIGHT));
        panel1.setBorder(new EmptyBorder(0, 0, 0, 10));

        buttonEliminar = new JButton("Eliminar");
        panel1.add(buttonEliminar);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
        panel2.setBorder(new EmptyBorder(10, 15, 0, 15));

        panel2.add(new JLabel("Data:" + pagamento.getData()));
        panel2.add(new JLabel("Mês letivo:" + pagamento.getMesLetivo()));
        panel2.add(new JLabel("Ano Letivo:" + pagamento.getAnoLetivo()));
        panel2.add(new JLabel("Valor:" + pagamento.getValor()));
        panel2.add(new JLabel("Aluno:" + pagamento));
        //panel2.add(new JLabel(":" + pagamento));

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
        buttonFechar.addActionListener(e -> dispose());

        buttonEliminar.addActionListener(e -> {
            if (JOptionPane.showConfirmDialog(this, "Tem certeza que deseja eliminar este registro?", "Escolha uma Opção", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                PagamentoService.getInstance().eliminar(pagamento.getId());
                dispose();
            }
        });
    }
}
