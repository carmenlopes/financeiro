package com.controlefinanceiro.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import lombok.Data;

@Data @Entity
public class Despesa implements Cloneable, Serializable {
    private static final long serialVersionUID = -2420346134960559062L;

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nome;
    private Double valor;
    private LocalDate dtVencimento;
    private LocalDate dtFechamento; // usado apenas para despesa do tipo cartao
    private boolean despesaFixa;
    private boolean paga = false;
    
    @OneToOne
    private TipoDespesa tipoDespesa;
    @ManyToOne
    private Conta contaDePagamento;

    @Transient
    private int qtdRepeticao = 0;

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

    public Despesa() {
    }

    // public void pagarDespesa(){
    //    contaDePagamento.removerDoSaldo(valor);
    //    this.paga = true;
    // }
}
