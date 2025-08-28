package com.rogerhugo.sistemagestaopropinaescolar.presentation.cursos;

import com.rogerhugo.sistemagestaopropinaescolar.model.Curso;
import com.rogerhugo.sistemagestaopropinaescolar.service.CursoService;

import javax.swing.*;
import java.awt.*;

public class CursoEditDialog extends CursoFormDialog {

    public CursoEditDialog(Window own, Curso entity) {
        super(own, "Editar curso", entity);
    }

    @Override
    protected void initOtherComponents() {
        textFieldNome = new JTextField(entity.getNome(), 1000);
        textFieldValorPropina = new JTextField(Double.toString(entity.getValorPropina()), 1000);

        button = new JButton("Salvar");
    }

    @Override
    protected void addListeners() {
        int id = this.entity.getId();
        String nome = textFieldNome.getText();
        double valorPropina = Double.parseDouble(textFieldValorPropina.getText());

        Curso curso = new Curso(nome, valorPropina);

        if (!CursoService.getInstance().atualizar(id, curso))
            JOptionPane.showMessageDialog(this, "Erro ao salvar curso");

        dispose();
    }
}
