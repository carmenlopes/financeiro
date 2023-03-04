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

import com.controlefinanceiro.anotacoes.Movimentar;
import com.controlefinanceiro.enums.MovimentacaoTipo;
import com.controlefinanceiro.model.Receita;
import com.controlefinanceiro.model.TipoReceita;
import com.controlefinanceiro.service.ReceitaService;

@RestController
@RequestMapping("/api/receita")
public class ReceitaController {
    
    private final ReceitaService service;

    public ReceitaController(ReceitaService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    @Movimentar(movimentacaoType = MovimentacaoTipo.RECEITA)
    public Receita cadastrarReceita(@RequestBody @Valid Receita receita) throws Throwable {
        return service.createReceita(receita);
    }

    @PostMapping(value = "/tiporeceita")
    @ResponseStatus(code = HttpStatus.CREATED)
    public TipoReceita cadastrarTipoReceita(@RequestBody @Valid TipoReceita tipoReceita) throws Throwable {
        return service.createTipoReceita(tipoReceita);
    }

    @GetMapping
    public List<Receita> list(){
        return service.listReceitas();
    }
    
    @GetMapping(value="/tiporeceita")
    public List<TipoReceita> listTipos(){
        return service.listTipos();
    }
}
