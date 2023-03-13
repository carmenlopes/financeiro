package com.controlefinanceiro.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Movimentacao {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private double valor;
    private LocalDate dtEntrada;
    private String tipoMovimentacao;
    private Long idMovimentacao;
    @OneToOne
    private Conta contaTransacao;
}
