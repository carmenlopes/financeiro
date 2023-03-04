package com.controlefinanceiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.controlefinanceiro.model.Movimentacao;

@Repository
public interface MovimentarRepository extends JpaRepository <Movimentacao,Long> {
    

}
