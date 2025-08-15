package com.rogerhugo.sistemagestaopropinaescolar.presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {
    private Container container;
    private JPanel panelLeft;
    public MainWindow() {
        super("Main");
        container = getContentPane();
        setLayout(new BorderLayout());

        panelLeft = new JPanel();
        panelLeft.setLayout(new GridLayout(3, 1));

        JButton button1 = new JButton("Pagamentos");
        JButton button2 = new JButton("Alunos");

        panelLeft.add(button1);
        panelLeft.add(button2);

        add(panelLeft, BorderLayout.WEST);

        add(new JLabel("Solene"));
        //add(new JPanel()).setBackground(Color.RED);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(null, "Ola");
                JPanel panel = new JPanel();
                panel.setBackground(Color.RED);
                add(panel, BorderLayout.CENTER);
                revalidate();
                repaint();
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel panel = new JPanel();
                panel.setBackground(Color.BLUE);
                add(panel, BorderLayout.CENTER);
                revalidate();
                repaint();
            }
        });

        setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
        setSize(500, 500);
        setResizable(false);
        setLocationRelativeTo(null); // inicia no centro da tela
        setVisible(true);
    }
}
