package com.controlefinanceiro.domain.model.dto;

import com.controlefinanceiro.domain.model.types.TipoDespesa;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;
import lombok.Data;

import java.time.LocalDate;
@Data
public class DespesaDTO {
    private String nome;
    private Double valor;
    private LocalDate dtVencimento;
    private LocalDate dtFechamento; // usado apenas para despesa do tipo cartao
    private boolean despesaFixa;
    private Long idTipoDespesa;
    private int qtdRepeticao = 0;
}
