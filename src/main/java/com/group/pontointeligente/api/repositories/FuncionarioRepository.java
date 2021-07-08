package com.group.pontointeligente.api.repositories;

import com.group.pontointeligente.api.entities.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    // O spring cria o select automaticamente
    Funcionario findByCpf(String cpf);

    // O spring cria o select automaticamente
    Funcionario findByEmail(String email);

    // O spring cria o select automaticamente
    Funcionario findByCpfOrEmail(String cpf, String email);
}
