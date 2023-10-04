package com.controlefinanceiro.domain.usecase;

import com.controlefinanceiro.domain.model.Conta;
import com.controlefinanceiro.domain.port.repository.ContaRepository;
import com.controlefinanceiro.domain.port.repository.MetaRepository;
import com.controlefinanceiro.domain.port.usecase.ContaUseCase;
import com.controlefinanceiro.utils.exception.RecordNotFoundException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.Optional;

public class ContaImpl implements ContaUseCase {

    public final ContaRepository repository;

    public final MetaRepository metaRepository;

    public ContaImpl(ContaRepository repository, MetaRepository metaRepository) {
        this.repository = repository;
        this.metaRepository = metaRepository;
    }

    @Override
    public Conta criarConta(@Valid Conta contaRequest) {
        repository.findByNome(contaRequest.getNome()).stream()
                .findAny().ifPresent(c -> {
                    try {
                        throw new Exception("Conta " + contaRequest.getNome() + " already exists.");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
        return repository.save(contaRequest);
    }

    @Override
    public Conta updateNome(@NotNull Long id, @Valid Conta conta) {
        return repository.findById(id).map(actual -> {
                    actual.setNome(conta.getNome());
                    return repository.save(actual);
                })
                .orElseThrow(() -> new RecordNotFoundException(id));
    }
    @Override
    public List<Conta> listarContas() {
        return repository.findAll();
    }

    @Override
    public Optional<Conta> buscarById(Long id) {
        return repository.findById(id);
    }
}
