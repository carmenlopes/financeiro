package com.controlefinanceiro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.controlefinanceiro.model.Conta;
import com.controlefinanceiro.model.Despesa;
import com.controlefinanceiro.repository.ContaRepository;
import com.controlefinanceiro.repository.DespesaRepository;

import jakarta.validation.Valid;

@Service
public class DespesaService {

    private final DespesaRepository repository;

    private final ContaRepository repositoryConta;

    public DespesaService(DespesaRepository repository, ContaRepository repositoryConta) {
        this.repository = repository;
        this.repositoryConta = repositoryConta;
    }

    public List<Despesa> listAll() {
        return repository.findAll();
    }

    public @Valid Despesa create(@Valid Despesa req) {
        return repository.save(req);
    }

    public @Valid List<Despesa> createAll(List<Despesa> req) {
        return repository.saveAll(req);
    }

    public @Valid Optional<Despesa> update(@Valid Long id) {
        return repository.findById(id).map(despesa -> {
            Long ident = despesa.getContaDePagamento().getId();
            Conta conta = repositoryConta.findById(ident).get();
            conta.removerDoSaldo(despesa.getValor());
            despesa.setPaga(true);
            despesa.setContaDePagamento(conta);
            return despesa;
            });
    }
}
