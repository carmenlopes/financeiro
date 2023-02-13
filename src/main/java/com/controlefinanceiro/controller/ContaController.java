package com.controlefinanceiro.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.controlefinanceiro.model.Conta;
import com.controlefinanceiro.service.ContaService;

@RestController
@RequestMapping("/api/conta")
public class ContaController {

   private final ContaService service;

    public ContaController(ContaService service) {
    this.service = service;
}

    @GetMapping
    public List<Conta> list(){
        return service.listAll();
    }
    
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Conta cadastrar(@RequestBody @Valid Conta conta) throws Throwable {
        return service.create(conta);
    }

    @PutMapping(value = "/{id}")
    public Conta update(@PathVariable @NotNull Long id,
            @RequestBody @Valid Conta conta) {
        return service.updateNome(id, conta);
    }

    @PutMapping(value = "/transferencia")
    public Optional<Conta> transferenciaEntreContas(@RequestBody @Valid TransferenciaDto transf) {
        return service.transferenciaEntreContas(transf);
    }
}
