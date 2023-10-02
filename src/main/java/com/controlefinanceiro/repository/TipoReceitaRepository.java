package com.controlefinanceiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.controlefinanceiro.model.types.TipoReceita;

@Repository
public interface TipoReceitaRepository extends JpaRepository<TipoReceita,Long> {
    
}
