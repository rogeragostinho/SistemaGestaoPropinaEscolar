package com.rogerhugo.sistemagestaopropinaescolar.presentation;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView extends JFrame {
    private JLabel labelNome;
    private JLabel labelSenha;
    protected JTextField textFieldNome;
    protected JTextField textFieldSenha;
    protected JButton button;
    private JPanel panelCenter;
    public LoginView() {
        super("Login");
        setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));

        initComponents();
        addListeners();

        setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
        setSize(300, 200);
        setResizable(false);
        setLocationRelativeTo(null); // inicia no centro da tela
        setVisible(true);
    }

    private void initComponents() {
        GridBagLayout layout = new GridBagLayout();
        panelCenter = new JPanel();
        panelCenter.setLayout(layout);

        labelNome = new JLabel("Nome");
        labelSenha = new JLabel("Senha");

        textFieldNome = new JTextField(6);
        textFieldSenha = new JTextField(6);

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

    public void addListeners()
    {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new MainWindow();
                setVisible(false);
            }
        });
    }
}
