package com.controlefinanceiro.application;

import com.controlefinanceiro.domain.port.usecase.ContaUseCase;
import com.controlefinanceiro.domain.port.usecase.DespesaUseCase;
import com.controlefinanceiro.domain.port.usecase.MetaUseCase;
import com.controlefinanceiro.domain.port.usecase.ReceitaUseCase;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseAPI {
    @Autowired
    protected ContaUseCase contaImpl;
    @Autowired
    protected MetaUseCase metaImpl;
    @Autowired
    protected ReceitaUseCase receitaImpl;
    @Autowired
    protected DespesaUseCase despesaImpl;
}
