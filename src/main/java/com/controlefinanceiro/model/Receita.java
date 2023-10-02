package com.controlefinanceiro.model;

import java.time.LocalDate;

import com.controlefinanceiro.model.types.TipoReceita;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@ToString
public class Receita {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private Double valor;
    @ManyToOne
    @Enumerated(EnumType.STRING)
    private TipoReceita tipoReceita;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate dtEntrada;
    @ManyToOne
    private Conta contaDestino;

    public Receita() {
    }

    public Receita(String nome, Double valor, TipoReceita tipoReceita, LocalDate dtEntrada, Conta contaDestino) {
        this.nome = nome;
        this.valor = valor;
        this.tipoReceita = tipoReceita;
        this.dtEntrada = dtEntrada;
        this.contaDestino = contaDestino;
    }

    public void adicionarConta(Conta contaDestino) {
        double saldo = contaDestino.getSaldoTotal();
        saldo += this.valor;
        contaDestino.setSaldoTotal(saldo);
    }

}
