package com.group.pontointeligente.api.services.impl;

import com.group.pontointeligente.api.entities.Lancamento;
import com.group.pontointeligente.api.repositories.LancamentoRepository;
import com.group.pontointeligente.api.services.LancamentoService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LancamentoServiceImpl implements LancamentoService {
    private static final Logger log = LoggerFactory.getLogger(LancamentoServiceImpl.class);

    @Autowired
    private LancamentoRepository lancamentoRepository;

    public Page<Lancamento> buscarPorFuncionarioId(Long funcionarioId, PageRequest pageRequest) {
        log.info("Buscando lançamentos para o funcionário ID {}", funcionarioId);
        return this.lancamentoRepository.findByFuncionarioId(funcionarioId, pageRequest);
    }

    @Cacheable("lancamentoPorId")
    public Optional<Lancamento> buscarPorId(Long id) {
        log.info("Buscando um lançamento pelo ID {}", id);
        return this.lancamentoRepository.findById(id);
    }

    @CachePut("lancamentoPorId")
    public Lancamento persistir(Lancamento lancamento) {
        log.info("Persistindo o lançamento: {}", lancamento);
        return this.lancamentoRepository.save(lancamento);
    }

    public void remover(Long id) {
        log.info("Removendo o lançamento ID {}", id);
        this.lancamentoRepository.deleteById(id);
    }

}
