package com.rogerhugo.sistemagestaopropinaescolar;

import com.rogerhugo.sistemagestaopropinaescolar.model.Aluno;
import com.rogerhugo.sistemagestaopropinaescolar.model.Usuario;
import com.rogerhugo.sistemagestaopropinaescolar.presentation.LoginView;
import com.rogerhugo.sistemagestaopropinaescolar.service.AlunoService;
import com.rogerhugo.sistemagestaopropinaescolar.service.UsuarioService;

public class App {
    public static void main(String[] args) {
        // TESTE Alunos
            //System.out.println(AlunoService.getInstance().registar(new Aluno("Adão", "EI1A", "2º", "Engenharia Informática")));

            //System.out.println(AlunoService.getInstance().atualizar(5, new Aluno("Hugo", "EI2A", "2º", "Engenharia Informática")));

            //System.out.println(AlunoService.getInstance().eliminar(5));

            //System.out.println(AlunoService.getInstance().pegarTodos());

            //System.out.println(AlunoService.getInstance().pegar(1));

        // TESTE usuarios
        //System.out.println(UsuarioService.getInstance().registar(new Usuario("operador", "Hugo", "123")));

        //System.out.println(UsuarioService.getInstance().atualizar(1, new Usuario("financeiro", "Hugo", "123")));

        //System.out.println(UsuarioService.getInstance().eliminar(1));

        //System.out.println(UsuarioService.getInstance().pegarTodos());

        /*LoginView loginView = */new LoginView();
    }
}
