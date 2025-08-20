package com.rogerhugo.sistemagestaopropinaescolar.presentation;

import com.rogerhugo.sistemagestaopropinaescolar.model.Aluno;

import javax.swing.*;

public class AlunoCreateDialog extends AlunoFormDialog {
    public AlunoCreateDialog(JFrame own, Aluno aluno) {
        super(own, "Novo Aluno", aluno);
    }
}
