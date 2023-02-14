package com.controlefinanceiro.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.coyote.RequestInfo;
import org.springframework.stereotype.Service;

import com.controlefinanceiro.model.Meta;
import com.controlefinanceiro.repository.MetaRepository;

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
}
