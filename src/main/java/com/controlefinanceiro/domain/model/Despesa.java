package com.controlefinanceiro.domain.model;

import java.io.Serializable;
import java.time.LocalDate;

import com.controlefinanceiro.domain.model.types.TipoDespesa;
import jakarta.persistence.*;
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

    @ManyToOne
    private TipoDespesa tipoDespesa;

    public Despesa(String nome, Double valor, LocalDate dtVencimento, boolean despesaFixa, TipoDespesa tipoDespesa) {
        this.nome = nome;
        this.valor = valor;
        this.dtVencimento = dtVencimento;
        this.despesaFixa = despesaFixa;
        this.tipoDespesa = tipoDespesa;
    }

    public Despesa() {

    }

}
