package com.controlefinanceiro.domain.port.usecase;

import com.controlefinanceiro.domain.model.Meta;

import java.util.List;

public interface MetaUseCase {

    List<Meta> listAll();
    Meta criarMeta(Meta metaReq) throws Exception;
    Meta updateMeta(Meta metaReq);

}
