package com.controlefinanceiro.domain.port.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.controlefinanceiro.domain.model.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long>{
    
    List<Conta> findByNome(String name);

    //TODO: jpql com conta movimentação para pegar o saldo mensal de uma conta
//    List<Conta> findSaldoByDtEntrada();

}
