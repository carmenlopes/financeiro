package com.controlefinanceiro.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.controlefinanceiro.model.Movimentacao;
import com.controlefinanceiro.repository.MovimentarRepository;

import jakarta.validation.Valid;

@Service
public class MovimentacaoService {
    
    private final MovimentarRepository repository;

    public MovimentacaoService(MovimentarRepository repository) {
        this.repository = repository;
    }

    public List<Movimentacao> listAll() {
        return repository.findAll();
    }

    public Movimentacao create(@Valid Movimentacao movimentacao) {
        return repository.save(movimentacao);
    }
}
