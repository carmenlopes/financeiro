package com.controlefinanceiro.model;

import java.time.LocalDate;

import com.controlefinanceiro.interfaces.Transacoes;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class Meta  implements Transacoes{

    private Long id;
    private String nome;
    private double saldoTotal;
    private double valorEsperado;
    private double metaMensal;
    private LocalDate dataLimte;

    public Meta(Long id, String nome, double saldoTotal, double valorEsperado, double metaMensal, LocalDate dataLimte) {
        this.id = id;
        this.nome = nome;
        this.saldoTotal = saldoTotal;
        this.valorEsperado = valorEsperado;
        this.metaMensal = metaMensal;
        this.dataLimte = dataLimte;
    }

    @Override
    public void addNoSaldo(double valorEntrante) {
        this.saldoTotal += valorEntrante;
        
    }

    @Override
    public void removerDoSaldo(double valorSaida) {
        if(saldoTotal >= valorSaida){
            this.saldoTotal -= valorSaida;
        }
        
    }

   
    
}
