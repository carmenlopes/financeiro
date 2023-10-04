package com.controlefinanceiro.domain.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

public class ContaMovimentacao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double valor;
    private LocalDate dtEntrada;
}
