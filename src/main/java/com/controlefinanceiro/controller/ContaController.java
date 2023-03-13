package com.controlefinanceiro.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.controlefinanceiro.dto.MetaDto;
import com.controlefinanceiro.dto.TransferenciaDto;
import com.controlefinanceiro.model.Conta;
import com.controlefinanceiro.model.Meta;
import com.controlefinanceiro.service.ContaService;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/conta")
public class ContaController {

   private final ContaService service;

    public ContaController(ContaService service) {
    this.service = service;
}

    @Operation(summary = "Todas as contas bancárias")
    @GetMapping
    public List<Conta> list(){
        return service.listAll();
    }
    
    @Operation(summary = "Cadastrar uma nova conta bancária")
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Conta cadastrar(@RequestBody @Valid Conta conta) throws Throwable {
        return service.create(conta);
    }

    @Operation(summary = "Editar o nome da conta")
    @PutMapping(value = "/{id}")
    public Conta update(@PathVariable @NotNull Long id,
            @RequestBody @Valid Conta conta) {
        return service.updateNome(id, conta);
    }

    @PutMapping(value = "/transferencia") @Operation(summary = "Transferencia entre contas")
    public Optional<Conta> transferenciaEntreContas(@RequestBody @Valid TransferenciaDto transf) {
        return service.transferenciaEntreContas(transf);
    }

    @PutMapping(value = "/transferencia/meta") @Operation(summary = "Transferencia de conta para meta")
    public Optional<Meta> transferenciaContaParaMeta(@RequestBody @Valid MetaDto transf) {
        return service.transferenciaParaMeta(transf);
    }
}
