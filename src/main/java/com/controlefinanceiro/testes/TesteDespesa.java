package com.controlefinanceiro.testes;

import java.time.LocalDate;

import com.controlefinanceiro.enums.TipoConta;
import com.controlefinanceiro.model.Conta;
import com.controlefinanceiro.model.Despesa;
import com.controlefinanceiro.model.TipoDespesa;

public class TesteDespesa {
   public static void main(String[] args) throws CloneNotSupportedException {
       Conta conta = new Conta(1L, "Nu", 55.25, TipoConta.CORRENTE);
       System.out.println("CONTA1: "+conta);

       TipoDespesa tipoDespesa = new TipoDespesa(2L, "Cartão de Crédito");
       Despesa despesa = new Despesa(1L, "Cartao Nubank", 5.0, LocalDate.of(2023,02,20), false, false, tipoDespesa, conta);
      
       System.out.println("MESES: "+despesa.getDtVencimento().plusMonths(12));
       System.out.println("Despesa 1: "+despesa);
       
       System.out.println(despesa.getClass().toString());
    //    despesa.pagarDespesa();

   }


}
