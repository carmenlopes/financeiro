package com.controlefinanceiro.domain.port.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.controlefinanceiro.domain.model.Meta;

@Repository
public interface MetaRepository extends JpaRepository<Meta, Long> {

    List<Meta> findByNome(String nome);
}
