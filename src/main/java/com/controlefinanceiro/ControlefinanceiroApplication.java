package com.controlefinanceiro;

import com.controlefinanceiro.model.Despesa;
import com.controlefinanceiro.repository.DespesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.controlefinanceiro.enums.TipoConta;
import com.controlefinanceiro.model.Conta;
import com.controlefinanceiro.model.TipoDespesa;
import com.controlefinanceiro.model.TipoReceita;
import com.controlefinanceiro.repository.ContaRepository;
import com.controlefinanceiro.repository.TipoDespesaRepository;
import com.controlefinanceiro.repository.TipoReceitaRepository;

import java.time.LocalDate;

@SpringBootApplication
public class ControlefinanceiroApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ControlefinanceiroApplication.class, args);
	}

	@Autowired
	private ContaRepository repo;
	@Autowired
	private DespesaRepository despRepo;

	@Autowired
	private TipoDespesaRepository repoTipo;

	@Autowired
	private TipoReceitaRepository repoReceita;

	@Override
	public void run(String... args) throws Exception {
		var conta1 = new Conta("Itau",100, TipoConta.CORRENTE);
		repo.save(conta1);
		repo.save(new Conta("Nubank",125, TipoConta.CORRENTE));

		var td1 = (new TipoDespesa("Internet", ""));
		var td2 = (new TipoDespesa("Celular", ""));
		var td3 = (new TipoDespesa("Laser", ""));
		repoTipo.save(td1);
		repoTipo.save(td2);
		repoTipo.save(td3);

		despRepo.save(new Despesa("Espaço Laser",150.50, LocalDate.of(2023,10,20),
				true,false,td3, conta1, 2));
		repoReceita.save(new TipoReceita("Salario", ""));


	}

}
