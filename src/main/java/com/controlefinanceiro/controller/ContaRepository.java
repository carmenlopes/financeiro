package com.controlefinanceiro.controller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.controlefinanceiro.model.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long>{
    
}
