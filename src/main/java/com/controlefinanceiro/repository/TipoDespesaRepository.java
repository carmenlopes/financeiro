package com.controlefinanceiro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.controlefinanceiro.model.types.TipoDespesa;

@Repository
public interface TipoDespesaRepository extends JpaRepository<TipoDespesa, Long>{
    List<TipoDespesa> findByNome(String nome);
}
