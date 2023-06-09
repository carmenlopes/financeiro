package com.controlefinanceiro;

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

@SpringBootApplication
public class ControlefinanceiroApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ControlefinanceiroApplication.class, args);
	}

	@Autowired
	private ContaRepository repo;

	@Autowired
	private TipoDespesaRepository repoTipo;

	@Autowired
	private TipoReceitaRepository repoReceita;

	@Override
	public void run(String... args) throws Exception {
		repo.save(new Conta("Itau",100, TipoConta.CORRENTE));
		repo.save(new Conta("Nubank",125, TipoConta.CORRENTE));
		repoTipo.save((new TipoDespesa("Internet", "")));

		repoReceita.save(new TipoReceita("Salario", ""));


	}

}
