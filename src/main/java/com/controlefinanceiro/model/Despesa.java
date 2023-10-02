package com.controlefinanceiro.model;

import java.io.Serializable;
import java.time.LocalDate;

import com.controlefinanceiro.model.types.TipoDespesa;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;
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

    @OneToOne
    private TipoDespesa tipoDespesa;
    @Transient
    private int qtdRepeticao = 0;

    public Despesa(String nome, Double valor, LocalDate dtVencimento, boolean despesaFixa, TipoDespesa tipoDespesa, int qtdRepeticao) {
        this.nome = nome;
        this.valor = valor;
        this.dtVencimento = dtVencimento;
        this.despesaFixa = despesaFixa;
        this.tipoDespesa = tipoDespesa;
        this.qtdRepeticao = qtdRepeticao;
    }

    public Despesa() {

    }

}
