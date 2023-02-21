package com.controlefinanceiro.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.controlefinanceiro.dto.MetaEditReq;
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

    @PutMapping(value= "/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public @Valid Optional<Meta> editarDados(@PathVariable @Positive @NotNull Long id, @RequestBody MetaEditReq req) throws Throwable {
        return service.update(id, req);
    }

    //TODO: Add na meta
    //TODO: Resgatar da meta


}
