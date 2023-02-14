package com.controlefinanceiro;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.controlefinanceiro.enums.TipoConta;
import com.controlefinanceiro.model.Conta;
import com.controlefinanceiro.repository.ContaRepository;
import com.controlefinanceiro.repository.MetaRepository;

@SpringBootApplication
public class ControlefinanceiroApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ControlefinanceiroApplication.class, args);
	}

	@Autowired
	private ContaRepository repo;


	@Override
	public void run(String... args) throws Exception {
		repo.save(new Conta("Itau",100, TipoConta.CORRENTE));
		repo.save(new Conta("Nubank",125, TipoConta.CORRENTE));


	}

}
