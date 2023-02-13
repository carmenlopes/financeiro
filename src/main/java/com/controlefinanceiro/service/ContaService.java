package com.controlefinanceiro.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Service;

import com.controlefinanceiro.controller.TransferenciaDto;
import com.controlefinanceiro.exception.RecordNotFoundException;
import com.controlefinanceiro.model.Conta;
import com.controlefinanceiro.repository.ContaRepository;

@Service
public class ContaService {

    public final ContaRepository repository;

    public ContaService(ContaRepository repository) {
        this.repository = repository;
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

    public Optional<Conta> transferenciaEntreContas(@Valid TransferenciaDto transf) {
        System.out.println("inicio assim: "+transf.toString());
        Optional<Conta> destino = repository.findById(transf.getContaDestino().getId()).map(dest ->{

                repository.findById(transf.getContaOrigem().getId()).map((origin) -> {
                    System.out.println("Destino antes transf ----> "+dest.toString());
                    origin.transfDinheiroOutraConta(dest, transf.getValor());
                    return repository.save(origin);
                });

                return repository.save(dest);
            });
            return destino;

    }
}
