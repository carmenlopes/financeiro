package com.controlefinanceiro.application.config;

import com.controlefinanceiro.domain.port.repository.*;
import com.controlefinanceiro.domain.port.usecase.ContaUseCase;
import com.controlefinanceiro.domain.port.usecase.DespesaUseCase;
import com.controlefinanceiro.domain.port.usecase.MetaUseCase;
import com.controlefinanceiro.domain.port.usecase.ReceitaUseCase;
import com.controlefinanceiro.domain.usecase.ContaImpl;
import com.controlefinanceiro.domain.usecase.DespesaImpl;
import com.controlefinanceiro.domain.usecase.MetaImpl;
import com.controlefinanceiro.domain.usecase.ReceitaImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
    @Bean
    ContaUseCase conta(ContaRepository contaRepository, MetaRepository metaRepository) {
        return new ContaImpl(contaRepository, metaRepository);
    }
    @Bean
    ReceitaUseCase receita(ReceitaRepository repository){
        return new ReceitaImpl(repository);
    }

    @Bean
    MetaUseCase meta(MetaRepository repository){ return new MetaImpl(repository);}
    @Bean
    DespesaUseCase despesa(DespesaRepository repository, TipoDespesaRepository tipoDespesaRepository){
        return new DespesaImpl(repository, tipoDespesaRepository);
    }
}
