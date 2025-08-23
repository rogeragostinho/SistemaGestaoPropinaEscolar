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

        add(button1);
        add(button2);

        button1.addActionListener(e -> main.show("pagamentos"));

        button2.addActionListener(e -> main.show("alunos"));
    }
}
