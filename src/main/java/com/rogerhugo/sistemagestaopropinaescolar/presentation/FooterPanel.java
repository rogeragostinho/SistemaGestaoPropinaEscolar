package com.rogerhugo.sistemagestaopropinaescolar.presentation;

import com.rogerhugo.sistemagestaopropinaescolar.service.LoginService;

import javax.swing.*;
import java.util.Optional;

public class FooterPanel extends JPanel {
    private MainPanel main;

    public FooterPanel(MainPanel mainPanel) {
        main = mainPanel;

        String txt = LoginService.getInstance().getUser().getNome();
        JButton btn = new JButton("Sair");

        add(new JLabel(txt));
        add(btn);

        btn.addActionListener(e -> main.logout());
    }
}