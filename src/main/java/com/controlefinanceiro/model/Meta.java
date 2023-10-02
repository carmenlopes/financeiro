package com.controlefinanceiro.model;

import com.controlefinanceiro.interfaces.Transacoes;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Entity @Getter @Setter
public class Meta implements Transacoes{

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private double saldoTotal;
    private double totalGuardado;
    @OneToMany
    @JoinColumn(name = "meta_id")
    private List<MetaMovimentacao> transacoes;

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
