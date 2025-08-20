package com.rogerhugo.sistemagestaopropinaescolar.presentation;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    private MainFrame main;

    private CardLayout card;
    private JPanel container;

    private JPanel panelLeft;

    public MainPanel(MainFrame mainFrame) {
        setLayout(new BorderLayout());
        main = mainFrame;

        card = new CardLayout();
        container = new JPanel(card);

        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.RED);

        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.BLUE);

        container.add(panel1, "panel1");
        container.add(panel2, "panel2");
        container.add(new AlunosPanel(main), "alunos");

        add(new MenuPanel(this), BorderLayout.WEST);
        add(container, BorderLayout.CENTER);
        add(new FooterPanel(this), BorderLayout.SOUTH);
    }

    public void show(String name) {
        card.show(container, name);;
    }

    public void logout() {
        main.logout();
    }
}
