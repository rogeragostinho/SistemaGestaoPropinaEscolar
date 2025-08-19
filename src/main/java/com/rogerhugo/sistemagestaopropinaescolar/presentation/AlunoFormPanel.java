package com.rogerhugo.sistemagestaopropinaescolar.presentation;

import javax.swing.*;
import java.awt.*;

public class AlunoFormPanel extends JPanel {
    private JTextField textFieldNome;
    private JTextField textFieldClasse;
    private JTextField textFieldCurso;
    private JTextField textFieldTurma;

    public AlunoFormPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        textFieldNome = new JTextField(1000);
        //add(Box.createGlue());
        textFieldNome.setMaximumSize(textFieldNome.getPreferredSize());
        textFieldClasse = new JTextField(1000);
        textFieldClasse.setMaximumSize(textFieldClasse.getPreferredSize());
        textFieldCurso = new JTextField(1000);
        textFieldCurso.setMaximumSize(textFieldCurso.getPreferredSize());
        textFieldTurma = new JTextField(Integer.MAX_VALUE);
        textFieldTurma.setMaximumSize(textFieldTurma.getPreferredSize());

        JLabel lbl = new JLabel("Nome");
        lbl.setForeground(Color.BLUE);
        lbl.setBackground(Color.BLUE);
        add(lbl);
        //add(textFieldNome);
        addComponent(textFieldNome);

        add(new JLabel("Classe"));
        add(textFieldClasse);

        add(new JLabel("Curso"));
        add(textFieldCurso);

        add(new JLabel("Turma"));
        add(textFieldTurma);

    }

    private void addComponent(Component cmp) {
        JPanel panel = new JPanel();
        panel.add(cmp);
        add(cmp);
    }
}
