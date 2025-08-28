package com.rogerhugo.sistemagestaopropinaescolar.service;

import java.util.List;

public interface GenericService<T> {
    boolean registar(T t);
    T pegar(int id);
    List<T> pegarTodos();
    boolean atualizar(int id, T t);
    boolean eliminar(int id);
    <U> List<T> pesquisar(String campo, U valor);
    <U> List<T> pegarTodosPelo(String campo, U valor);
    <U> T pegarPelo(String campo, U valor);

}
