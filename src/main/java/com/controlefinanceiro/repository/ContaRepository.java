package com.controlefinanceiro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.controlefinanceiro.model.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long>{
    
    List<Conta> findByNome(String name);

}
