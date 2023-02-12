package com.controlefinanceiro.model;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class Cartao extends Despesa {
    
    private LocalDate dtFechamento;

    public Cartao(Long id, String nome, Double valor, LocalDate dtVencimento, boolean despesaFixa, boolean paga,
            TipoDespesa tipoDespesa, Conta contaDePagamento, LocalDate dtFechamento) {
        super(id, nome, valor, dtVencimento, despesaFixa, paga, tipoDespesa, contaDePagamento);
        this.dtFechamento = dtFechamento;
    }

//    @Override
//    public String toString() {
//        return "Cartao ["+"Nome cartão= "+getNome()+" Valor= "+getValor()+" DataVencimento= "+getDtVencimento()+
//        " DespesaFixa= "+isDespesaFixa()+", dtFechamento=" + dtFechamento + "]";
//    }

    
}
