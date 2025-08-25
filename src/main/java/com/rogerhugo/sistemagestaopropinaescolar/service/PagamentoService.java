package com.rogerhugo.sistemagestaopropinaescolar.service;

import com.rogerhugo.sistemagestaopropinaescolar.model.Pagamento;
import com.rogerhugo.sistemagestaopropinaescolar.repository.PagamentoRepository;

import java.util.List;

public class PagamentoService extends AbstractService<Pagamento, PagamentoRepository> {
    private static final PagamentoService instance = new PagamentoService();

    protected PagamentoService() {
        super(PagamentoRepository.getInstance());
    }

    public static PagamentoService getInstance() {
        return instance;
    }

    public List<Pagamento> consultarHistorico(int idAluno) {
        return repository.search("idAluno", idAluno);
    }
}
