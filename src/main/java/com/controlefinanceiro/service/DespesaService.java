package com.controlefinanceiro.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.controlefinanceiro.model.Despesa;
import com.controlefinanceiro.repository.DespesaRepository;

@Service
public class DespesaService {

    private final DespesaRepository repository;

    public DespesaService(DespesaRepository repository) {
        this.repository = repository;
    }

    public List<Despesa> listAll() {
        return repository.findAll();
    }

    public @Valid Despesa create(@Valid Despesa req) {
        return repository.save(req);
    }

    public @Valid List<Despesa> createAll( List<Despesa> req) {
        return repository.saveAll(req);
    }
}
