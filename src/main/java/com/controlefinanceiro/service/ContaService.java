package com.controlefinanceiro.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Service;

import com.controlefinanceiro.dto.MetaDto;
import com.controlefinanceiro.dto.TransferenciaDto;
import com.controlefinanceiro.exception.RecordNotFoundException;
import com.controlefinanceiro.model.Conta;
import com.controlefinanceiro.model.Meta;
import com.controlefinanceiro.repository.ContaRepository;
import com.controlefinanceiro.repository.MetaRepository;

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

    public Optional<Meta> transferenciaParaMeta(@Valid MetaDto transf) {
        Optional<Meta> destino = metaRepository.findById(transf.getMetaDestinada().getId()).map(dest -> {
            repository.findById(transf.getContaOrigem().getId()).map(origem -> {
                origem.transfDinheiroParaMeta(dest, transf.getValor());
                return repository.save(origem);
            });
            return metaRepository.save(dest);
        });
            return destino;
    }
}