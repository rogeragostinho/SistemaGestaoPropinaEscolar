package com.rogerhugo.sistemagestaopropinaescolar.presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPanel extends JPanel {
    private MainPanel main;

    public MenuPanel(MainPanel mainPanel) {
        main = mainPanel;

        setBackground(Color.MAGENTA);
        setLayout(new GridLayout(3, 1));

        JButton button1 = new JButton("Pagamentos");
        JButton button2 = new JButton("Alunos");
        JButton button3 = new JButton("Cursos");

        add(button1);
        add(button2);
        add(button3);

        button1.addActionListener(e -> main.show("pagamentos"));

        button2.addActionListener(e -> main.show("alunos"));

        button3.addActionListener(e -> main.show("cursos"));
    }
}
