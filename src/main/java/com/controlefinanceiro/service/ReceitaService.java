package com.controlefinanceiro.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.controlefinanceiro.model.Receita;
import com.controlefinanceiro.model.types.TipoReceita;
import com.controlefinanceiro.repository.ContaRepository;
import com.controlefinanceiro.repository.ReceitaRepository;
import com.controlefinanceiro.repository.TipoReceitaRepository;

import jakarta.validation.Valid;

@Service
public class ReceitaService {
    // private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ReceitaService.class);


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
               TipoReceita t = tipoReceitaRepo.findById(req.getTipoReceita().getId()).get();
               req.setTipoReceita(t);
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

    public List<Receita> listReceitasByMes(LocalDate inicial, LocalDate Final){
        return receitaRepo.findAllByDtEntradaBetweenOrderByDtEntradaAsc(inicial,Final);
    }


    public Double listSomaReceitasByMes(LocalDate dtInicial, LocalDate dtFinal) {
        return null;
    }
}
