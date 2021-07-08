package com.group.pontointeligente.api.services;

import com.group.pontointeligente.api.entities.Empresa;
import java.util.Optional;

public interface EmpresaService {

    // Retorna uma empresa dado um CNPJ.
    Optional<Empresa> buscarPorCnpj(String cnpj);

    // Cadastra uma nova empresa na base de dados.
    Empresa persistir(Empresa empresa);
}
