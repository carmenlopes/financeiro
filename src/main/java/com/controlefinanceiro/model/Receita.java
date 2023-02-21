package com.controlefinanceiro.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data @Entity
public class Receita {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private Double valor;
    private LocalDate dtEntrada;

    //TODO: Gravar movimentação


    public void adicionarConta(Conta contaDestino) {
       double saldo = contaDestino.getSaldoTotal(); 
        saldo += this.valor;
        contaDestino.setSaldoTotal(saldo);
    }

}
