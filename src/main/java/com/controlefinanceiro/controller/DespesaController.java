package com.controlefinanceiro.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
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
    public List<Despesa> gravar(@RequestBody @Valid Despesa despesa) throws Throwable {
        List<Despesa> despesas = new ArrayList<>();

        if(!despesa.isDespesaFixa()){
            return List.of(service.create(despesa));
        }else{
            for(int i= 0; i < despesa.getQtdRepeticao();i++){
                service.create(despesa);
                despesas.add(despesa);
                Despesa clonador = despesa.clonarObjeto();
                LocalDate repete = clonador.getDtVencimento().plusMonths(1);
                clonador.setDtVencimento(repete);
                service.create(despesa);
                despesas.add(clonador);

            }
            return despesas;
           
        }
    }

    //TODO:Pagar despesa
}
