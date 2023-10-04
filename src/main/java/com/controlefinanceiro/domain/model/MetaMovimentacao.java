package com.controlefinanceiro.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.time.LocalDate;
@Entity
@Data @ToString @Getter @Setter
public class MetaMovimentacao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double valor;
    private LocalDate dtEntrada;
}
