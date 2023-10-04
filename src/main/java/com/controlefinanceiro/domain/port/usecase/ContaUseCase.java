package com.controlefinanceiro.domain.port.usecase;

import com.controlefinanceiro.domain.model.Conta;

import java.util.List;
import java.util.Optional;

public interface ContaUseCase {

    Conta criarConta(Conta conta);

    Conta updateNome(Long id, Conta conta);

    List<Conta> listarContas();
    Optional<Conta> buscarById(Long id);

    Optional<Conta> buscarSaldoContaByMes(String data);
}
