package com.controlefinanceiro.domain.port.usecase;

import com.controlefinanceiro.domain.model.Receita;
import com.controlefinanceiro.domain.model.dto.ReceitaDTO;

import java.time.LocalDate;
import java.util.List;

public interface ReceitaUseCase {

    Receita criarReceita(ReceitaDTO receitaReq);
    Receita updateReceita(Receita receitaReq);
    List<Receita> listAll();
    List<Receita> listReceitasByMes(LocalDate inicial, LocalDate Final);

}
