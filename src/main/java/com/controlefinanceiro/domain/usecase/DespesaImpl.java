package com.controlefinanceiro.domain.usecase;

import com.controlefinanceiro.domain.model.Despesa;
import com.controlefinanceiro.domain.model.dto.DespesaDTO;
import com.controlefinanceiro.domain.model.types.TipoDespesa;
import com.controlefinanceiro.domain.port.repository.DespesaRepository;
import com.controlefinanceiro.domain.port.repository.TipoDespesaRepository;
import com.controlefinanceiro.domain.port.usecase.DespesaUseCase;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DespesaImpl implements DespesaUseCase {
    @Autowired
    private ModelMapper modelMapper;
    public final DespesaRepository repository;

    @Autowired
    public final TipoDespesaRepository tipoDespRepo;

    public DespesaImpl(DespesaRepository repository, TipoDespesaRepository tipoDespRepo) {
        this.repository = repository;
        this.tipoDespRepo = tipoDespRepo;
    }

    @Override
    public List<Despesa> criarDespesa(DespesaDTO despesa) {
        List<Despesa> saved = new ArrayList<>();
        Despesa desp = modelMapper.map(despesa, Despesa.class);
        if (!despesa.isDespesaFixa()) {
            return List.of(repository.save(desp));
        } else {
            for (int i = 0; i < despesa.getQtdRepeticao(); i++) {
                Despesa d = new Despesa();
                d.setNome(desp.getNome());
                d.setValor(desp.getValor());
                d.setDtVencimento(despesa.getDtVencimento().plusMonths(i));
                d.setTipoDespesa(tipoDespRepo.findTipoDispesaById(despesa.getIdTipoDespesa()));
                d.setDespesaFixa(true);
               if(d.getTipoDespesa().getNome().equals("Cartão")){
                   d.setDtFechamento(despesa.getDtFechamento().plusMonths(i));
               }
                saved.add(d);
            }
            repository.saveAll(saved);
            return saved;
        }
    }
}
