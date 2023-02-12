package com.controlefinanceiro.model;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.controlefinanceiro.enums.TipoConta;
import com.controlefinanceiro.interfaces.Transacoes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter @ToString
@Entity
public class Conta implements Transacoes {
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getSaldoTotal() {
		return saldoTotal;
	}

	public void setSaldoTotal(double saldoTotal) {
		this.saldoTotal = saldoTotal;
	}

	public TipoConta getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(TipoConta tipoConta) {
		this.tipoConta = tipoConta;
	}

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 200, nullable = false)
    private String nome;
    private double saldoTotal;
    @Column(length = 20, nullable = false)
    private TipoConta tipoConta;

    // public Conta(Long id, String nome, double saldoTotal, TipoConta tipoConta) {
    //     this.id = id;
    //     this.nome = nome;
    //     this.saldoTotal = saldoTotal;
    //     this.tipoConta = tipoConta;
    // }

    public Conta() {
    }

    public void transfDinheiroOutraConta(Conta conta, double valorATransferir) {
        if (this.saldoTotal >= valorATransferir) {
            conta.addNoSaldo(valorATransferir);
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
        this.saldoTotal += valorEntrante;
    }

    @Override
    public void removerDoSaldo(double valorSaida) {
        this.saldoTotal -= valorSaida;

    }
}
