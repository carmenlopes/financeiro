package com.controlefinanceiro.application.controller;

import com.controlefinanceiro.application.BaseAPI;
import com.controlefinanceiro.domain.model.Conta;
import com.controlefinanceiro.domain.model.Despesa;
import com.controlefinanceiro.domain.model.Meta;
import com.controlefinanceiro.domain.model.Receita;
import com.controlefinanceiro.domain.model.dto.DespesaDTO;
import com.controlefinanceiro.domain.model.dto.ReceitaDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/financeiro")
public class FinancasController extends BaseAPI {

    @PostMapping("/criarconta")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Conta criarConta(@RequestBody @Valid Conta conta) throws Throwable {
        return contaImpl.criarConta(conta);
    }
    @PostMapping("/criarmeta/{nomemeta}")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Meta criarMeta(@RequestBody @Valid @PathVariable String nomemeta) throws Throwable {
        Meta m = new Meta();
        m.setNome(nomemeta);
        return metaImpl.criarMeta(m);
    }
    @PostMapping("/criareceita")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Receita criarReceita(@RequestBody @Valid ReceitaDTO receita) throws Throwable {
        return receitaImpl.criarReceita(receita);
    }
    @PostMapping("/criardespesa")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<List<Despesa>> criarDespesa(@RequestBody @Valid DespesaDTO despesa) throws Throwable {
        return ResponseEntity.ok(despesaImpl.criarDespesa(despesa));
    }
    @GetMapping("/contas")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Conta> contas(){
        return contaImpl.listarContas();
    }
    @GetMapping("/conta/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Optional<Conta> contaById(@PathVariable Long id){
        return contaImpl.buscarById(id);
    }

}
