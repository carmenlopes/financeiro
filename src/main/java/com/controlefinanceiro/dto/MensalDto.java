package com.controlefinanceiro.dto;

import com.controlefinanceiro.model.Conta;
import com.controlefinanceiro.model.Despesa;
import com.controlefinanceiro.model.Meta;
import com.controlefinanceiro.model.Receita;

import java.util.List;

public class MensalDto {
    private List<Conta> contas;
    private List<Meta> metas;
    private List<Despesa> despesas;
    private List<Receita> receitas;
}
