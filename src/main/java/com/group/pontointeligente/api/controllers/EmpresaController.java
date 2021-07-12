package com.group.pontointeligente.api.controllers;

import com.group.pontointeligente.api.dtos.CadastroPJDto;
import com.group.pontointeligente.api.dtos.EmpresaDto;
import com.group.pontointeligente.api.entities.Empresa;
import com.group.pontointeligente.api.response.Response;
import com.group.pontointeligente.api.services.EmpresaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@RestController
@RequestMapping("/api/empresas")
@CrossOrigin(origins = "*") // Possibilidade da API ser acessivel por várias aplicacoes
public class EmpresaController {
    private static final Logger log = LoggerFactory.getLogger(CadastroPJController.class);

    @Autowired
    private EmpresaService empresaService;

    public EmpresaController() {

    }

    @GetMapping(value = "cnpj/{cnpj}")
    public ResponseEntity<Response<EmpresaDto>> buscarPorCnpj(@PathVariable("cnpj") String cnpj) {
        log.info("Buscando empresa por CNPJ: {}", cnpj);
        Response<EmpresaDto> response = new Response<EmpresaDto>();

        Optional<Empresa> empresa = empresaService.buscarPorCnpj(cnpj);

        if (!empresa.isPresent()) {
            log.info("Empresa não encontrada para o CNPJ: {}", cnpj);
            response.getErrors().add("Empresa não encontrada para o CNPJ " + cnpj);
            return ResponseEntity.badRequest().body(response);
        }

        response.setData(this.converterEmpresaDto(empresa.get()));
        return ResponseEntity.ok(response);
    }

    private EmpresaDto converterEmpresaDto(Empresa empresa) {
        EmpresaDto empresaDto = new EmpresaDto();
        empresaDto.setId(empresa.getId());
        empresaDto.setCnpj(empresa.getCnpj());
        empresaDto.setRazaoSocial(empresa.getRazaoSocial());

        return empresaDto;
    }
}
