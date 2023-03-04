package com.controlefinanceiro.enums;

public enum MovimentacaoTipo {
    META ("META"),
    DESPESA("DESPESA"),
    RECEITA("RECEITA"),
    UNKNOW("UNKNOW");

    String value;

    MovimentacaoTipo(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
