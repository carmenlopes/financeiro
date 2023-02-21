package com.controlefinanceiro.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.controlefinanceiro.model.Meta;
import com.controlefinanceiro.service.MetaService;

@RestController
@RequestMapping("/api/meta")
public class MetaController {
    
    private final MetaService service;

    public MetaController(MetaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Meta> list(){
        return service.listAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Meta cadastrar(@RequestBody @Valid Meta meta) throws Throwable {
        return service.create(meta);
    }

    //TODO: Editar meta (nome, mensal)
    //TODO: Add na meta
    //TODO: Resgatar da meta


}