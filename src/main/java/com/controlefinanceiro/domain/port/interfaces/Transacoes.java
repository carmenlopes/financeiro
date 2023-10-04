package com.controlefinanceiro.domain.port.interfaces;

public interface Transacoes {

    public void addNoSaldo(double valorEntrante);
    public void removerDoSaldo(double valorSaida);

}
