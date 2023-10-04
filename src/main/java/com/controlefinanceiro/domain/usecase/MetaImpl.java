package com.controlefinanceiro.domain.usecase;

import com.controlefinanceiro.domain.model.Meta;
import com.controlefinanceiro.domain.port.repository.MetaRepository;
import com.controlefinanceiro.domain.port.usecase.MetaUseCase;

import java.util.List;
import java.util.Optional;

public class MetaImpl implements MetaUseCase {

    public final MetaRepository repository;

    public MetaImpl(MetaRepository repository) {
        this.repository = repository;
    }
    @Override
    public List<Meta> listAll() {
        return repository.findAll();
    }
    @Override
    public Meta criarMeta(Meta request) throws Exception {
        Optional<Meta> optional = repository.findByNome(request.getNome()).stream().findAny();
        if(optional.isPresent()){
            throw new Exception("Meta Já existe");
        }else{
            return repository.save(request);
        }    }

    @Override
    public Meta updateMeta(Meta metaReq) {
        //TODO: Fazer o update da meta
        return null;
    }
}
