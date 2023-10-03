package com.controlefinanceiro.repository;

import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.controlefinanceiro.model.Receita;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita,Long>{

    List<Receita> findAllByDtEntradaBetweenOrderByDtEntradaAsc(LocalDate dtEntradaInical,
                                                               LocalDate dtEntradaFinal);

}
