package com.controlefinanceiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.controlefinanceiro.model.Receita;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita,Long>{
    
}
