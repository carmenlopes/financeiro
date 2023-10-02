package com.controlefinanceiro.controller;

import java.util.List;

import com.controlefinanceiro.utils.DataUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.controlefinanceiro.model.Receita;
import com.controlefinanceiro.model.types.TipoReceita;
import com.controlefinanceiro.service.ReceitaService;

import jakarta.validation.Valid;

import javax.xml.crypto.Data;

@RestController
@RequestMapping("/api/receita")
public class ReceitaController {

    private final ReceitaService service;

    public ReceitaController(ReceitaService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
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

    @GetMapping("/{data}")
    public List<Receita> listReceitasByMes(@PathVariable String data){
        var dtInicial = DataUtils.convertStringToDate(data);
        var dtFinal = DataUtils.getLastDayofMonth(data);
        System.out.println(dtInicial + " "+dtFinal);
        return service.listReceitasByMes(dtInicial,dtFinal);
    }
    
    @GetMapping(value="/tiporeceita")
    public List<TipoReceita> listTipos(){
        return service.listTipos();
    }
}
