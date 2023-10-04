package com.controlefinanceiro.domain.port.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.controlefinanceiro.domain.model.types.TipoDespesa;

@Repository
public interface TipoDespesaRepository extends JpaRepository<TipoDespesa, Long>{
    List<TipoDespesa> findByNome(String nome);

    TipoDespesa findTipoDispesaById(Long id);
}
