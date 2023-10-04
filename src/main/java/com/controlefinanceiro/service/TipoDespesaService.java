package com.controlefinanceiro.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.controlefinanceiro.domain.model.types.TipoDespesa;
import com.controlefinanceiro.domain.port.repository.TipoDespesaRepository;

import jakarta.validation.Valid;

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
