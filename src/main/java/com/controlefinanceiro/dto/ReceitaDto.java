package com.controlefinanceiro.dto;

import com.controlefinanceiro.model.Conta;
import com.controlefinanceiro.model.types.TipoReceita;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ReceitaDto {
    private String nome;
    private Double valor;
    private String tipoReceita;
    private LocalDate dtEntrada;
}
