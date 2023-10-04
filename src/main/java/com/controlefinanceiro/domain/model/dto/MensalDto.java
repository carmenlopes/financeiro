package com.controlefinanceiro.domain.model.dto;

import com.controlefinanceiro.domain.model.Conta;
import com.controlefinanceiro.domain.model.Despesa;
import com.controlefinanceiro.domain.model.Meta;
import com.controlefinanceiro.domain.model.Receita;

import java.util.List;

public class MensalDto {
    private List<Conta> contas;
    private List<Meta> metas;
    private List<Despesa> despesas;
    private List<Receita> receitas;
}
