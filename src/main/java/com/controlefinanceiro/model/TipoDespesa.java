package com.controlefinanceiro.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class TipoDespesa {
    private Long id;
    private String nome;
    private String icon;
    
    public TipoDespesa(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    
}
