package com.controlefinanceiro.domain.port.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.controlefinanceiro.domain.model.types.TipoReceita;

@Repository
public interface TipoReceitaRepository extends JpaRepository<TipoReceita,Long> {
    
}
