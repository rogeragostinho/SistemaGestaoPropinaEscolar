package com.rogerhugo.sistemagestaopropinaescolar.presentation;

import com.rogerhugo.sistemagestaopropinaescolar.service.LoginService;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends javax.swing.JFrame {
    private boolean logado;
    private CardLayout card;
    private JPanel container;

    public MainFrame() {
        super("Main");
        setLayout(new BorderLayout());

        card = new CardLayout();
        container = new JPanel(card);

        container.add(new LoginPanel(this), "login");

        add(container);

        setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
        setSize(800, 500);
        //setResizable(false);
        setLocationRelativeTo(null); // inicia no centro da tela
        setVisible(true);
    }

    public void init() {
        container.add(new MainPanel(this), "main");
        show("main");
    }

    public void setLogado(boolean logado) {
        this.logado = logado;
        if (logado)
            init();
    }

    public void show(String name) {
        card.show(container, name);;
    }

    public void logout() {
        LoginService.getInstance().logout();
        atualizar();
    }

    public void atualizar() {
        if (!LoginService.getInstance().isLoged())
            show("login");
    }
}
