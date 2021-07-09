package com.group.pontointeligente.api.services;

import com.group.pontointeligente.api.entities.Funcionario;
import java.util.Optional;

public interface FuncionarioService {

    // Persiste um funcionário na base de dados.
    Funcionario persistir(Funcionario funcionario);

    // Busca e retorna um funcionário dado um CPF.
    Optional<Funcionario> buscarPorCpf(String cpf);

    // Busca e retorna um funcionário dado um email.
    Optional<Funcionario> buscarPorEmail(String email);

    // Busca e retorna um funcionário por ID.
    Optional<Funcionario> buscarPorId(Long id);
}
