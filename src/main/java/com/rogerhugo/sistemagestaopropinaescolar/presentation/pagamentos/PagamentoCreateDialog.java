package com.rogerhugo.sistemagestaopropinaescolar.presentation.pagamentos;

import com.rogerhugo.sistemagestaopropinaescolar.model.Pagamento;
import com.rogerhugo.sistemagestaopropinaescolar.enums.MesDoAno;
import com.rogerhugo.sistemagestaopropinaescolar.service.PagamentoService;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class PagamentoCreateDialog extends PagamentoFormDialog {

    protected int idAluno;

    public PagamentoCreateDialog(Window own, int idAluno) {
        super(own, "Novo pagamento", null, idAluno);

        this.idAluno = idAluno;
    }

    @Override
    protected void addListeners() {
        button.addActionListener(e -> {
            LocalDate data = LocalDate.parse(textFieldData.getText());
            double valor = Double.parseDouble(textFieldValor.getText());
            MesDoAno mesLetivo = MesDoAno.mesDoAnoByNome((String)comboBoxMesLetivo.getSelectedItem());
            int anoLetivo = Integer.parseInt(textFieldAnoLetivo.getText());

            Pagamento pagamento = new Pagamento(idAluno, anoLetivo, mesLetivo, valor, data);

            System.out.println(pagamento);

            if (!PagamentoService.getInstance().registar(pagamento))
                JOptionPane.showMessageDialog(this, "Erro ao registrar novo pagamento");

            dispose();
        });
    }
}
