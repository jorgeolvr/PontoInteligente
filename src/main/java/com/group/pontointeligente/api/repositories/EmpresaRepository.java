package com.group.pontointeligente.api.repositories;

import com.group.pontointeligente.api.entities.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.Optional;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

    // Spring cria o select automaticamente
    @Transactional
    Empresa findByCnpj(String cnpj);
}
