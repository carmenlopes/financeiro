package com.controlefinanceiro.application.controller;

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

import com.controlefinanceiro.domain.model.dto.MetaEditReq;
import com.controlefinanceiro.domain.model.Meta;
import com.controlefinanceiro.service.MetaService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

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

    @PutMapping(value= "/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public @Valid Optional<Meta> editarDados(@PathVariable @Positive @NotNull Long id, @RequestBody MetaEditReq req) throws Throwable {
        return service.update(id, req);
    }

    @PutMapping(value= "/guardar/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public @Valid Optional<Meta> guardarNaMeta(@PathVariable @Positive @NotNull Long id, @RequestBody Meta req) throws Throwable {
        return service.guardarNaMeta(id, req); //TODO: Refazer regra
    }

    @PutMapping(value= "/resgatar/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public @Valid Optional<Meta> resgatarDaMeta(@PathVariable @Positive @NotNull Long id, @RequestBody Meta req) throws Throwable {
        return service.resgatardaMeta(id, req);
    }


}
