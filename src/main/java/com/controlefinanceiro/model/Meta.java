package com.controlefinanceiro.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import com.controlefinanceiro.interfaces.Transacoes;
import lombok.Data;

@Data
@Entity
public class Meta  implements Transacoes{

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private double saldoTotal;
    private double valorEsperado;
    private double metaMensal;

    public Meta(Long id, String nome, double saldoTotal, double valorEsperado, double metaMensal) {
        this.id = id;
        this.nome = nome;
        this.saldoTotal = saldoTotal;
        this.valorEsperado = valorEsperado;
        this.metaMensal = metaMensal;
    }

    public Meta() {
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
