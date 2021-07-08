package com.group.pontointeligente.api.repositories;

import com.group.pontointeligente.api.entities.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

    // O spring cria o select automaticamente
    @Transactional
    Empresa findByCnpj(String cnpj);
}
