package com.controlefinanceiro.dto;

import com.controlefinanceiro.model.Conta;

import lombok.Data;

@Data
public class TransferenciaDto {
    private Conta contaOrigem;
    private Conta contaDestino;
    private double valor;

}
