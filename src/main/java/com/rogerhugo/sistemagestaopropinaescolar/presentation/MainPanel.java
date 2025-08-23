package com.rogerhugo.sistemagestaopropinaescolar.presentation;

import com.rogerhugo.sistemagestaopropinaescolar.presentation.alunos.AlunosPanel;
import com.rogerhugo.sistemagestaopropinaescolar.presentation.pagamentos.PagamentosPanel;

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

        container.add(new PagamentosPanel(main), "pagamentos");
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
