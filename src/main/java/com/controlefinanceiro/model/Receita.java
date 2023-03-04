package com.controlefinanceiro.model;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Data;
import lombok.ToString;

@Data @Entity @ToString
public class Receita {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private TipoReceita tipoReceita;
    private Double valor;
    private LocalDate dtEntrada;
    @ManyToOne
    private Conta contaDestino;

    //TODO: Gravar movimentação


    public void adicionarConta(Conta contaDestino) {
       double saldo = contaDestino.getSaldoTotal(); 
        saldo += this.valor;
        contaDestino.setSaldoTotal(saldo);
    }

}
