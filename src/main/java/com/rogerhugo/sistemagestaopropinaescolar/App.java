package com.rogerhugo.sistemagestaopropinaescolar;

import com.rogerhugo.sistemagestaopropinaescolar.model.Aluno;
import com.rogerhugo.sistemagestaopropinaescolar.service.AlunoService;

public class App {
    public static void main(String[] args) {
        //System.out.println(AlunoService.getInstance().registrar(new Aluno("Róger Hugo", "EI1A", "2º", "Engenharia Informática")));

        //System.out.println(AlunoService.getInstance().atualizar(2, new Aluno("Róger Agostinho", "EI1A", "2º", "Engenharia Informática")));

        //System.out.println(AlunoService.getInstance().eliminar(3));

        System.out.println(AlunoService.getInstance().pegarTodos());
    }
}
