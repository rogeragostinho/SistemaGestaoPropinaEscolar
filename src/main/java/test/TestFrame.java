package test;

import com.rogerhugo.sistemagestaopropinaescolar.presentation.alunos.AlunoShowDialog;
import com.rogerhugo.sistemagestaopropinaescolar.presentation.alunos.AlunosPanel;

import javax.swing.*;
import java.awt.*;

public class TestFrame extends JFrame {

    public TestFrame() {
        super("Test");
        setLayout(new BorderLayout());

        //add(new AlunoFormPanel());
        add(new AlunosPanel(this));

        setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
        setSize(800, 500);
        //setResizable(false);
        setLocationRelativeTo(null); // inicia no centro da tela
        setVisible(true);
    }
}
