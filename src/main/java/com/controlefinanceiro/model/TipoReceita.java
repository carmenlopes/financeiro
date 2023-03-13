package com.controlefinanceiro.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity @Data
public class TipoReceita {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String icon;

    public TipoReceita() {
    }

    public TipoReceita(Long id, String nome, String icon) {
        this.id = id;
        this.nome = nome;
        this.icon = icon;
    }

    public TipoReceita(String nome, String icon) {
        this.nome = nome;
        this.icon = icon;
    }

    

}