package com.controlefinanceiro.domain.port.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.controlefinanceiro.domain.model.Receita;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita,Long>{

    List<Receita> findAllByDtEntradaBetweenOrderByDtEntradaAsc(LocalDate dtEntradaInical,
                                                               LocalDate dtEntradaFinal);

}
