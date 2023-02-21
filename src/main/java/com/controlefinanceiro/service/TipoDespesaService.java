package com.controlefinanceiro.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.controlefinanceiro.model.TipoDespesa;
import com.controlefinanceiro.repository.TipoDespesaRepository;

@Service
public class TipoDespesaService {

    private final TipoDespesaRepository repository;

    public TipoDespesaService(TipoDespesaRepository repository) {
        this.repository = repository;
    }

    public List<TipoDespesa> listAll() {
        return repository.findAll();
    }

    public TipoDespesa create(@Valid TipoDespesa req) {
        repository.findByNome(req.getNome()).stream()
                .findAny().ifPresent(c -> {
                    try {
                        throw new Exception("Tipo de despesa " + req.getNome() + " already exists.");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
        return repository.save(req);
    }
}
