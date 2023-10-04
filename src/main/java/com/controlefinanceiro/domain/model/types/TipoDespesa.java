package com.controlefinanceiro.domain.model.types;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data @Entity
public class TipoDespesa {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String icon;
    
    public TipoDespesa(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public TipoDespesa(String nome, String icon) {
        this.nome = nome;
        this.icon = icon;
    }

    public TipoDespesa() {
    }
    
    
}
