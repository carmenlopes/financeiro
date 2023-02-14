package com.controlefinanceiro.dto;

import com.controlefinanceiro.model.Conta;
import com.controlefinanceiro.model.Meta;

import lombok.Data;

@Data
public class MetaDto {
    private Conta contaOrigem;
    private Meta metaDestinada;
    private double valor;
}
