package com.controlefinanceiro;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

import com.controlefinanceiro.controller.ContaRepository;
import com.controlefinanceiro.enums.TipoConta;
import com.controlefinanceiro.model.Conta;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class ControlefinanceiroApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControlefinanceiroApplication.class, args);
	}

	@Bean
	CommandLineRunner initDataBase(ContaRepository contaRepository){
		return args ->{
			Conta c = new Conta();
			c.setNome("Itau Corrente");
			c.setSaldoTotal(0);
			c.setTipoConta(TipoConta.CORRENTE);
			contaRepository.save(c);
		};
	}

}
