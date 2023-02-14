package com.controlefinanceiro.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.controlefinanceiro.model.Meta;

@Repository
public interface MetaRepository extends JpaRepository<Meta, Long> {

    List<Meta> findByNome(String nome);
}
