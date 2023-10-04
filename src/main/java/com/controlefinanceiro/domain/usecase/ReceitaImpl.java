package com.controlefinanceiro.domain.usecase;

import com.controlefinanceiro.domain.model.Receita;
import com.controlefinanceiro.domain.model.dto.ReceitaDTO;
import com.controlefinanceiro.domain.model.types.TipoReceita;
import com.controlefinanceiro.domain.port.repository.ReceitaRepository;
import com.controlefinanceiro.domain.port.usecase.ReceitaUseCase;
import com.controlefinanceiro.utils.exception.RecordNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;

import java.time.LocalDate;
import java.util.List;

public class ReceitaImpl implements ReceitaUseCase {
    @Autowired
    private ModelMapper modelMapper;
    public final ReceitaRepository receitaRepo;

    public ReceitaImpl(ReceitaRepository receitaRepo) {
        this.receitaRepo = receitaRepo;
    }
    @Override
    public Receita criarReceita(ReceitaDTO req) {
       Receita receita = modelMapper.map(req, Receita.class);
        return receitaRepo.save(receita);
    }
    @Override
    public Receita updateReceita(Receita receitaReq) {
        return receitaRepo.findById(receitaReq.getId()).map(actual -> {
                    actual.setNome(receitaReq.getConta().getNome());
                    return receitaRepo.save(actual);
                })
                .orElseThrow(() -> new RecordNotFoundException(receitaReq.getId()));
    }
    @Override
    public List<Receita> listAll() {
        return receitaRepo.findAll();
    }
    @Override
    public List<Receita> listReceitasByMes(LocalDate inicial, LocalDate Final) {
        return receitaRepo.findAllByDtEntradaBetweenOrderByDtEntradaAsc(inicial, Final);
    }

}
