package com.controlefinanceiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.controlefinanceiro.model.Despesa;

@Repository
public interface DespesaRepository extends JpaRepository<Despesa,Long>{
    
}
