package com.controlefinanceiro;

import com.controlefinanceiro.domain.model.Despesa;
import com.controlefinanceiro.domain.model.Receita;
import com.controlefinanceiro.domain.port.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.controlefinanceiro.domain.model.enums.TipoConta;
import com.controlefinanceiro.domain.model.Conta;
import com.controlefinanceiro.domain.model.types.TipoDespesa;
import com.controlefinanceiro.domain.model.types.TipoReceita;

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
	private ReceitaRepository receitaRepo;
	@Autowired
	private TipoDespesaRepository repoTipo;
	@Autowired
	private TipoReceitaRepository repoReceita;

	@Override
	public void run(String... args) throws Exception {
		var conta1 = new Conta("Itau",100, TipoConta.CORRENTE);
		repo.save(conta1);
		repo.save(new Conta("Nubank",125, TipoConta.POUPANCA));

		var td0 = (new TipoDespesa("Cartão", ""));
		var td1 = (new TipoDespesa("Internet", ""));
		var td2 = (new TipoDespesa("Celular", ""));
		var td3 = (new TipoDespesa("Laser", ""));
		repoTipo.save(td0);
		repoTipo.save(td1);
		repoTipo.save(td2);
		repoTipo.save(td3);

		despRepo.save(new Despesa("Espaço Laser",150.50, LocalDate.of(2023,10,20),
				true, td3));

		var tipoRecSalario = new TipoReceita("Salario", "");
		repoReceita.save(tipoRecSalario);

		var receita1 = new Receita("Salário",5456.88, tipoRecSalario, LocalDate.now(),conta1);
		var receita2 = new Receita("Salário",5456.88, tipoRecSalario, LocalDate.of(2023,10,10),conta1);
		var receita3 = new Receita("Salário",500.88, tipoRecSalario, LocalDate.of(2023,11,10),conta1);
		var receita4 = new Receita("PLR",200.00, tipoRecSalario, LocalDate.of(2023,10,1),conta1);

		receitaRepo.save(receita1);
		receitaRepo.save(receita2);
		receitaRepo.save(receita3);
		receitaRepo.save(receita4);




	}

}
