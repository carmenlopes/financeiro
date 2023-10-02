package com.controlefinanceiro.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.controlefinanceiro.model.Despesa;
import com.controlefinanceiro.service.DespesaService;

@RestController
@RequestMapping("/api/despesa")
public class DespesaController {
    
    private final DespesaService service;

    public DespesaController(DespesaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Despesa> list(){
        return service.listAll();
    }
    
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<List<Despesa>> gravar(@RequestBody Despesa despesa) throws Throwable {
        List<Despesa> saved = new ArrayList<>();

        if(!despesa.isDespesaFixa()){
            return ResponseEntity.ok(Arrays.asList(service.create(despesa)));
        }else{
            for(int i= 0; i < despesa.getQtdRepeticao(); i++){
               Despesa d = new Despesa();
               d.setNome(despesa.getNome());
               d.setValor(despesa.getValor());
               d.setDtVencimento(despesa.getDtVencimento().plusMonths(i));
               d.setDespesaFixa(despesa.isDespesaFixa());
               //se não encontrar o tipo de despesa, cria uma nova
               d.setTipoDespesa(despesa.getTipoDespesa());
                saved.add(d);
            }
            service.createAll(saved);
            return ResponseEntity.ok(saved);
           
        }
    }
}
