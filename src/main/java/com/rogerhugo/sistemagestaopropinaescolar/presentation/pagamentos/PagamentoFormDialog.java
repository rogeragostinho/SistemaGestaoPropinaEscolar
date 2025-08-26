package com.rogerhugo.sistemagestaopropinaescolar.presentation.pagamentos;

import com.rogerhugo.sistemagestaopropinaescolar.model.Pagamento;
import com.rogerhugo.sistemagestaopropinaescolar.presentation.components.AbstractFormDialog;
import com.rogerhugo.sistemagestaopropinaescolar.presentation.enums.MesDoAno;
import com.rogerhugo.sistemagestaopropinaescolar.service.PagamentoService;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Vector;
import java.util.List;

public abstract class PagamentoFormDialog extends AbstractFormDialog<Pagamento> {
    private JLabel labelData;
    private JLabel labelValor;
    private JLabel labelMesLetivo;
    private JLabel labelAnoLetivo;
    protected JTextField textFieldData;
    protected JTextField textFieldValor;
    protected JComboBox<String> comboBoxMesLetivo;
    protected JTextField textFieldAnoLetivo;
    protected JButton button;

    protected int idAluno;

    public PagamentoFormDialog(Window own, String titulo, Pagamento pagamento, int idAluno) {
        super(own, titulo, pagamento);

        this.idAluno = idAluno;
        setMeses();
    }

    protected void setMeses() {
        List<Pagamento> pagamentoList = PagamentoService.getInstance().consultarHistorico(idAluno);
        List<Integer> pagamentosNumeros = new ArrayList<>();
        pagamentoList.forEach(e -> pagamentosNumeros.add(e.getMesLetivo().getNumero()));

        System.out.println(idAluno);
        System.out.println(pagamentoList);
        System.out.println(pagamentosNumeros);

        Vector<String> meses = new Vector<>();
        for (MesDoAno mesDoAno: MesDoAno.values())
            if (!pagamentosNumeros.contains(mesDoAno.getNumero()))
                meses.add(mesDoAno.getNome());

        DefaultComboBoxModel<String> defaultComboBoxModel = new DefaultComboBoxModel<>(meses);
        comboBoxMesLetivo.setModel(defaultComboBoxModel);
    }

    @Override
    protected void initComponents() {
        labelData = new JLabel("Data");
        labelValor = new JLabel("Valor");
        labelMesLetivo = new JLabel("Mês");
        labelAnoLetivo = new JLabel("Ano letivo");

        initOtherComponents();
    }

    protected void initOtherComponents() {
        LocalDate data = LocalDate.now();
        textFieldData = new JTextField(data.toString(), 1000);
        textFieldData.setEditable(false);
        textFieldValor = new JTextField(1000);

        // meses

        comboBoxMesLetivo = new JComboBox();
        //

        textFieldAnoLetivo = new JTextField(1000);

        button = new JButton("Adicionar");
    }

    @Override
    protected void addComponents() {
        addComponent(labelData, GridBagConstraints.WEST, GridBagConstraints.NONE, GridBagConstraints.REMAINDER, 0, new Insets(40, 40, 3, 40));
        addComponent(textFieldData, GridBagConstraints.CENTER, GridBagConstraints.BOTH, GridBagConstraints.REMAINDER, 1, new Insets(0, 40, 0, 40));

        addComponent(labelValor, GridBagConstraints.WEST, GridBagConstraints.NONE, GridBagConstraints.REMAINDER, 0, new Insets(15, 40, 3, 40));
        addComponent(textFieldValor, GridBagConstraints.CENTER, GridBagConstraints.BOTH, GridBagConstraints.REMAINDER, 1, new Insets(0, 40, 0, 40));

        addComponent(labelMesLetivo, GridBagConstraints.WEST, GridBagConstraints.NONE, GridBagConstraints.REMAINDER, 0, new Insets(15, 40, 3, 40));
        addComponent(comboBoxMesLetivo, GridBagConstraints.CENTER, GridBagConstraints.BOTH, GridBagConstraints.REMAINDER, 1, new Insets(0, 40, 0, 40));

        /*addComponent(labelMesLetivo, GridBagConstraints.WEST, GridBagConstraints.NONE, GridBagConstraints.REMAINDER, 0, new Insets(15, 40, 3, 40));
        addComponent(textFieldMesLetivo, GridBagConstraints.CENTER, GridBagConstraints.BOTH, GridBagConstraints.REMAINDER, 1, new Insets(0, 40, 0, 40));*/

        addComponent(labelAnoLetivo, GridBagConstraints.WEST, GridBagConstraints.NONE, GridBagConstraints.REMAINDER, 0, new Insets(15, 40, 3, 40));
        addComponent(textFieldAnoLetivo, GridBagConstraints.CENTER, GridBagConstraints.BOTH, GridBagConstraints.REMAINDER, 1, new Insets(0, 40, 0, 40));

        addComponent(button, GridBagConstraints.CENTER, GridBagConstraints.NONE, GridBagConstraints.REMAINDER, 0, new Insets(15, 0, 0, 0));
    }
}
