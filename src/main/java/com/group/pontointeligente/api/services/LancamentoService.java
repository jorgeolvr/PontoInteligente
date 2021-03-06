package com.group.pontointeligente.api.services;

import com.group.pontointeligente.api.entities.Lancamento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Optional;

public interface LancamentoService {
     // Retorna uma lista paginada de lançamentos de um determinado funcionário.
    Page<Lancamento> buscarPorFuncionarioId(Long funcionarioId, PageRequest pageRequest);

    // Retorna um lançamento por ID.
    Optional<Lancamento> buscarPorId(Long id);

    // Persiste um lançamento na base de dados.
    Lancamento persistir(Lancamento lancamento);

    // Remove um lançamento da base de dados.
    void remover(Long id);

}
