package com.controlefinanceiro.service;

import com.controlefinanceiro.utils.exception.RecordNotFoundException;
import com.controlefinanceiro.domain.model.Conta;
import com.controlefinanceiro.domain.port.repository.ContaRepository;
import com.controlefinanceiro.domain.port.repository.MetaRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContaService {

    public final ContaRepository repository;

    public final MetaRepository metaRepository;

   

    public ContaService(ContaRepository repository, MetaRepository metaRepository) {
        this.repository = repository;
        this.metaRepository = metaRepository;
    }

    public List<Conta> listAll() {
        return repository.findAll();
    }

    public Conta create(@Valid Conta contaRequest) {
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

    public Conta updateNome(@NotNull Long id, @Valid Conta conta) {
        return repository.findById(id).map(actual -> {
            actual.setNome(conta.getNome());
            return repository.save(actual);
        })
        .orElseThrow(() -> new RecordNotFoundException(id));
    }

}