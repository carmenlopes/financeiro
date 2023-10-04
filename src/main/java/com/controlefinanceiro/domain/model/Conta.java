package com.controlefinanceiro.domain.model;

import com.controlefinanceiro.domain.model.enums.TipoConta;
import com.controlefinanceiro.domain.port.interfaces.Transacoes;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter @ToString
@Entity
public class Conta implements Transacoes {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private double saldoTotal;
    @Enumerated(EnumType.STRING)
    private TipoConta tipoConta;
    public Conta() {
    }

    public Conta(String nome, double saldoTotal, TipoConta tipoConta) {
        this.nome = nome;
        this.saldoTotal = saldoTotal;
        this.tipoConta = tipoConta;
    }

    public Conta(Long id, String nome, double saldoTotal, TipoConta tipoConta) {
        this.id = id;
        this.nome = nome;
        this.saldoTotal = saldoTotal;
        this.tipoConta = tipoConta;
    }

    public void transfDinheiroOutraConta(Conta contaDestino, double valorATransferir) {
        if (this.saldoTotal >= valorATransferir) {
            contaDestino.addNoSaldo(valorATransferir);
            this.removerDoSaldo(valorATransferir);
        }
    }

    public void transfDinheiroParaMeta(Meta meta, double valorATransferir) {
        if (this.saldoTotal >= valorATransferir) {
            meta.addNoSaldo(valorATransferir);
            this.removerDoSaldo(valorATransferir);
        }
    }

    @Override
    public void addNoSaldo(double valorEntrante) {
        this.saldoTotal = this.saldoTotal + valorEntrante;
    }

    @Override
    public void removerDoSaldo(double valorSaida) {
        this.saldoTotal -= valorSaida;

    }
}
