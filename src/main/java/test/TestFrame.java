package test;

import com.rogerhugo.sistemagestaopropinaescolar.presentation.AlunoFormPanel;
import com.rogerhugo.sistemagestaopropinaescolar.presentation.LoginPanel;
import com.rogerhugo.sistemagestaopropinaescolar.presentation.MainPanel;
import com.rogerhugo.sistemagestaopropinaescolar.service.LoginService;

import javax.swing.*;
import java.awt.*;

public class TestFrame extends JFrame {
    private boolean logado;
    private CardLayout card;
    private JPanel container;

    public TestFrame() {
        super("Test");
        setLayout(new BorderLayout());

        add(new AlunoFormPanel());

        setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
        setSize(800, 500);
        //setResizable(false);
        setLocationRelativeTo(null); // inicia no centro da tela
        setVisible(true);
    }
}
