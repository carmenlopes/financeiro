package com.controlefinanceiro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.controlefinanceiro.dto.MetaEditReq;
import com.controlefinanceiro.model.Meta;
import com.controlefinanceiro.repository.MetaRepository;

import jakarta.validation.Valid;

@Service
public class MetaService {
    
    private MetaRepository repository;

    public MetaService(MetaRepository repository) {
        this.repository = repository;
    }

    public List<Meta> listAll() {
        return repository.findAll();
    }

    public Meta create(@Valid Meta request) throws Exception {
        Optional<Meta> optional = repository.findByNome(request.getNome()).stream().findAny();
        if(optional.isPresent()){
            throw new Exception("Meta Já existe");
        }else{
            return repository.save(request);
        }
    }

    
    public @Valid Optional<Meta> update(@Valid Long id, MetaEditReq req) {
        return repository.findById(id).map(meta -> {
            if(!req.getNome().isEmpty()){
                meta.setNome(req.getNome());
            }
            if(req.getMetaMensal() != 0){
                meta.setMetaMensal(req.getMetaMensal());
            }
            return repository.save(meta);
        });
    }

    public @Valid Optional<Meta> guardarNaMeta(@Valid Long id, Meta req) {
        return repository.findById(id).map(meta -> {
           meta.addNoSaldo(req.getValorEsperado());
            return repository.save(meta);
        });
    }

    public @Valid Optional<Meta> resgatardaMeta(@Valid Long id, Meta req) {
        return repository.findById(id).map(meta -> {
           meta.removerDoSaldo(req.getValorEsperado());
            return repository.save(meta);
        });
    }


    //TODO: HISTORICO DE MOVIMENTACAO DE CADA META
}
