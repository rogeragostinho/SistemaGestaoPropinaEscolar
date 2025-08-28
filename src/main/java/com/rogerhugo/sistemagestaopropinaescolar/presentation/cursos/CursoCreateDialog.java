package com.rogerhugo.sistemagestaopropinaescolar.presentation.cursos;

import com.rogerhugo.sistemagestaopropinaescolar.model.Curso;
import com.rogerhugo.sistemagestaopropinaescolar.service.AlunoService;
import com.rogerhugo.sistemagestaopropinaescolar.service.CursoService;

import javax.swing.*;
import java.awt.*;

public class CursoCreateDialog extends CursoFormDialog {

    public CursoCreateDialog(Window own) {
        super(own, "Novo curso", null);
    }

    @Override
    protected void addListeners() {
        button.addActionListener(e -> {
            String nome = textFieldNome.getText();
            double valorPropina = Double.parseDouble(textFieldValorPropina.getText());

            Curso curso = new Curso(nome, valorPropina);

            if (!CursoService.getInstance().registar(curso))
                JOptionPane.showMessageDialog(this, "Erro ao adicionar novo curso");

            dispose();
        });
    }
}
