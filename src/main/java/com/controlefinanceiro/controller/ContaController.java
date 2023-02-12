package com.controlefinanceiro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controlefinanceiro.model.Conta;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/conta")
public class ContaController {

	@Autowired
    private final ContaRepository contaRepository;

    public ContaController(ContaRepository contaRepository) {
		this.contaRepository = contaRepository;
	}

	@GetMapping
    public List<Conta> list(){
        return contaRepository.findAll();
    }
    
}
