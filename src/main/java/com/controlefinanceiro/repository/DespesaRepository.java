package com.controlefinanceiro.repository;

import com.controlefinanceiro.model.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DespesaRepository extends JpaRepository<Despesa,Long>{
    List<Despesa> findAllByDtVencimentoBetweenOrderByDtVencimentoAsc(LocalDate dtInical,
                                                                     LocalDate dtFinal);
    @Query("SELECT SUM(d.valor) FROM Despesa d WHERE d.dtVencimento BETWEEN :dataInicio AND :dataFim")
    Double calcularSomaDespesaByMes(@Param("dataInicio")LocalDate dataInicio,
                                           @Param("dataFim") LocalDate dataFim);
    
}
