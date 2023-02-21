package com.controlefinanceiro.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;

@Data @Entity
public class Despesa implements Cloneable {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private Double valor;
    private LocalDate dtVencimento;
    private boolean despesaFixa;
    private int qtdRepeticao = 0;
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
       this.paga = true;
    }

    public Despesa clonarObjeto() throws CloneNotSupportedException{
        
        return (Despesa) clone();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return (Despesa) super.clone();
    }

}
