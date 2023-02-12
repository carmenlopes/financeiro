package com.controlefinanceiro.model;

import java.time.LocalDate;

import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class Despesa {
    private Long id;
    private String nome;
    private Double valor;
    private LocalDate dtVencimento;
    private boolean despesaFixa;
    private boolean paga = false;
    @OneToOne
    private TipoDespesa tipoDespesa;
    @ManyToOne
    private Conta contaDePagamento;

    public Despesa(Long id, String nome, Double valor, LocalDate dtVencimento, boolean despesaFixa, boolean paga,
            TipoDespesa tipoDespesa, Conta contaDePagamento) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.dtVencimento = dtVencimento;
        this.despesaFixa = despesaFixa;
        this.paga = paga;
        this.tipoDespesa = tipoDespesa;
        this.contaDePagamento = contaDePagamento;
    }

    public void pagarDespesa(){
       contaDePagamento.removerDoSaldo(valor);
    }

}
