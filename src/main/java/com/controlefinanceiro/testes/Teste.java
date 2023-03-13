package com.controlefinanceiro.testes;


import com.controlefinanceiro.enums.TipoConta;
import com.controlefinanceiro.model.Conta;

public class Teste {
   public static void main(String[] args) {
       Conta conta = new Conta(1L, "Nu", 55.25, TipoConta.CORRENTE);
       System.out.println("CONTA1: "+conta);

    //    conta.transfDinheiroOutraConta(conta2, 25.00);
    //    System.out.println("Conta 1: "+conta.getSaldoTotal());
    //    System.out.println("Conta 2: "+conta2.getSaldoTotal());

    //    System.out.println("CONTA1: "+conta.toString() + " Conta2: "+conta2.toString());

    //    TipoDespesa tipoDespesa = new TipoDespesa(2L, "Cartão de Crédito");
    //    Despesa despesa = new Despesa(1L, "Cartao Nubank", 5.0, LocalDate.of(2023,02,20), false, false, tipoDespesa, conta);
    //    System.out.println("Valor inicial conta 1:"+conta.getSaldoTotal());
    //    System.out.println("Valor inicial conta 2:"+conta2.getSaldoTotal());


       conta.addNoSaldo(5.00);
       System.out.println("Valor agora é:"+conta.getSaldoTotal());

       System.out.println("Valor agora é:"+conta.getSaldoTotal());

    //    despesa.pagarDespesa();
       System.out.println("Valor agora após pagar conta é:"+conta.getSaldoTotal() + conta.getNome());

   }


}
