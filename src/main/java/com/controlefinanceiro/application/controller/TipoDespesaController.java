package com.controlefinanceiro.application.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.controlefinanceiro.domain.model.types.TipoDespesa;
import com.controlefinanceiro.service.TipoDespesaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/tipodespesa")
public class TipoDespesaController {

    private final TipoDespesaService service;

    public TipoDespesaController(TipoDespesaService service) {
        this.service = service;
    }

    @GetMapping
    public List<TipoDespesa> list(){
        return service.listAll();
    }
    
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public TipoDespesa gravar(@RequestBody @Valid TipoDespesa despesa) throws Throwable {
        return service.create(despesa);
    }
    
}
