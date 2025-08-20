package com.rogerhugo.sistemagestaopropinaescolar.presentation;

import com.rogerhugo.sistemagestaopropinaescolar.service.LoginService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class LoginPanel extends JPanel {
    private JLabel labelNome;
    private JLabel labelSenha;
    protected JTextField textFieldNome;
    protected JPasswordField textFieldSenha;
    protected JButton button;
    private JPanel panelCenter;

    private MainFrame main;

    public LoginPanel(MainFrame mainFrame) {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        main = mainFrame;

        initComponents();
        addListeners();

        setSize(300, 200); // inicia no centro da tela
        setVisible(true);
    }

    private void initComponents() {
        GridBagLayout layout = new GridBagLayout();
        panelCenter = new JPanel();
        panelCenter.setLayout(layout);

        labelNome = new JLabel("Nome");
        labelSenha = new JLabel("Senha");

        textFieldNome = new JTextField(6);
        textFieldSenha = new JPasswordField(6);

        button = new JButton("Entrar");

        textFieldNome.setBorder(new EmptyBorder(4, 5, 4, 5));
        textFieldSenha.setBorder(new EmptyBorder(4, 5, 4, 5));

        addComponent(labelNome, GridBagConstraints.WEST, GridBagConstraints.NONE, GridBagConstraints.REMAINDER, 0, new Insets(0, 0, 3, 0));

        addComponent(textFieldNome, GridBagConstraints.CENTER, GridBagConstraints.BOTH, GridBagConstraints.REMAINDER, 1);

        addComponent(labelSenha, GridBagConstraints.WEST, GridBagConstraints.NONE, GridBagConstraints.REMAINDER, 0, new Insets(15, 0, 3, 0));

        addComponent(textFieldSenha, GridBagConstraints.CENTER, GridBagConstraints.BOTH, GridBagConstraints.REMAINDER, 1, new Insets(0, 0, 0, 0));

        addComponent(button, GridBagConstraints.CENTER, GridBagConstraints.NONE, GridBagConstraints.REMAINDER, 0, new Insets(15, 0, 0, 0));

        add(Box.createHorizontalStrut(40));
        add(panelCenter);
        add(Box.createHorizontalStrut(40));
    }

    public void addComponent(Component component, int anchor, int fill, int gridwidth, int weightx)
    {
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.anchor = anchor;
        constraints.fill = fill;
        constraints.gridwidth = gridwidth;
        constraints.weightx = weightx;

        GridBagLayout layout = (GridBagLayout) panelCenter.getLayout();
        layout.setConstraints(component, constraints);
        panelCenter.add(component);
    }

    public void addComponent(Component component, int anchor, int fill, int gridwidth, int weightx, Insets insets)
    {
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.anchor = anchor;
        constraints.fill = fill;
        constraints.gridwidth = gridwidth;
        constraints.weightx = weightx;
        constraints.insets = insets;

        GridBagLayout layout = (GridBagLayout) panelCenter.getLayout();
        layout.setConstraints(component, constraints);
        panelCenter.add(component);
    }

    public void addListeners() {
        button.addActionListener(e -> {
            String nome = textFieldNome.getText();
            String senha = textFieldSenha.getText();

            if (LoginService.getInstance().login(nome, senha))
                main.setLogado(true);
            else
                JOptionPane.showMessageDialog(null, "Erro ao fazer login");

            limparCampos();
        });

        button.registerKeyboardAction(
            e -> button.doClick(),
            KeyStroke.getKeyStroke("ENTER"),
            JComponent.WHEN_FOCUSED
        );

        ActionListener action = e -> button.doClick();
        textFieldNome.addActionListener(action);
        textFieldSenha.addActionListener(action);
    }

    private void limparCampos() {
        textFieldNome.setText("");
        textFieldSenha.setText("");
        textFieldNome.requestFocusInWindow();
    }
}
