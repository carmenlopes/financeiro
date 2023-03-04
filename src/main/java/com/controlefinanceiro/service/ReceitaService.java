package com.controlefinanceiro.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.controlefinanceiro.model.Receita;
import com.controlefinanceiro.model.TipoReceita;
import com.controlefinanceiro.repository.ContaRepository;
import com.controlefinanceiro.repository.ReceitaRepository;
import com.controlefinanceiro.repository.TipoReceitaRepository;

@Service
public class ReceitaService {

    public final TipoReceitaRepository tipoReceitaRepo;
    public final ReceitaRepository receitaRepo;
    public final ContaRepository contaRepo;
    
    public ReceitaService(TipoReceitaRepository tipoReceitaRepo, ReceitaRepository receitaRepo,
            ContaRepository contaRepo) {
        this.tipoReceitaRepo = tipoReceitaRepo;
        this.receitaRepo = receitaRepo;
        this.contaRepo = contaRepo;
    }

    public @Valid TipoReceita createTipoReceita(@Valid TipoReceita req) {
        return tipoReceitaRepo.save(req);
    }

    public @Valid Receita createReceita(@Valid Receita req) {
            contaRepo.findById(req.getContaDestino().getId()).map(conta -> {
                req.adicionarConta(conta);
                return contaRepo.save(conta);
            });
        return receitaRepo.save(req);
    }

    public List<TipoReceita> listTipos(){
        return tipoReceitaRepo.findAll();
    }

    public List<Receita> listReceitas(){
        return receitaRepo.findAll();
    }

    
}