package com.controlefinanceiro.domain.port.usecase;

import com.controlefinanceiro.domain.model.Despesa;
import com.controlefinanceiro.domain.model.dto.DespesaDTO;

import java.util.List;

public interface DespesaUseCase {
    List<Despesa> criarDespesa(DespesaDTO despesa);
}
